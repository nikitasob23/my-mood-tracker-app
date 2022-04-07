package com.niksob.di.module.usecase

import com.niksob.di.module.repository.UserRepositoryModule
import com.niksob.domain.data.repository.UserRepository
import com.niksob.domain.usecase.db.AddUserUseCase
import dagger.Module
import dagger.Provides

@Module(includes = [UserRepositoryModule::class])
class AddUserUseCaseModule {
    @Provides
    fun provideAddUserUseCase(repo: UserRepository) = AddUserUseCase(repo)
}