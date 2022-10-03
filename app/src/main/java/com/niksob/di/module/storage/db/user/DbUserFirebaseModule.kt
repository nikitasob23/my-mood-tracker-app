package com.niksob.di.module.storage.db.user

import com.niksob.data.storage.firebase.base.provider.UserFirebaseRefProvider
import com.niksob.data.storage.firebase.user.DbUserFirebase
import com.niksob.data.storage.provider.AppStringStorage
import com.niksob.data.storage.user.UserStorage
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