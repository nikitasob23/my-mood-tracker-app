package com.niksob.di.module.view.login

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.data.storage.string.AppStringProvider
import com.niksob.di.module.storage.StringStorageModule
import com.niksob.di.module.usecase.login.LoginInWithEmailAndPasswordUseCaseModule
import com.niksob.di.module.usecase.login.LoginValidationModule
import com.niksob.domain.usecase.login.LoginInWithEmailAndPasswordUseCase
import com.niksob.domain.usecase.login.ValidateEmailUseCase
import com.niksob.domain.usecase.login.ValidatePasswordUseCase
import com.niksob.presentation.viewmodel.LoginInViewModel
import com.niksob.presentation.viewmodel.factory.LoginInViewModelFactory
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        LoginInWithEmailAndPasswordUseCaseModule::class,
        LoginValidationModule::class,
        StringStorageModule::class]
)
class LoginInViewModule(
    private val viewModelStoreOwner: ViewModelStoreOwner,
) {
    @Provides
    fun provideLoginInViewModel(
        viewModelFactory: ViewModelProvider.Factory,
        viewModelClass: Class<LoginInViewModel>
    ) =
        ViewModelProvider(viewModelStoreOwner, viewModelFactory)[viewModelClass]

    @Provides
    fun provideViewModelClass() = LoginInViewModel::class.java

    @Provides
    fun provideLoginInViewModelFactory(
        loginInUseCase: LoginInWithEmailAndPasswordUseCase,
        validateEmailUseCase: ValidateEmailUseCase,
        validatePasswordUseCase: ValidatePasswordUseCase,
        stringProvider: AppStringProvider,
    ): ViewModelProvider.Factory =
        LoginInViewModelFactory(loginInUseCase, validateEmailUseCase, validatePasswordUseCase, stringProvider)
}