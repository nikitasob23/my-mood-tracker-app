package com.niksob.app.view.auth.loginin.mvvm

import com.niksob.app.view.auth.loginin.navigation.InjectableNavigatableLoginInView
import com.niksob.app.viewmodel.auth.loginin.LoginInViewModel
import com.niksob.domain.model.LoginData
import com.niksob.domain.model.Query
import javax.inject.Inject

open class MVVMLoginInView : InjectableNavigatableLoginInView() {

    @Inject
    lateinit var loginInViewModel: LoginInViewModel

    protected open fun doLoginIn(loginData: LoginData) =
        loginInViewModel.doLoginIn(loginData)

    protected open fun onLoginInCompleted(response: Query) {

        if (!response.completed) {
            throw IllegalStateException()
        }
        appNavigation.goToNextView(moodEntriesViewClass)
    }
}