package com.niksob.utils

import android.content.Context
import com.niksob.domain.data.provider.AppDrawableIdProvider


private const val DRAWABLE_DEF_TYPE = "drawable"

class AndroidAppDrawableIdProvider(
    private val context: Context
): AppDrawableIdProvider {

    override fun getDrawableId(name: String) =
        context.resources.getIdentifier(name, DRAWABLE_DEF_TYPE, context.packageName)
}