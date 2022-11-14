package com.niksob.di.module.usecase.auth

import com.niksob.di.module.repository.auth.AuthRepositoryModule
import com.niksob.domain.data.repository.auth.AuthRepositoryWithRegistrar
import com.niksob.domain.usecase.auth.sign_up.SignUpWithEmailAndPasswordUseCase
import dagger.Module
import dagger.Provides

@Module(includes = [AuthRepositoryModule::class])
class SignUpWithEmailAndPasswordUseCaseModule {
    @Provides
    fun provideSignUpUseCase(repo: AuthRepositoryWithRegistrar) = SignUpWithEmailAndPasswordUseCase(repo)
}
