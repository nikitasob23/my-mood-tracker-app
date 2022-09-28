package com.niksob.app.view.auth.loginin.logger.message

import android.content.Context
import com.niksob.app.R

class LoginInLoggerMessageImpl(context: Context) : LoginInLoggerMessage {

    private val startedMessageKeyword = context.getString(R.string.started_keyword)
    private val completedMessageKeyword = context.getString(R.string.completed_keyword)
    private val failedMessageKeyword = context.getString(R.string.failed_keyword)

    private val prefixMessage = context.getString(R.string.login_in_prefix_message)

    override val startedMessage = prefixMessage + startedMessageKeyword

    override val completedMessage = prefixMessage + completedMessageKeyword

    override val failureMessage = prefixMessage + failedMessageKeyword
}