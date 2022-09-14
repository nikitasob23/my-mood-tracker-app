package com.niksob.app.view.auth.signup.mvvm.useraddition

import com.niksob.app.view.auth.signup.mvvm.signup.InjectableMVVMSignUpView
import com.niksob.domain.model.Query
import com.niksob.domain.model.User

open class MVVMSignUpWithUserAdderView : InjectableMVVMSignUpView() {

    protected open fun addUser(user: User) = signUpViewModel.addUser(user)

    protected open fun onAddUserCompleted(response: Query) {
        if (!response.completed) {
            throw IllegalStateException()
        }
        moveToMoodEntriesScreen()
    }
}