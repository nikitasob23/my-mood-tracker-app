package com.niksob.di.module.storage.db

import com.niksob.data.storage.db.UserStorage
import com.niksob.data.storage.db.firebase.provider.UserFirebaseRefProvider
import com.niksob.data.storage.db.firebase.screen.auth.DbUserFirebase
import com.niksob.data.storage.provider.AppStringStorage
import com.niksob.di.module.storage.string.StringStorageModule
import dagger.Module
import dagger.Provides

@Module(includes = [StringStorageModule::class])
class DbUserFirebaseModule {
    @Provides
    fun provideDbUserStorage(
        dbProvider: UserFirebaseRefProvider,
        stringStorage: AppStringStorage,
    ): UserStorage =
        DbUserFirebase(dbProvider, stringStorage)

    @Provides
    fun provideDbProvider() = UserFirebaseRefProvider()
}