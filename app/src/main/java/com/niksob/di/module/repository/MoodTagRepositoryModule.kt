package com.niksob.di.module.repository

import com.niksob.data.repository.MoodTagRepositoryImpl
import com.niksob.data.storage.db.MoodTagStorage
import com.niksob.di.module.storage.StorageModule
import com.niksob.domain.data.repository.MoodTagRepository
import dagger.Module
import dagger.Provides

@Module(includes = [StorageModule::class])
class MoodTagRepositoryModule {

    @Provides
    fun provideRepository(storage: MoodTagStorage): MoodTagRepository = MoodTagRepositoryImpl(storage)
}