package com.niksob.app.view.auth.signup.viewmodel.signup

import com.niksob.app.view.auth.signup.navigation.InjectableNavigatableSignUpView
import com.niksob.app.viewmodel.auth.signup.base.SignUpViewModel
import com.niksob.domain.model.LoginData
import com.niksob.domain.model.Query
import javax.inject.Inject

open class MVVMSignUpView : InjectableNavigatableSignUpView() {

    @Inject
    lateinit var signUpViewModel: SignUpViewModel

    protected open fun doSignUp(loginData: LoginData) = signUpViewModel.doSignUp(loginData)

    protected open fun onSignUpCompleted(response: Query) {

        if (!response.completed) {
            throw IllegalStateException()
        }
        moveToMoodEntriesScreen()
    }
}