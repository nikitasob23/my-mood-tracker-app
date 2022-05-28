package com.niksob.utils.appstring

import android.content.Context
import com.niksob.data.storage.string.AppStringProvider

class AndroidStringProvider(
    private val context: Context
) : AppStringProvider {
    override fun getString(name: String): String {
        val strId = context.resources.getIdentifier(name, "string", context.packageName)
        return context.getString(strId)
    }
}