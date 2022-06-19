package com.niksob.di.module.storage

import com.niksob.data.provider.DbProvider
import com.niksob.data.storage.db.UserStorage
import com.niksob.data.storage.db.firebase.DbUserFirebase
import com.niksob.data.storage.provider.AppStringStorage
import dagger.Module
import dagger.Provides

@Module(includes = [DbProviderModule::class, StringStorageModule::class])
class DbStoragesModule {
    @Provides
    fun provideDbUserStorage(
        dbProvider: DbProvider,
        stringStorage: AppStringStorage,
    ): UserStorage =
        DbUserFirebase(dbProvider, stringStorage)
}