package com.niksob.utils

import android.content.Context
import com.niksob.data.provider.AppStringProvider


private const val STRING_DEF_TYPE = "string"

class AndroidStringProvider(
    private val context: Context
) : AppStringProvider {
    override fun getString(name: String): String {
        val strId = context.resources.getIdentifier(name, STRING_DEF_TYPE, context.packageName)
        return context.getString(strId)
    }
}