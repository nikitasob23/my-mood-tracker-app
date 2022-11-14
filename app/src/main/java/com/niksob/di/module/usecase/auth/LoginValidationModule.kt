package com.niksob.di.module.usecase.auth

import com.niksob.domain.usecase.auth.validation.ValidateEmailUseCase
import com.niksob.domain.usecase.auth.validation.ValidatePasswordUseCase
import dagger.Module
import dagger.Provides

@Module
class LoginValidationModule {
    @Provides
    fun provideValidateEmailUseCase() = ValidateEmailUseCase()

    @Provides
    fun provideValidatePasswordUseCase() = ValidatePasswordUseCase()
}