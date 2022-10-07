package com.niksob.di.module.storage.db.moodtag

import com.niksob.data.storage.firebase.base.loader.FirebaseLoaderImpl
import com.niksob.data.storage.firebase.base.provider.MoodTagFirebaseRefProvider
import com.niksob.data.storage.firebase.base.saver.BaseFirebaseSaver
import com.niksob.data.storage.firebase.base.saver.BaseOnDataSavedAction
import com.niksob.data.storage.firebase.base.saver.FirebaseSaver
import com.niksob.data.storage.firebase.mood.tag.loading.data_loaded_action.MoodTagOnDataLoadedAction
import com.niksob.data.storage.firebase.mood.tag.loading.reason.MoodTagLoadResponseReasonProvider
import com.niksob.data.storage.firebase.mood.tag.saving.DbUpdatableMoodTagFirebase
import com.niksob.data.storage.firebase.mood.tag.saving.reason.MoodTagSaveResponseReasonProvider
import com.niksob.data.storage.base.mood.tag.saving.UpdatableMoodTagStorage
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
        @Named("mood_entry_on_data_saved_action") saver: FirebaseSaver,
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
    fun provideFirebaseSaver(@Named("mood_tag_on_data_saved_action") action: BaseOnDataSavedAction): FirebaseSaver =
        BaseFirebaseSaver(action)

    @Provides
    fun provideOnDataLoadedAction(loadReasonProvider: MoodTagLoadResponseReasonProvider) =
        MoodTagOnDataLoadedAction(loadReasonProvider)

    @Provides
    @Named("mood_tag_on_data_saved_action")
    fun provideOnDataSavedAction(reasonProvider: MoodTagSaveResponseReasonProvider) =
        BaseOnDataSavedAction(reasonProvider)

    @Provides
    fun provideMoodTagLoadResponseReasonProvider(stringStorage: AppStringStorage) =
        MoodTagLoadResponseReasonProvider(stringStorage)

    @Provides
    fun provideMoodTagSaveResponseReasonProvider(stringStorage: AppStringStorage) =
        MoodTagSaveResponseReasonProvider(stringStorage)
}