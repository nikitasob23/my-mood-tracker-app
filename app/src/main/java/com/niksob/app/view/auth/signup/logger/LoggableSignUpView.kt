package com.niksob.app.view.auth.signup.logger

import com.niksob.app.R
import com.niksob.app.view.auth.signup.toast.InjectedSignUpViewWithToastMessages
import com.niksob.domain.model.LoginData
import com.niksob.domain.model.Query
import com.niksob.domain.utils.logger.AppDebugLogger
import javax.inject.Inject

open class LoggableSignUpView : InjectedSignUpViewWithToastMessages() {

    @Inject
    lateinit var logger: AppDebugLogger

    private val logTag = LoggableSignUpView::class.simpleName!!

    private lateinit var startedMessage: String
    private lateinit var succeedMessage: String
    private lateinit var failureMessage: String

    override fun initComponents() {
        super.initComponents()

        startedMessage = requireContext().getString(R.string.started_sign_up)
        succeedMessage = requireContext().getString(R.string.succeed_sign_up)
        failureMessage = requireContext().getString(R.string.failed_sign_up)
    }

    override fun doSignUp(loginData: LoginData) {
        logger.log(logTag, startedMessage)
        super.doSignUp(loginData)
    }

    override fun onSignUpCompleted(response: Query) {
        super.onSignUpCompleted(response)

        if (!response.completed) {
            logger.log(logTag, failureMessage)
            return
        }
        logger.log(logTag, succeedMessage)
    }
}