package com.niksob.domain.data.provider

interface AppColorIdProvider {
    fun getColorId(name: String): Int
}