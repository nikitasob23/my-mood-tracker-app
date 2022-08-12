package com.niksob.di.module.repository

import com.niksob.data.repository.MoodEntryRepositoryImpl
import com.niksob.data.storage.db.MoodEntryStorage
import com.niksob.di.module.storage.StorageModule
import com.niksob.domain.data.repository.MoodEntryRepository
import dagger.Module
import dagger.Provides

@Module(includes = [StorageModule::class])
class MoodEntryRepositoryModule {
    @Provides
    fun provideMoodEntryRepository(storage: MoodEntryStorage): MoodEntryRepository = MoodEntryRepositoryImpl(storage)
}
