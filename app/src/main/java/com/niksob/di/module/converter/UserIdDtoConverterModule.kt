package com.niksob.di.module.converter

import com.niksob.data.converter.UserIdDtoConverter
import dagger.Module
import dagger.Provides

@Module
class UserIdDtoConverterModule {
    @Provides
    fun provideUserIdDtoConverter() = UserIdDtoConverter()
}