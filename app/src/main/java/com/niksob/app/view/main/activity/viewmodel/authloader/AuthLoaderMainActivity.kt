package com.niksob.app.view.main.activity.viewmodel.authloader

import com.niksob.app.view.main.activity.navigation.app.injection.InjectableAppNavigationInitializer
import com.niksob.app.viewmodel.main.MainActivityViewModel
import com.niksob.domain.model.Query
import javax.inject.Inject

open class AuthLoaderMainActivity : InjectableAppNavigationInitializer() {

    @Inject
    lateinit var viewModel: MainActivityViewModel

    protected open fun loadAuthorizeUserId() = viewModel.loadAuthorizeUserId()

    protected open fun signOut() = viewModel.signOut()

    protected open fun onAuthUserResponseLoaded(response: Query) =
        if (response.completed) {
            navigation.moveToNextScreen(moodEntriesViewClass)
        } else {
            navigation.moveToNextScreen(loginViewClass)
        }

    protected open fun onSignOutResponseLoaded(response: Query) {
        if (response.completed) {
            navigation.moveToNextScreen(loginViewClass)
        }
    }
}