package com.niksob.data.model

data class Request<T : Any, R : Any>(
    val data: T,
    val isSuccess: Boolean = true,
    val callback: R
)
