package com.niksob.di.module.storage.db.moodentry

import com.niksob.data.storage.firebase.base.loader.FirebaseLoaderImpl
import com.niksob.data.storage.firebase.base.provider.MoodEntryFirebaseRefProvider
import com.niksob.data.storage.firebase.base.saver.BaseFirebaseSaver
import com.niksob.data.storage.firebase.mood.entry.loading.data_loaded_action.MoodEntryOnDataLoadedAction
import com.niksob.data.storage.firebase.mood.entry.loading.reason.MoodEntryLoadResponseReasonProvider
import com.niksob.data.storage.firebase.mood.entry.saving.DbUpdatableMoodEntryFirebase
import com.niksob.data.storage.firebase.base.saver.BaseOnDataSavedAction
import com.niksob.data.storage.firebase.base.saver.FirebaseSaver
import com.niksob.data.storage.firebase.mood.entry.saving.reason.MoodEntrySaveResponseReasonProvider
import com.niksob.data.storage.mood.entry.saving.UpdatableMoodEntryStorage
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
        @Named("mood_tag_on_data_saved_action") saver: FirebaseSaver,
    ): UpdatableMoodEntryStorage =
        DbUpdatableMoodEntryFirebase(
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
    fun provideFirebaseSaver(@Named("mood_entry_on_data_saved_action") action: BaseOnDataSavedAction): FirebaseSaver =
        BaseFirebaseSaver(action)

    @Provides
    fun provideOnDataLoadedAction(reasonProvider: MoodEntryLoadResponseReasonProvider) =
        MoodEntryOnDataLoadedAction(reasonProvider)

    @Provides
    @Named("mood_entry_on_data_saved_action")
    fun provideOnDataSavedAction(reasonProvider: MoodEntrySaveResponseReasonProvider) =
        BaseOnDataSavedAction(reasonProvider)

    @Provides
    fun provideMoodEntryLoadResponseReasonProvider(stringStorage: AppStringStorage) =
        MoodEntryLoadResponseReasonProvider(stringStorage)

    @Provides
    fun provideMoodEntrySaveResponseReasonProvider(stringStorage: AppStringStorage) =
        MoodEntrySaveResponseReasonProvider(stringStorage)
}
