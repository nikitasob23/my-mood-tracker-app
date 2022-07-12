package com.niksob.di.module.storage

import com.niksob.data.provider.DbProvider
import com.niksob.data.storage.db.MoodTagStorage
import com.niksob.data.storage.db.firebase.DbMoodTagFirebase
import com.niksob.data.storage.provider.AppStringStorage
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        DbProviderModule::class,
        StringStorageModule::class,
    ]
)
class MoodTagStorageModule {

    @Provides
    fun provideStorage(dbProvider: DbProvider, stringStorage: AppStringStorage): MoodTagStorage =
        DbMoodTagFirebase(
            dbProvider = dbProvider,
            stringStorage = stringStorage,
        )
}