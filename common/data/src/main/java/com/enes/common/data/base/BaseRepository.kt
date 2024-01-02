package com.enes.common.data.base

import com.enes.common.data.dto.NetworkError
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
            println("Response: $response")
            if (response.isSuccessful) {
                val model = response.body()!!
                emit(NetworkWrapper.Success(model))
            } else {
                val networkError = NetworkError()
                networkError.apiMessage = response.message()
                networkError.errorcode = response.code()
                emit(NetworkWrapper.Error(networkError))
            }
        }.catch { exception ->
            emit(NetworkWrapper.Error(NetworkError(exception)))
        }
    }
}