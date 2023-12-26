package com.enes.common.data.utils

import com.enes.common.data.dto.NetworkWrapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

inline fun <T> NetworkWrapper<T>.onSuccess(
    crossinline onSuccess: (networkWrapper: NetworkWrapper.Success<T>) -> Unit
): NetworkWrapper<T> {
    if (this is NetworkWrapper.Success<T>) {
        onSuccess(this)
    }
    return this
}

inline fun <T> NetworkWrapper<T>.onError(
    crossinline onError: (networkWrapper: NetworkWrapper.Error) -> Unit
): NetworkWrapper<T> {
    if (this is NetworkWrapper.Error) {
        onError(this)
    }
    return this
}

inline fun <T, Y> NetworkWrapper<T>.map(crossinline transform: (T) -> Y): NetworkWrapper<Y> {
    return when (this) {
        is NetworkWrapper.Success<T> -> NetworkWrapper.Success(transform(data))
        is NetworkWrapper.Error -> this
    }
}

inline fun <T, Y> Flow<NetworkWrapper<T>>.mapResponseToEntity(crossinline transform: (T) -> Y): Flow<NetworkWrapper<Y>> {
    return this.map { it.map(transform) }
}