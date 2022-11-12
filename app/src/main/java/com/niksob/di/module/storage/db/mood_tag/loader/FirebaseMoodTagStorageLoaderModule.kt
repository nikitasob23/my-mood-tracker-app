package com.niksob.di.module.storage.db.mood_tag.loader

import com.niksob.data.converter.firebase_dto_converter.base.FirebaseDtoConverter
import com.niksob.data.storage.firebase.base.loader.FirebaseStorageLoader
import com.niksob.data.storage.firebase.base.loader.FirebaseStorageLoaderImpl
import com.niksob.di.module.converter.MoodTagFirebaseDtoConverterModule
import com.niksob.domain.data.dto.MoodTagsFirebaseDto
import dagger.Module
import dagger.Provides

@Module(includes = [MoodTagFirebaseDtoConverterModule::class])
class FirebaseMoodTagStorageLoaderModule {
    @Provides
    fun provideFirebaseStorageLoader(
        dtoConverter: FirebaseDtoConverter<MoodTagsFirebaseDto>,
    ): FirebaseStorageLoader<MoodTagsFirebaseDto> = FirebaseStorageLoaderImpl(dtoConverter)
}