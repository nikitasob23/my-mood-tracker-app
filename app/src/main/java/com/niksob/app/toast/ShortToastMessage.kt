package com.niksob.app.toast

import android.content.Context
import android.widget.Toast

open class ShortToastMessage(
    private val context: Context,
) : ToastMessage {

    private val shortLength = Toast.LENGTH_SHORT

    override fun showShortToast(message: String) = makeToastText(message).show()

    protected open fun makeToastText(message: String): Toast =
        Toast.makeText(context, message, shortLength)
}