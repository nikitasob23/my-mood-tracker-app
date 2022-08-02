package com.niksob.di.module.storage

import com.niksob.data.provider.DbProvider
import com.niksob.data.storage.db.MoodTagStorage
import com.niksob.data.storage.db.firebase.moodtag.DbMoodTagFirebase
import com.niksob.data.storage.db.firebase.moodtag.MoodTagsValueEventFirebaseProvider
import com.niksob.data.storage.db.firebase.provider.reason.moodentry.MoodTagLoadResponseReasonProvider
import com.niksob.data.storage.db.firebase.provider.reason.moodentry.MoodTagSaveResponseReasonProvider
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
            moodTagsEventProvider = moodTagsEventProvider,
            saveReasonProvider = saveReasonProvider,
        )

    @Provides
    fun provideMoodTagsValueEventFirebaseProvider(loadReasonProvider: MoodTagLoadResponseReasonProvider) =
        MoodTagsValueEventFirebaseProvider(loadReasonProvider)

    @Provides
    fun provideLoadReasonProvider(stringStorage: AppStringStorage) = MoodTagLoadResponseReasonProvider(stringStorage)

    @Provides
    fun provideSaveReasonProvider(stringStorage: AppStringStorage) = MoodTagSaveResponseReasonProvider(stringStorage)
}