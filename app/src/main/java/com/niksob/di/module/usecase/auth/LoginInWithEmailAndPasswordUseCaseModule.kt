package com.niksob.di.module.usecase.auth

import com.niksob.di.module.repository.auth.AuthRepositoryModule
import com.niksob.domain.data.repository.auth.AuthRepositoryWithAuthorizer
import com.niksob.domain.usecase.auth.login_in.LoginInWithEmailAndPasswordUseCase
import dagger.Module
import dagger.Provides

@Module(includes = [AuthRepositoryModule::class])
class LoginInWithEmailAndPasswordUseCaseModule {
    @Provides
    fun provideLoginInUseCase(repo: AuthRepositoryWithAuthorizer) =
        LoginInWithEmailAndPasswordUseCase(repo)
}