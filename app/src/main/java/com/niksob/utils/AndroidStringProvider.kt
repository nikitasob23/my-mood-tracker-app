package com.niksob.utils

import android.content.Context
import com.niksob.data.StringProvider

class AndroidStringProvider(
    private val context: Context
) : StringProvider {
    override fun getString(name: String): String {
        val strId = context.resources.getIdentifier(name, "string", context.packageName)
        return context.getString(strId)
    }
}