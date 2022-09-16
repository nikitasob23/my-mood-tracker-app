package com.niksob.app.view.auth.loginin.progressbar

import com.niksob.domain.model.LoginData
import com.niksob.domain.model.Query
import com.niksob.domain.utils.logger.AppDebugLogger
import javax.inject.Inject

private const val LOGIN_IN_PREFIX_MESSAGE = "The authorization process has "
private const val DO_LOGIN_IN_MESSAGE = LOGIN_IN_PREFIX_MESSAGE + "started"
private const val ON_LOGIN_IN_COMPLETED_MESSAGE = LOGIN_IN_PREFIX_MESSAGE + "completed"

open class LoggableLoginInView : InjectableLoginInViewWithProgressBar() {

    @Inject
    lateinit var logger: AppDebugLogger

    private val logTag get() = LoggableLoginInView::class.simpleName!!

    override fun doLoginIn(loginData: LoginData) {
        logger.log(logTag, DO_LOGIN_IN_MESSAGE)
        super.doLoginIn(loginData)
    }

    override fun onLoginInCompleted(response: Query) {
        super.onLoginInCompleted(response)
        logger.log(logTag, ON_LOGIN_IN_COMPLETED_MESSAGE)
    }
}