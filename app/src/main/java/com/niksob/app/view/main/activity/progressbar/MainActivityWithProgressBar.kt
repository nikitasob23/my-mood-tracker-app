package com.niksob.app.view.main.activity.progressbar

import com.niksob.app.view.main.activity.viewmodel.authloader.app.injection.InjectableAppAuthLoaderMainActivity
import com.niksob.domain.model.Query
import com.niksob.domain.navigation.appprogressbar.AppProgressBar
import javax.inject.Inject

open class MainActivityWithProgressBar : InjectableAppAuthLoaderMainActivity() {
    @Inject
    lateinit var mainProgressBar: AppProgressBar

    private fun actionBeforeDataLoading() = mainProgressBar.showProgress()

    private fun actionAfterDataLoading() = mainProgressBar.hideProgress()

    override fun loadAuthorizeUserId() {
        actionBeforeDataLoading()
        super.loadAuthorizeUserId()
    }

    override fun signOut() {
        actionBeforeDataLoading()
        super.signOut()
    }

    override fun onAuthUserResponseLoaded(response: Query) {
        super.onAuthUserResponseLoaded(response)
        actionAfterDataLoading()
    }

    override fun onSignOutResponseLoaded(response: Query) {
        super.onSignOutResponseLoaded(response)
        actionAfterDataLoading()
    }
}