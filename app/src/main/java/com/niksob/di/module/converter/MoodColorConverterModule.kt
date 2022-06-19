package com.niksob.di.module.converter

import com.niksob.di.module.provider.AppColorProviderModule
import com.niksob.data.converter.MoodColorIdConverterImpl
import com.niksob.domain.data.provider.AppColorIdProvider
import dagger.Module
import dagger.Provides

@Module(includes = [AppColorProviderModule::class])
class MoodColorConverterModule {
    @Provides
    fun provideMoodColorConverter(colorProvider: AppColorIdProvider) =
        MoodColorIdConverterImpl(colorProvider)
}
