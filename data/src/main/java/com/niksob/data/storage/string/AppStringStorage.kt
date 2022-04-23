package com.niksob.data.storage.string

class AppStringStorage(
    private val stringProvider: AppStringProvider
) {
    fun getString(name: String) = stringProvider.getString(name)
}
