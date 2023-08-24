package com.example.accuweatherapp.common

sealed class Resources<T>(val data: T? = null, val msg: String? = null) {
    class Success<T>(data: T?) : Resources<T>(data)
    class Error<T>(data: T?, msg: String) : Resources<T>(data, msg)
    class Loading<T>(data: T? = null) : Resources<T>(data)
}

