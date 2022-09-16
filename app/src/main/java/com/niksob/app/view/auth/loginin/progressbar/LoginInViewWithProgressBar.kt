package com.niksob.app.view.auth.loginin.progressbar

import com.niksob.app.view.auth.loginin.base.LoginInViewWithLoginComponent
import com.niksob.domain.model.Query
import com.niksob.domain.navigation.appprogressbar.AppProgressBar
import javax.inject.Inject

open class LoginInViewWithProgressBar : LoginInViewWithLoginComponent() {

    @Inject
    lateinit var appProgressBar: AppProgressBar

    override fun onClickLoginInBtn() {
        appProgressBar.showProgress()
        super.onClickLoginInBtn()
    }

    override fun onLoginInCompleted(response: Query) {
        super.onLoginInCompleted(response)
        appProgressBar.hideProgress()
    }
}