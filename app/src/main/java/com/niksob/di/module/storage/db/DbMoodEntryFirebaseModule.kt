package com.niksob.di.module.storage.db

import com.niksob.data.storage.db.firebase.loader.FirebaseLoaderImpl
import com.niksob.data.storage.db.firebase.provider.MoodEntryFirebaseRefProvider
import com.niksob.data.storage.db.firebase.saver.FirebaseSaverImpl
import com.niksob.data.storage.db.firebase.screen.mood.entry.DbMoodEntryFirebase
import com.niksob.data.storage.db.firebase.screen.mood.entry.loading.MoodEntryLoadResponseReasonProvider
import com.niksob.data.storage.db.firebase.screen.mood.entry.loading.MoodEntryOnDataLoadedAction
import com.niksob.data.storage.db.firebase.screen.mood.entry.saving.MoodEntryOnDataSavedAction
import com.niksob.data.storage.db.firebase.screen.mood.entry.saving.MoodEntrySaveResponseReasonProvider
import com.niksob.data.storage.provider.AppStringStorage
import com.niksob.di.module.storage.string.StringStorageModule
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [StringStorageModule::class])
class DbMoodEntryFirebaseModule {
    @Provides
    fun provideMoodEntryStorage(
        dbProvider: MoodEntryFirebaseRefProvider,
        @Named("mood_tag_on_data_loaded_action") loader: FirebaseLoaderImpl,
        @Named("mood_tag_on_data_saved_action") saver: FirebaseSaverImpl,
    ): DbMoodEntryFirebase =
        DbMoodEntryFirebase(
            moodEntryDbProvider = dbProvider,
            loader = loader,
            saver = saver,
        )

    @Provides
    fun provideDbProvider() = MoodEntryFirebaseRefProvider()

    @Named("mood_tag_on_data_loaded_action")
    @Provides
    fun provideFirebaseLoader(action: MoodEntryOnDataLoadedAction) = FirebaseLoaderImpl(action)

    @Named("mood_tag_on_data_saved_action")
    @Provides
    fun provideFirebaseSaver(action: MoodEntryOnDataSavedAction) = FirebaseSaverImpl(action)

    @Provides
    fun provideOnDataLoadedAction(reasonProvider: MoodEntryLoadResponseReasonProvider) =
        MoodEntryOnDataLoadedAction(reasonProvider)

    @Provides
    fun provideOnDataSavedAction(reasonProvider: MoodEntrySaveResponseReasonProvider) =
        MoodEntryOnDataSavedAction(reasonProvider)

    @Provides
    fun provideMoodEntryLoadResponseReasonProvider(stringStorage: AppStringStorage) =
        MoodEntryLoadResponseReasonProvider(stringStorage)

    @Provides
    fun provideMoodEntrySaveResponseReasonProvider(stringStorage: AppStringStorage) =
        MoodEntrySaveResponseReasonProvider(stringStorage)
}
