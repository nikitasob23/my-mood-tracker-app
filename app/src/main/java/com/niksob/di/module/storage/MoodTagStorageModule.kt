package com.niksob.di.module.storage

import com.niksob.data.provider.DbProvider
import com.niksob.data.storage.db.MoodTagStorage
import com.niksob.data.storage.db.firebase.loader.OnDataLoadedAction
import com.niksob.data.storage.db.firebase.saver.OnDataSavedAction
import com.niksob.data.storage.db.firebase.loader.FirebaseLoader
import com.niksob.data.storage.db.firebase.loader.FirebaseLoaderImpl
import com.niksob.data.storage.db.firebase.saver.FirebaseSaver
import com.niksob.data.storage.db.firebase.screen.mood.tag.DbMoodTagFirebase
import com.niksob.data.storage.db.firebase.screen.mood.tag.loading.MoodTagLoadResponseReasonProvider
import com.niksob.data.storage.db.firebase.screen.mood.tag.loading.MoodTagOnDataLoadedAction
import com.niksob.data.storage.db.firebase.saver.FirebaseSaverImpl
import com.niksob.data.storage.db.firebase.screen.mood.tag.saving.MoodTagOnDataSavedAction
import com.niksob.data.storage.db.firebase.screen.mood.tag.saving.MoodTagSaveResponseReasonProvider
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
        loader: FirebaseLoader,
        saver: FirebaseSaver,
    ): MoodTagStorage =
        DbMoodTagFirebase(
            dbProvider = dbProvider,
            loader = loader,
            saver = saver,
        )

    @Provides
    fun provideFirebaseLoader(action: OnDataLoadedAction): FirebaseLoader = FirebaseLoaderImpl(action)

    @Provides
    fun provideFirebaseSaver(action: OnDataSavedAction): FirebaseSaver = FirebaseSaverImpl(action)

    @Provides
    fun provideOnDataLoadedAction(loadReasonProvider: MoodTagLoadResponseReasonProvider): OnDataLoadedAction =
        MoodTagOnDataLoadedAction(loadReasonProvider)

    @Provides
    fun provideOnDataSavedAction(reasonProvider: MoodTagSaveResponseReasonProvider): OnDataSavedAction =
        MoodTagOnDataSavedAction(reasonProvider)

    @Provides
    fun provideMoodTagLoadResponseReasonProvider(stringStorage: AppStringStorage) =
        MoodTagLoadResponseReasonProvider(stringStorage)

    @Provides
    fun provideMoodTagSaveResponseReasonProvider(stringStorage: AppStringStorage) =
        MoodTagSaveResponseReasonProvider(stringStorage)
}