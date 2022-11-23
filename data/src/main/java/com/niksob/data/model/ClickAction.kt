package com.niksob.data.model

interface ClickAction<T> {
    fun onClick(data: T)
}