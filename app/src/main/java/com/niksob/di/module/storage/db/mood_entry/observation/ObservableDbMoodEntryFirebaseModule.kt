package com.niksob.di.module.storage.db.mood_entry.observation

import com.niksob.data.storage.firebase.base.loader.FirebaseStorageLoader
import com.niksob.data.storage.firebase.base.saver.FirebaseStorageSaver
import com.niksob.data.storage.firebase.mood_entry.loading.database_query.LoadMoodEntriesByDateIntervalQueryFactory
import com.niksob.data.storage.firebase.mood_entry.saving.observation.ObservableUpdatableMoodEntryStorage
import com.niksob.data.storage.firebase.mood_entry.saving.observation.ObservableUpdatableMoodEntryStorageImpl
import com.niksob.di.module.storage.db.mood_entry.saver.MoodEntrySaverModule
import com.niksob.di.module.storage.db.mood_entry.loader.FirebaseMoodEntryStorageLoaderModule
import com.niksob.domain.data.dto.MoodEntriesDataDto
import com.niksob.domain.data.dto.MoodEntriesDto
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(
    includes = [
        FirebaseMoodEntryStorageLoaderModule::class,
        MoodEntrySaverModule::class,
    ]
)
class ObservableDbMoodEntryFirebaseModule {

    @Provides
    fun provideObservableDbMoodEntryFirebase(
        @Named("mood_entry_firebase_storage_saver") saver: FirebaseStorageSaver,
        loader: FirebaseStorageLoader<MoodEntriesDto>,
        loadByDateIntervalQueryFactory: LoadMoodEntriesByDateIntervalQueryFactory,
    ): ObservableUpdatableMoodEntryStorage<MoodEntriesDataDto, MoodEntriesDto> =
        ObservableUpdatableMoodEntryStorageImpl(
            saver = saver,
            loader = loader,
            loadByDateIntervalQueryFactory = loadByDateIntervalQueryFactory,
            loadByIdQueryFactory = loadByDateIntervalQueryFactory,
        )
}