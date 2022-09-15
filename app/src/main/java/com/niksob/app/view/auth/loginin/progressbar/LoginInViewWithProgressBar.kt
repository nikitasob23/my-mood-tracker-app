package com.niksob.app.view.auth.loginin.progressbar

import com.niksob.app.view.auth.loginin.mvvm.InjectableMVVMLoginInView
import com.niksob.domain.model.Query
import com.niksob.domain.navigation.appprogressbar.AppProgressBar
import javax.inject.Inject

open class LoginInViewWithProgressBar : InjectableMVVMLoginInView() {

    @Inject
    lateinit var appProgressBar: AppProgressBar

    override fun onClickLoginInBtn() {
        appProgressBar.showProgress()
        super.onClickLoginInBtn()
    }

    override fun onCompletedLoginIn(response: Query) {
        super.onCompletedLoginIn(response)
        appProgressBar.hideProgress()
    }
}