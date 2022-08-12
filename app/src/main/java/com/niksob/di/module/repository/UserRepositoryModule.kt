package com.niksob.di.module.repository

import com.niksob.data.repository.UserRepositoryImpl
import com.niksob.data.storage.db.UserStorage
import com.niksob.di.module.storage.DbUserStorageModule
import com.niksob.domain.data.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module(includes = [DbUserStorageModule::class])
class UserRepositoryModule {
    @Provides
    fun provideUserRepository(storage: UserStorage): UserRepository = UserRepositoryImpl(storage)
}