package com.niksob.di.module.storage

import com.niksob.data.storage.db.UserStorage
import com.niksob.data.storage.db.firebase.provider.UserFirebaseRefProvider
import com.niksob.data.storage.db.firebase.screen.auth.DbUserFirebase
import com.niksob.data.storage.provider.AppStringStorage
import dagger.Module
import dagger.Provides

@Module(includes = [StringStorageModule::class])
class DbUserStorageModule {
    @Provides
    fun provideDbUserStorage(
        dbProvider: UserFirebaseRefProvider,
        stringStorage: AppStringStorage,
    ): UserStorage =
        DbUserFirebase(dbProvider, stringStorage)

    @Provides
    fun provideDbProvider() = UserFirebaseRefProvider()
}