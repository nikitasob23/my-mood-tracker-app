package com.niksob.di.module.storage

import com.niksob.data.provider.DbProvider
import com.niksob.data.storage.db.MoodEntryStorage
import com.niksob.data.storage.db.firebase.moodentry.*
import com.niksob.data.storage.db.firebase.provider.reason.moodentry.MoodEntryLoadResponseReasonProvider
import com.niksob.data.storage.db.firebase.provider.reason.moodentry.MoodEntrySaveResponseReasonProvider
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
    fun provideMoodEntryStorage(
        dbProvider: DbProvider,
        loadReasonProvider: MoodEntryLoadResponseReasonProvider,
        saveReasonProvider: MoodEntrySaveResponseReasonProvider,
    ): MoodEntryStorage =
        DbMoodEntryFirebase(
            dbProvider = dbProvider,
            loadReasonProvider = loadReasonProvider,
            saveReasonProvider = saveReasonProvider,
        )

    @Provides
    fun provideLoadReasonProvider(stringStorage: AppStringStorage) = MoodEntryLoadResponseReasonProvider(stringStorage)

    @Provides
    fun provideSaveReasonProvider(stringStorage: AppStringStorage) = MoodEntrySaveResponseReasonProvider(stringStorage)
}
