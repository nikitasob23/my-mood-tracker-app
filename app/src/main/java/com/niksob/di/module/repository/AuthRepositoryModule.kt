package com.niksob.di.module.repository

import com.niksob.data.repository.AuthRepositoryImpl
import com.niksob.data.storage.auth.auth_user_id_loader.AuthUserIdLoader
import com.niksob.di.module.storage.db.auth.AuthStorageModule
import com.niksob.domain.data.repository.AuthRepository
import dagger.Module
import dagger.Provides

@Module(includes = [AuthStorageModule::class])
class AuthRepositoryModule {
    @Provides
    fun provideAuthRepository(storage: AuthUserIdLoader): AuthRepository = AuthRepositoryImpl(storage)
}