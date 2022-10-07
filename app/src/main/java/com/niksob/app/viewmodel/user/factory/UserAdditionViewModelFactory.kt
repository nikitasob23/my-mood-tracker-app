package com.niksob.app.viewmodel.user.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.niksob.app.viewmodel.user.BaseUserAdditionViewModel
import com.niksob.domain.usecase.db.AddUserUseCase

class UserAdditionViewModelFactory(
    private val addUserUseCase: AddUserUseCase,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        BaseUserAdditionViewModel(addUserUseCase) as T
}