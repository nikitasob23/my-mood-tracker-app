package com.niksob.app.view.auth.signup

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