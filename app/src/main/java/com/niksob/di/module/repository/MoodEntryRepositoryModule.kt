package com.niksob.di.module.repository

import com.niksob.data.repository.mood_entry.MoodEntryRepositoryImpl
import com.niksob.data.repository.mood_entry.observation.saving.ObservableUpdatableMoodEntryRepositoryImpl
import com.niksob.data.storage.base.mood.entry.saving.UpdatableMoodEntryStorage
import com.niksob.data.storage.firebase.mood_entry.saving.observation.ObservableUpdatableMoodEntryStorage
import com.niksob.di.module.storage.StorageModule
import com.niksob.domain.data.dto.MoodEntriesDataDto
import com.niksob.domain.data.dto.MoodEntriesDto
import com.niksob.domain.data.repository.mood_entry.MoodEntryRepository
import com.niksob.domain.data.repository.mood_entry.observation.loading.ObservableLoadableMoodEntryRepository
import dagger.Module
import dagger.Provides

@Module(includes = [StorageModule::class])
class MoodEntryRepositoryModule {
    @Provides
    fun provideMoodEntryRepository(storage: UpdatableMoodEntryStorage): MoodEntryRepository =
        MoodEntryRepositoryImpl(storage)

    @Provides
    fun provideObservableMoodEntryRepository(
        storage: ObservableUpdatableMoodEntryStorage<MoodEntriesDataDto, MoodEntriesDto>,
    ): ObservableLoadableMoodEntryRepository<MoodEntriesDataDto, MoodEntriesDto> =
        ObservableUpdatableMoodEntryRepositoryImpl(storage)
}
