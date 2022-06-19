package com.niksob.utils

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.niksob.domain.data.provider.AppColorIdProvider


private const val COLOR_DEF_TYPE = "color"

class AndroidAppColorIdProvider(
    private val context: Context
) : AppColorIdProvider {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun getColorId(name: String): Int {

        val colorId = context.resources.getIdentifier(name, COLOR_DEF_TYPE, context.packageName)
        return context.getColor(colorId)
    }
}