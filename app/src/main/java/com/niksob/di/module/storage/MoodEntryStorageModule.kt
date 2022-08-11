package com.niksob.di.module.storage

import com.niksob.data.provider.DbProvider
import com.niksob.data.storage.db.MoodEntryStorage
import com.niksob.data.storage.db.firebase.loader.FirebaseLoaderImpl
import com.niksob.data.storage.db.firebase.saver.FirebaseSaverImpl
import com.niksob.data.storage.db.firebase.screen.mood.entry.DbMoodEntryFirebase
import com.niksob.data.storage.db.firebase.screen.mood.entry.loading.MoodEntryLoadResponseReasonProvider
import com.niksob.data.storage.db.firebase.screen.mood.entry.loading.MoodEntryOnDataLoadedAction
import com.niksob.data.storage.db.firebase.screen.mood.entry.saving.MoodEntryOnDataSavedAction
import com.niksob.data.storage.db.firebase.screen.mood.entry.saving.MoodEntrySaveResponseReasonProvider
import com.niksob.data.storage.provider.AppStringStorage
import dagger.Module
import dagger.Provides
import javax.inject.Named

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
        @Named("mood_tag_on_data_loaded_action") loader: FirebaseLoaderImpl,
        @Named("mood_tag_on_data_saved_action") saver: FirebaseSaverImpl,
    ): MoodEntryStorage =
        DbMoodEntryFirebase(
            dbProvider = dbProvider,
            loader = loader,
            saver = saver,
        )

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
