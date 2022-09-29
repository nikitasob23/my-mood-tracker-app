package com.niksob.app.view.auth.loginin.logger

import com.niksob.app.R
import com.niksob.app.view.auth.loginin.progressbar.InjectableLoginInViewWithProgressBar
import com.niksob.domain.model.LoginData
import com.niksob.domain.model.Query
import com.niksob.domain.utils.logger.AppDebugLogger
import javax.inject.Inject

open class LoggableLoginInView : InjectableLoginInViewWithProgressBar() {

    @Inject
    lateinit var logger: AppDebugLogger

    private val logTag get() = LoggableLoginInView::class.simpleName!!

    private lateinit var startedMessage: String
    private lateinit var succeedMessage: String
    private lateinit var failureMessage: String

    override fun initComponents() {
        super.initComponents()

        startedMessage = getString(R.string.started_login_in)
        succeedMessage = getString(R.string.succeed_login_in)
        failureMessage = getString(R.string.failed_login_in)
    }

    override fun doLoginIn(loginData: LoginData) {
        logger.log(logTag, startedMessage)
        super.doLoginIn(loginData)
    }

    override fun onLoginInCompleted(response: Query) {
        super.onLoginInCompleted(response)

        if (!response.completed) {
            logger.log(logTag, failureMessage)
            return
        }
        logger.log(logTag, succeedMessage)
    }
}