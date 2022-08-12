package com.niksob.di.module.repository

import com.niksob.data.provider.AuthProvider
import com.niksob.data.repository.AuthRepositoryImpl
import com.niksob.data.storage.db.AuthStorage
import com.niksob.data.storage.db.firebase.screen.auth.AuthFirebase
import com.niksob.data.storage.provider.AppStringStorage
import com.niksob.di.module.storage.auth.AuthProviderModule
import com.niksob.di.module.storage.string.StringStorageModule
import com.niksob.domain.data.repository.AuthRepository
import dagger.Module
import dagger.Provides

@Module(includes = [AuthProviderModule::class, StringStorageModule::class])
class AuthRepositoryModule {
    @Provides
    fun provideAuthRepository(storage: AuthStorage): AuthRepository = AuthRepositoryImpl(storage)

    @Provides
    fun provideDbAuthStorage(
        authProvider: AuthProvider,
        stringStorage: AppStringStorage
    ): AuthStorage = AuthFirebase(authProvider, stringStorage)
}