package com.niksob.data.converter

interface DataConverter<T : Any, U : Any> {
    fun convert(t: T): U
}