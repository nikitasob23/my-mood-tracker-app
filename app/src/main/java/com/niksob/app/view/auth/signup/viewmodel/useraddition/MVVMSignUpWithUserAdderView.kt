package com.niksob.app.view.auth.signup.viewmodel.useraddition

import com.niksob.app.view.auth.signup.viewmodel.signup.InjectableMVVMSignUpView
import com.niksob.app.viewmodel.user.UserAdditionViewModel
import com.niksob.domain.model.Query
import com.niksob.domain.model.User
import javax.inject.Inject

open class MVVMSignUpWithUserAdderView : InjectableMVVMSignUpView() {

    @Inject
    lateinit var userAdditionViewModel: UserAdditionViewModel

    protected open fun addUser(user: User) = userAdditionViewModel.addUser(user)

    protected open fun onAddUserCompleted(response: Query) {
        if (!response.completed) {
            throw IllegalStateException()
        }
        super.onSignUpCompleted(response)
    }
}