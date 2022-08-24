package com.niksob.utils.logger

import android.util.Log
import com.niksob.domain.utils.logger.AppDebugLogger

class AndroidDebugLogger : AppDebugLogger {

    override fun log(tag: String, message: String) = Log.d(tag, message)
}