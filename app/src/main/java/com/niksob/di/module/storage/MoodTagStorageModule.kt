package com.niksob.di.module.storage

import com.niksob.data.provider.DbProvider
import com.niksob.data.storage.db.MoodTagStorage
import com.niksob.data.storage.db.firebase.moodtag.DbMoodTagFirebase
import com.niksob.data.storage.db.firebase.moodtag.MoodTagLoadResponseReasonProvider
import com.niksob.data.storage.db.firebase.moodtag.MoodTagSaveResponseReasonProvider
import com.niksob.data.storage.db.firebase.moodtag.MoodTagsValueEventFirebaseProvider
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
    fun provideStorage(
        dbProvider: DbProvider,
        moodTagsEventProvider: MoodTagsValueEventFirebaseProvider,
        saveReasonProvider: MoodTagSaveResponseReasonProvider,
    ): MoodTagStorage =
        DbMoodTagFirebase(
            dbProvider = dbProvider,
            saveReasonProvider = saveReasonProvider,
            moodTagsEventProvider = moodTagsEventProvider,
        )

    @Provides
    fun provideMoodTagsValueEventFirebaseProvider(loadReasonProvider: MoodTagLoadResponseReasonProvider) =
        MoodTagsValueEventFirebaseProvider(loadReasonProvider)

    @Provides
    fun provideLoadResponseReasonProvider(stringStorage: AppStringStorage) =
        MoodTagLoadResponseReasonProvider(stringStorage)

    @Provides
    fun provideSaveResponseReasonProvider(stringStorage: AppStringStorage) =
        MoodTagSaveResponseReasonProvider(stringStorage)
}