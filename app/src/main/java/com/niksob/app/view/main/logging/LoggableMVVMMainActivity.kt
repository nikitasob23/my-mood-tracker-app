package com.niksob.app.view.main.logging

import com.niksob.app.view.main.mvvm.MainActivityWithStartDataLoader
import com.niksob.domain.model.Query
import com.niksob.domain.utils.logger.AppDebugLogger
import javax.inject.Inject

private const val LOAD_AUTH_USER_STARTED_MESSAGE = "Loading authorized user is started"
private const val SING_OUT_STARTED_MESSAGE = "Signing out is started"

open class LoggableMVVMMainActivity : MainActivityWithStartDataLoader() {
    @Inject
    lateinit var logger: AppDebugLogger

    private val tag get() = LoggableMVVMMainActivity::class.simpleName!!

    override fun loadAuthorizeUserId() {
        super.loadAuthorizeUserId()
        logger.log(tag, LOAD_AUTH_USER_STARTED_MESSAGE)
    }

    override fun signOut() {
        super.signOut()
        logger.log(tag, SING_OUT_STARTED_MESSAGE)
    }

    override fun onAuthUserResponseLoaded(response: Query) {
        super.onAuthUserResponseLoaded(response)
        logger.log(tag, response.reason)
    }

    override fun onSignOutResponseLoaded(response: Query) {
        super.onSignOutResponseLoaded(response)
        logger.log(tag, response.reason)
    }
}