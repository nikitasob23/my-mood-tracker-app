package com.niksob.di.module.storage.db.mood_entry.loader

import com.niksob.data.converter.firebase_dto_converter.base.FirebaseDtoConverter
import com.niksob.data.storage.firebase.base.loader.FirebaseStorageLoader
import com.niksob.data.storage.firebase.base.loader.FirebaseStorageLoaderImpl
import com.niksob.di.module.converter.MoodEntryFirebaseDtoConverterModule
import com.niksob.domain.data.dto.MoodEntriesDto
import dagger.Module
import dagger.Provides

@Module(includes = [MoodEntryFirebaseDtoConverterModule::class])
class FirebaseMoodEntryStorageLoaderModule {
    @Provides
    fun provideFirebaseStorageLoader(
        dtoConverter: FirebaseDtoConverter<MoodEntriesDto>,
    ): FirebaseStorageLoader<MoodEntriesDto> = FirebaseStorageLoaderImpl(dtoConverter)
}