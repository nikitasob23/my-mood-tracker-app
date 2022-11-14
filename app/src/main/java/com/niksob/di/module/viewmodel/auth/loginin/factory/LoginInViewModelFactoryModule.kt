package com.niksob.di.module.viewmodel.auth.loginin.factory

import androidx.lifecycle.ViewModelProvider
import com.niksob.app.viewmodel.auth.loginin.factory.LoginInViewModelFactory
import com.niksob.data.provider.AppStringProvider
import com.niksob.di.module.storage.string.StringStorageModule
import com.niksob.di.module.usecase.auth.LoginInWithEmailAndPasswordUseCaseModule
import com.niksob.di.module.usecase.auth.LoginValidationModule
import com.niksob.domain.usecase.auth.login_in.LoginInWithEmailAndPasswordUseCase
import com.niksob.domain.usecase.auth.validation.ValidateEmailUseCase
import com.niksob.domain.usecase.auth.validation.ValidatePasswordUseCase
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        LoginInWithEmailAndPasswordUseCaseModule::class,
        LoginValidationModule::class,
        StringStorageModule::class
    ]
)
class LoginInViewModelFactoryModule {
    @Provides
    fun provideLoginInViewModelFactory(
        loginInUseCase: LoginInWithEmailAndPasswordUseCase,
        validateEmailUseCase: ValidateEmailUseCase,
        validatePasswordUseCase: ValidatePasswordUseCase,
        stringProvider: AppStringProvider,
    ): ViewModelProvider.Factory =
        LoginInViewModelFactory(loginInUseCase, validateEmailUseCase, validatePasswordUseCase, stringProvider)
}