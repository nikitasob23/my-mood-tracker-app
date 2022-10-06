package com.niksob.di.module.usecase.auth

import com.niksob.di.module.repository.auth.AuthRepositoryModule
import com.niksob.domain.data.repository.auth.AuthRepositoryWithAuthorizedUserIdLoader
import com.niksob.domain.usecase.auth.LoadAuthorizeUserIdUseCase
import dagger.Module
import dagger.Provides

@Module(includes = [AuthRepositoryModule::class])
class LoadAuthorizeUserIdUseCaseModule {

    @Provides
    fun provideUseCase(repo: AuthRepositoryWithAuthorizedUserIdLoader) =
        LoadAuthorizeUserIdUseCase(repo)
}