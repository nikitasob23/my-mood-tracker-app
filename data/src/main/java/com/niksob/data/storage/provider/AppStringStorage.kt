package com.niksob.data.storage.provider

import com.niksob.data.provider.AppStringProvider

class AppStringStorage(
    private val stringProvider: AppStringProvider
) {
    fun getString(name: String) = stringProvider.getString(name)
}
