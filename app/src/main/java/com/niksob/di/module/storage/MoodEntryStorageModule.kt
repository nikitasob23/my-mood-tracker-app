package com.niksob.di.module.storage

import com.niksob.data.provider.DbProvider
import com.niksob.data.storage.db.MoodEntryStorage
import com.niksob.data.storage.db.firebase.DbMoodEntryFirebase
import com.niksob.data.storage.provider.AppStringStorage
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        DbProviderModule::class,
        StringStorageModule::class,
    ]
)
class MoodEntryStorageModule {
    @Provides
    fun provideMoodEntryStorage(dbProvider: DbProvider, stringStorage: AppStringStorage): MoodEntryStorage =
        DbMoodEntryFirebase(
            dbProvider = dbProvider,
            stringStorage = stringStorage,
        )
}
