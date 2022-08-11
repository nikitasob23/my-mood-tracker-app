package com.niksob.di.module.storage

import com.niksob.data.provider.DbProvider
import com.niksob.data.storage.db.MoodTagStorage
import com.niksob.data.storage.db.firebase.loader.FirebaseLoaderImpl
import com.niksob.data.storage.db.firebase.screen.mood.tag.DbMoodTagFirebase
import com.niksob.data.storage.db.firebase.screen.mood.tag.loading.MoodTagLoadResponseReasonProvider
import com.niksob.data.storage.db.firebase.screen.mood.tag.loading.MoodTagOnDataLoadedAction
import com.niksob.data.storage.db.firebase.saver.FirebaseSaverImpl
import com.niksob.data.storage.db.firebase.screen.mood.tag.saving.MoodTagOnDataSavedAction
import com.niksob.data.storage.db.firebase.screen.mood.tag.saving.MoodTagSaveResponseReasonProvider
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
class MoodTagStorageModule {

    @Provides
    fun provideStorage(
        dbProvider: DbProvider,
        @Named("mood_entry_on_data_loaded_action") loader: FirebaseLoaderImpl,
        @Named("mood_entry_on_data_saved_action") saver: FirebaseSaverImpl,
    ): MoodTagStorage =
        DbMoodTagFirebase(
            dbProvider = dbProvider,
            loader = loader,
            saver = saver,
        )

    @Named("mood_entry_on_data_loaded_action")
    @Provides
    fun provideFirebaseLoader(action: MoodTagOnDataLoadedAction) = FirebaseLoaderImpl(action)

    @Named("mood_entry_on_data_saved_action")
    @Provides
    fun provideFirebaseSaver(action: MoodTagOnDataSavedAction) = FirebaseSaverImpl(action)

    @Provides
    fun provideOnDataLoadedAction(loadReasonProvider: MoodTagLoadResponseReasonProvider) =
        MoodTagOnDataLoadedAction(loadReasonProvider)

    @Provides
    fun provideOnDataSavedAction(reasonProvider: MoodTagSaveResponseReasonProvider) =
        MoodTagOnDataSavedAction(reasonProvider)

    @Provides
    fun provideMoodTagLoadResponseReasonProvider(stringStorage: AppStringStorage) =
        MoodTagLoadResponseReasonProvider(stringStorage)

    @Provides
    fun provideMoodTagSaveResponseReasonProvider(stringStorage: AppStringStorage) =
        MoodTagSaveResponseReasonProvider(stringStorage)
}