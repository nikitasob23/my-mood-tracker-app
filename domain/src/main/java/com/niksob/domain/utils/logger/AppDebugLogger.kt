package com.niksob.domain.utils.logger

interface AppDebugLogger {
    fun log(tag: String, message: String): Int
}