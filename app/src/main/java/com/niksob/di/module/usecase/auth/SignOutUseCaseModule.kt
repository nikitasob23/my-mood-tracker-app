package com.niksob.di.module.usecase.auth

import com.niksob.di.module.repository.auth.AuthRepositoryModule
import com.niksob.domain.data.repository.auth.AuthRepositoryWithSignOutMaker
import com.niksob.domain.usecase.auth.sign_out.SignOutUseCase
import dagger.Module
import dagger.Provides

@Module(includes = [AuthRepositoryModule::class])
class SignOutUseCaseModule {
    @Provides
    fun provideSignOutUseCase(repo: AuthRepositoryWithSignOutMaker) = SignOutUseCase(repo)
}
