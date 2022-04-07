package com.niksob.di.module.view.login

import com.niksob.di.module.repository.AuthRepositoryModule
import com.niksob.domain.data.repository.AuthRepository
import com.niksob.domain.usecase.login.LoadAuthorizeUserIdUseCase
import dagger.Module
import dagger.Provides

@Module(includes = [AuthRepositoryModule::class])
class LoadAuthorizeUserIdUseCaseModule {
    @Provides
    fun provideLoadAuthorizeUserIdUseCase(repo: AuthRepository) = LoadAuthorizeUserIdUseCase(repo)
}