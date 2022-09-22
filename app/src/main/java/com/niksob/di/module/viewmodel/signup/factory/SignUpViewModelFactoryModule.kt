package com.niksob.di.module.viewmodel.signup.factory

import androidx.lifecycle.ViewModelProvider
import com.niksob.app.viewmodel.auth.signup.factory.SignUpViewModelWithNewUserAdditionFactory
import com.niksob.data.provider.AppStringProvider
import com.niksob.di.module.provider.AppStringProviderModule
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
    AddUserUseCaseModule::class,
    LoginValidationModule::class,
    AppStringProviderModule::class,
    SignUpWithEmailAndPasswordUseCaseModule::class,
])
class SignUpViewModelFactoryModule {
    @Provides
    fun provideViewModelFactory(
        addUserUseCase: AddUserUseCase,
        validateEmailUseCase: ValidateEmailUseCase,
        validatePasswordUseCase: ValidatePasswordUseCase,
        stringProvider: AppStringProvider,
        signUpWithEmailAndPasswordUseCase: SignUpWithEmailAndPasswordUseCase,
    ): ViewModelProvider.Factory =
        SignUpViewModelWithNewUserAdditionFactory(
            addUserUseCase,
            validateEmailUseCase,
            validatePasswordUseCase,
            stringProvider,
            signUpWithEmailAndPasswordUseCase,
        )
}