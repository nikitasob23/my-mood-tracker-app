package com.niksob.di.module.repository

import com.niksob.data.repository.mood_tag.MoodTagRepositoryImpl
import com.niksob.data.repository.mood_tag.observation.saving.ObservableUpdatableMoodTagRepositoryImpl
import com.niksob.data.storage.base.mood.tag.saving.UpdatableMoodTagStorage
import com.niksob.data.storage.firebase.mood_tag.saving.observation.ObservableUpdatableMoodTagStorage
import com.niksob.di.module.storage.StorageModule
import com.niksob.domain.data.dto.MoodTagDataDto
import com.niksob.domain.data.dto.MoodTagsFirebaseDto
import com.niksob.domain.data.repository.mood_tag.MoodTagRepository
import com.niksob.domain.data.repository.mood_tag.observation.saving.ObservableUpdatableMoodTagRepository
import dagger.Module
import dagger.Provides

@Module(includes = [StorageModule::class])
class MoodTagRepositoryModule {

    @Provides
    fun provideMoodTagRepository(storage: UpdatableMoodTagStorage): MoodTagRepository = MoodTagRepositoryImpl(storage)

    @Provides
    fun provideObservableUpdatableMoodTagRepository(
        storage: ObservableUpdatableMoodTagStorage<MoodTagDataDto, MoodTagsFirebaseDto>,
    ): ObservableUpdatableMoodTagRepository<MoodTagDataDto, MoodTagsFirebaseDto> =
        ObservableUpdatableMoodTagRepositoryImpl(storage)
}