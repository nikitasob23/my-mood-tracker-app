package com.niksob.di.module.view.login

import com.niksob.domain.usecase.login.ValidateEmailUseCase
import com.niksob.domain.usecase.login.ValidatePasswordUseCase
import dagger.Module
import dagger.Provides

@Module
class LoginValidationModule {
    @Provides
    fun provideValidateEmailUseCase() = ValidateEmailUseCase()

    @Provides
    fun provideValidatePasswordUseCase() = ValidatePasswordUseCase()
}