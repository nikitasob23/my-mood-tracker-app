package com.niksob.di.module.storage

import com.niksob.data.provider.DbProvider
import com.niksob.data.storage.db.MoodEntryStorage
import com.niksob.data.storage.db.firebase.moodentry.*
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
        saveReasonProvider: MoodEntrySaveResponseReasonProvider,
        moodEntriesValueEventProvider: MoodEntriesValueEventFirebaseProvider,
    ): MoodEntryStorage =
        DbMoodEntryFirebase(
            dbProvider = dbProvider,
            saveReasonProvider = saveReasonProvider,
            moodEntriesValueEventProvider = moodEntriesValueEventProvider,
        )

    @Provides
    fun provideValueEventFirebaseProvider(loadResponseProvider: MoodEntryLoadResponseReasonProvider) =
        MoodEntriesValueEventFirebaseProvider(loadResponseProvider)

    @Provides
    fun provideMoodEntryLoadResponseReasonProvider(stringStorage: AppStringStorage) =
        MoodEntryLoadResponseReasonProvider(stringStorage)

    @Provides
    fun provideMoodEntrySaveResponseReasonProvider(stringStorage: AppStringStorage) =
        MoodEntrySaveResponseReasonProvider(stringStorage)
}
