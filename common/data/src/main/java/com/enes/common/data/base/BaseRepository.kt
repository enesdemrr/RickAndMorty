package com.enes.common.data.base

import com.enes.common.data.dto.NetworkWrapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import retrofit2.Response

abstract class BaseRepository {
    protected suspend fun <T> safeApiCall(
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        call: suspend () -> Response<T>
    ): Flow<NetworkWrapper<T>> = withContext(dispatcher) {
        flow {
            val response = call.invoke()
            if (response.isSuccessful) {
                val model = response.body()!!
                emit(NetworkWrapper.Success(model))
            } else {
                emit(NetworkWrapper.Error(response.message()))
            }
        }.catch { exception ->
            emit(NetworkWrapper.Error(exception.localizedMessage?.toString().toString()))
        }
    }
}

