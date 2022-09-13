package com.niksob.app.view.auth.loginin.mvvm

import com.niksob.app.view.auth.loginin.LoginInViewWithLoginComponent
import com.niksob.app.viewmodel.auth.loginin.LoginInViewModel
import com.niksob.domain.model.LoginData
import com.niksob.domain.model.Query
import javax.inject.Inject
import javax.inject.Named

open class MVVMLoginInView : LoginInViewWithLoginComponent() {

    @Inject
    @Named("login_in_view_model_with_observer")
    lateinit var loginInViewModel: LoginInViewModel

    override fun onClickLoginInBtn() {
        val loginData = LoginData(
            email = emailEditText.text.toString(),
            password = passwordEditText.text.toString()
        )
        loginInViewModel.doLoginIn(loginData)
    }

    protected fun onCompletedLoginIn(response: Query) {

        if (!response.completed) {
            throw IllegalStateException()
        }
        appNavigation.goToNextView(moodEntriesViewClass)
    }
}