package com.niksob.app.view.auth.signup.progressbar

import com.niksob.app.view.auth.signup.uicomponent.InjectedSignUpViewWithSignUpComponent
import com.niksob.domain.model.LoginData
import com.niksob.domain.model.Query
import com.niksob.domain.navigation.appprogressbar.AppProgressBar
import javax.inject.Inject

open class SignUpViewWithProgressbar : InjectedSignUpViewWithSignUpComponent() {
    @Inject
    lateinit var progressbar: AppProgressBar

    override fun doSignUp(loginData: LoginData) {
        progressbar.showProgress()
        super.doSignUp(loginData)
    }

    override fun onSignUpCompleted(response: Query) {
        super.onSignUpCompleted(response)
        progressbar.hideProgress()
    }
}