package com.niksob.di.module.viewmodel.auth.signup.factory

import androidx.lifecycle.ViewModelProvider
import com.niksob.app.viewmodel.auth.signup.factory.SignUpViewModelFactory
import com.niksob.data.provider.AppStringProvider
import com.niksob.di.module.provider.AppStringProviderModule
import com.niksob.di.module.usecase.AddUserUseCaseModule
import com.niksob.di.module.usecase.auth.LoginValidationModule
import com.niksob.di.module.usecase.auth.SignUpWithEmailAndPasswordUseCaseModule
import com.niksob.domain.usecase.auth.sign_up.SignUpWithEmailAndPasswordUseCase
import com.niksob.domain.usecase.auth.validation.ValidateEmailUseCase
import com.niksob.domain.usecase.auth.validation.ValidatePasswordUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [
    AddUserUseCaseModule::class,
    LoginValidationModule::class,
    AppStringProviderModule::class,
    SignUpWithEmailAndPasswordUseCaseModule::class,
])
class SignUpViewModelFactoryModule {
    @Provides
    @Named("sign_up_view_model_factory")
    fun provideViewModelFactory(
        validateEmailUseCase: ValidateEmailUseCase,
        validatePasswordUseCase: ValidatePasswordUseCase,
        stringProvider: AppStringProvider,
        signUpWithEmailAndPasswordUseCase: SignUpWithEmailAndPasswordUseCase,
    ): ViewModelProvider.Factory =
        SignUpViewModelFactory(
            validateEmailUseCase = validateEmailUseCase,
            validatePasswordUseCase = validatePasswordUseCase,
            stringProvider = stringProvider,
            signUpWithEmailAndPasswordUseCase = signUpWithEmailAndPasswordUseCase,
        )
}