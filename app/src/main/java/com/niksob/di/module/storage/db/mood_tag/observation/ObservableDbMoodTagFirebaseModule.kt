package com.niksob.di.module.storage.db.mood_tag.observation

import com.niksob.data.storage.firebase.base.loader.FirebaseStorageLoader
import com.niksob.data.storage.firebase.base.provider.MoodTagFirebaseRefProvider
import com.niksob.data.storage.firebase.base.saver.FirebaseStorageSaver
import com.niksob.data.storage.firebase.mood_tag.loading.database_query.LoadMoodTagsByEntryIdQueryFactory
import com.niksob.data.storage.firebase.mood_tag.saving.observation.ObservableUpdatableMoodTagStorage
import com.niksob.data.storage.firebase.mood_tag.saving.observation.ObservableUpdatableMoodTagStorageImpl
import com.niksob.di.module.storage.db.mood_tag.loader.FirebaseMoodTagStorageLoaderModule
import com.niksob.di.module.storage.db.mood_tag.saver.MoodTagSaverModule
import com.niksob.domain.data.dto.MoodTagDataDto
import com.niksob.domain.data.dto.MoodTagsFirebaseDto
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [
    FirebaseMoodTagStorageLoaderModule::class,
    MoodTagSaverModule::class,
])
class ObservableDbMoodTagFirebaseModule {
    @Provides
    fun provideObservableDbMoodTagFirebase(
        @Named("mood_tag_firebase_storage_saver") saver: FirebaseStorageSaver,
        loader: FirebaseStorageLoader<MoodTagsFirebaseDto>,
        loadByEntryIdQueryFactory: LoadMoodTagsByEntryIdQueryFactory,
    ): ObservableUpdatableMoodTagStorage<MoodTagDataDto, MoodTagsFirebaseDto> =
        ObservableUpdatableMoodTagStorageImpl(
            saver = saver,
            loader = loader,
            loadByEntryIdQueryFactory = loadByEntryIdQueryFactory,
        )

    @Provides
    fun provideLoadByEntryIdQueryFactory(tagDbRefProvider: MoodTagFirebaseRefProvider) =
        LoadMoodTagsByEntryIdQueryFactory(tagDbRefProvider)
}