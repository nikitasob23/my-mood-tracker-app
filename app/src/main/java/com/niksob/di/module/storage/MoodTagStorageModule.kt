package com.niksob.di.module.storage

import com.niksob.data.provider.DbProvider
import com.niksob.data.storage.db.MoodTagStorage
import com.niksob.data.storage.db.firebase.moodentry.DbMoodTagFirebase
import com.niksob.data.storage.db.firebase.moodentry.MoodTagsValueEventFirebaseProvider
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
        stringStorage: AppStringStorage,
    ): MoodTagStorage =
        DbMoodTagFirebase(
            dbProvider = dbProvider,
            moodTagsEventProvider = moodTagsEventProvider,
            stringStorage = stringStorage,
        )

    @Provides
    fun provideMoodTagsValueEventFirebaseProvider(stringStorage: AppStringStorage) =
        MoodTagsValueEventFirebaseProvider(stringStorage)
}