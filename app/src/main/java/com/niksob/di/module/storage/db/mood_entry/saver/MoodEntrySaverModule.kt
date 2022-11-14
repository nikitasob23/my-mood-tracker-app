package com.niksob.di.module.storage.db.mood_entry.saver

import com.niksob.data.storage.firebase.base.provider.MoodEntryFirebaseRefProvider
import com.niksob.data.storage.firebase.base.saver.FirebaseStorageSaver
import com.niksob.data.storage.firebase.base.saver.FirebaseStorageSaverImpl
import com.niksob.data.storage.firebase.mood_entry.loading.database_query.LoadMoodEntriesByDateIntervalQueryFactory
import com.niksob.di.module.storage.db.firebase_reference_provider.FirebaseRefProviderModule
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [FirebaseRefProviderModule::class])
class MoodEntrySaverModule {
    @Provides
    @Named("mood_entry_firebase_storage_saver")
    fun provideFirebaseStorageSaver(entryDbRefProvider: MoodEntryFirebaseRefProvider): FirebaseStorageSaver =
        FirebaseStorageSaverImpl(entryDbRefProvider)

    @Provides
    fun provideLoadByDateIntervalQueryFactory(entryDbRefProvider: MoodEntryFirebaseRefProvider) =
        LoadMoodEntriesByDateIntervalQueryFactory(entryDbRefProvider)
}