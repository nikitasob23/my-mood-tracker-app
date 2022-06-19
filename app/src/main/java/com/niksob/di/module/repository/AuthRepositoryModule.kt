package com.niksob.di.module.repository

import com.niksob.data.provider.DbProvider
import com.niksob.data.repository.AuthRepositoryImpl
import com.niksob.data.storage.db.AuthStorage
import com.niksob.data.storage.db.firebase.AuthFirebase
import com.niksob.data.storage.provider.AppStringStorage
import com.niksob.di.module.storage.DbProviderModule
import com.niksob.di.module.storage.StringStorageModule
import com.niksob.domain.data.repository.AuthRepository
import dagger.Module
import dagger.Provides

@Module(includes = [DbProviderModule::class, StringStorageModule::class])
class AuthRepositoryModule {
    @Provides
    fun provideAuthRepository(storage: AuthStorage): AuthRepository = AuthRepositoryImpl(storage)

    @Provides
    fun provideDbAuthStorage(
        dbProvider: DbProvider,
        stringStorage: AppStringStorage
    ): AuthStorage = AuthFirebase(dbProvider, stringStorage)
}