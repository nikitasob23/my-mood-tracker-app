package com.niksob.di.module.viewmodel.factory

import androidx.lifecycle.ViewModelProvider
import com.niksob.app.viewmodel.auth.factory.SignUpViewModelFactory
import com.niksob.data.provider.AppStringProvider
import com.niksob.di.module.storage.string.StringStorageModule
import com.niksob.di.module.usecase.AddUserUseCaseModule
import com.niksob.di.module.usecase.auth.LoginValidationModule
import com.niksob.di.module.usecase.auth.SignUpWithEmailAndPasswordUseCaseModule
import com.niksob.domain.usecase.auth.SignUpWithEmailAndPasswordUseCase
import com.niksob.domain.usecase.auth.ValidateEmailUseCase
import com.niksob.domain.usecase.auth.ValidatePasswordUseCase
import com.niksob.domain.usecase.db.AddUserUseCase
import dagger.Module
import dagger.Provides

@Module(includes = [
    SignUpWithEmailAndPasswordUseCaseModule::class,
    AddUserUseCaseModule::class,
    LoginValidationModule::class,
    StringStorageModule::class,
])
class SignUpViewModelFactoryModule {
    @Provides
    fun provideViewModelFactory(
        signUpUseCase: SignUpWithEmailAndPasswordUseCase,
        addUserUseCase: AddUserUseCase,
        validateEmailUseCase: ValidateEmailUseCase,
        validatePasswordUseCase: ValidatePasswordUseCase,
        stringProvider: AppStringProvider,
    ): ViewModelProvider.Factory =
        SignUpViewModelFactory(
            signUpUseCase,
            addUserUseCase,
            validateEmailUseCase,
            validatePasswordUseCase,
            stringProvider
        )
}