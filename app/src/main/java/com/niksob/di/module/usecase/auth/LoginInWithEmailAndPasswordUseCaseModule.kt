package com.niksob.di.module.usecase.auth

import com.niksob.di.module.repository.AuthRepositoryModule
import com.niksob.domain.data.repository.AuthRepository
import com.niksob.domain.usecase.auth.LoginInWithEmailAndPasswordUseCase
import dagger.Module
import dagger.Provides

@Module(includes = [AuthRepositoryModule::class])
class LoginInWithEmailAndPasswordUseCaseModule {
    @Provides
    fun provideLoginInUseCase(repo: AuthRepository) = LoginInWithEmailAndPasswordUseCase(repo)
}