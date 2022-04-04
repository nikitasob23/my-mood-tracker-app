package com.niksob.di.module.repository

import com.niksob.data.repository.UserRepositoryImpl
import com.niksob.data.storage.db.DbUserStorage
import com.niksob.di.module.storage.DbStoragesModule
import com.niksob.domain.data.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module(includes = [DbStoragesModule::class])
class UserRepositoryModule {
    @Provides
    fun provideUserRepository(storage: DbUserStorage): UserRepository = UserRepositoryImpl(storage)
}