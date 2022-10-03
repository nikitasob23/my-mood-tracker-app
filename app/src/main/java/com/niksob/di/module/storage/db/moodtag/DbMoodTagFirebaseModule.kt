package com.niksob.di.module.storage.db.moodtag

import com.niksob.data.storage.firebase.base.loader.FirebaseLoaderImpl
import com.niksob.data.storage.firebase.base.provider.MoodTagFirebaseRefProvider
import com.niksob.data.storage.firebase.base.saver.FirebaseSaverImpl
import com.niksob.data.storage.firebase.mood.tag.loading.data_loaded_action.MoodTagOnDataLoadedAction
import com.niksob.data.storage.firebase.mood.tag.loading.reason.MoodTagLoadResponseReasonProvider
import com.niksob.data.storage.firebase.mood.tag.saving.DbUpdatableMoodTagFirebase
import com.niksob.data.storage.firebase.mood.tag.saving.data_loaded_action.MoodTagOnDataSavedAction
import com.niksob.data.storage.firebase.mood.tag.saving.reason.MoodTagSaveResponseReasonProvider
import com.niksob.data.storage.mood.tag.saving.UpdatableMoodTagStorage
import com.niksob.data.storage.provider.AppStringStorage
import com.niksob.di.module.storage.string.StringStorageModule
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [StringStorageModule::class])
class DbMoodTagFirebaseModule {

    @Provides
    fun provideStorage(
        dbProvider: MoodTagFirebaseRefProvider,
        @Named("mood_entry_on_data_loaded_action") loader: FirebaseLoaderImpl,
        @Named("mood_entry_on_data_saved_action") saver: FirebaseSaverImpl,
    ): UpdatableMoodTagStorage =
        DbUpdatableMoodTagFirebase(
            moodTagDbProvider = dbProvider,
            saver = saver,
            loader = loader,
        )

    @Provides
    fun provideDbProvider() = MoodTagFirebaseRefProvider()

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