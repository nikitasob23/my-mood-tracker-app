package com.niksob.app.view.auth.loginin.logger

import com.niksob.app.view.auth.loginin.logger.message.LoginInLoggerMessage
import com.niksob.app.view.auth.loginin.progressbar.InjectableLoginInViewWithProgressBar
import com.niksob.domain.model.LoginData
import com.niksob.domain.model.Query
import com.niksob.domain.utils.logger.AppDebugLogger
import javax.inject.Inject

open class LoggableLoginInView : InjectableLoginInViewWithProgressBar() {

    @Inject
    lateinit var logger: AppDebugLogger

    @Inject
    lateinit var loginInLoggerMessage: LoginInLoggerMessage

    private val logTag get() = LoggableLoginInView::class.simpleName!!

    override fun doLoginIn(loginData: LoginData) {
        logger.log(logTag, loginInLoggerMessage.startedMessage)
        super.doLoginIn(loginData)
    }

    override fun onLoginInCompleted(response: Query) {
        super.onLoginInCompleted(response)

        if (!response.completed) {
            logger.log(logTag, loginInLoggerMessage.failureMessage)
            return
        }
        logger.log(logTag, loginInLoggerMessage.completedMessage)
    }
}