package com.enes.common.data.dto

class NetworkError(exception: Throwable? = null) : Throwable(exception) {
    var apiMessage: String? = null
    var errorcode: Int? = null
}