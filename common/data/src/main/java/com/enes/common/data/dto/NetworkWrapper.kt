package com.enes.common.data.dto

sealed class NetworkWrapper<out T> {

    data class Success<out T>(val data: T) : NetworkWrapper<T>()
    data class Error(val networkError: NetworkError) : NetworkWrapper<Nothing>()
}