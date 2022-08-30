package com.niksob.app.view.main.activity.mvvm

import com.niksob.app.view.main.activity.navigation.InjectableAppNavigationInitializer
import com.niksob.app.viewmodel.main.MainActivityViewModel
import com.niksob.domain.model.Query
import javax.inject.Inject
import javax.inject.Named

open class MVVMMainActivity : InjectableAppNavigationInitializer() {
    @Named("main_activity_observable_view_model")
    @Inject
    lateinit var viewModel: MainActivityViewModel

    protected open fun loadAuthorizeUserId() = viewModel.loadAuthorizeUserId()

    protected open fun signOut() = viewModel.signOut()

    protected open fun onAuthUserResponseLoaded(response: Query) =
        if (response.completed) {
            navigation.goToNextView(moodEntriesViewClass)
        } else {
            navigation.goToNextView(loginViewClass)
        }

    protected open fun onSignOutResponseLoaded(response: Query) {
        if (response.completed) {
            navigation.goToNextView(loginViewClass)
        }
    }
}