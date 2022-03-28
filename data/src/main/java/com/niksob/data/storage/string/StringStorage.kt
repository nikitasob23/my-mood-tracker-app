package com.niksob.data.storage.string

import com.niksob.data.StringProvider

class StringStorage(
    private val stringProvider: StringProvider
) {
    fun getString(name: String) = stringProvider.getString(name)
}
