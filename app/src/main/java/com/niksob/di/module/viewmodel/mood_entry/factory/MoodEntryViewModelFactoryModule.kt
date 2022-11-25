package com.niksob.di.module.viewmodel.mood_entry.factory

import androidx.lifecycle.ViewModelProvider
import com.niksob.app.viewmodel.base.mood_entry.factory.MoodEntriesViewModelFactory
import com.niksob.data.converter.DataConverter
import com.niksob.data.model.UIMoodEntries
import com.niksob.di.module.converter.UIMoodEntryConverterModule
import com.niksob.di.module.usecase.LoadMoodEntriesByUserIdAndDateUseCaseModule
import com.niksob.di.module.usecase.auth.LoadAuthorizeUserIdUseCaseModule
import com.niksob.domain.model.mood_entry.MoodEntries
import com.niksob.domain.usecase.auth.loading_auth_user.observation.LoadAuthorizeUserIdUseCase
import com.niksob.domain.usecase.db.mood_entry.observation.LoadMoodEntriesByUserIdAndDateUseCase
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        UIMoodEntryConverterModule::class,
        LoadMoodEntriesByUserIdAndDateUseCaseModule::class,
        LoadAuthorizeUserIdUseCaseModule::class,
    ]
)
class MoodEntryViewModelFactoryModule {
    @Provides
    fun provideMoodEntriesViewModelFactory(
        moodEntryUIConverter: DataConverter<MoodEntries, UIMoodEntries>,
        loadMoodEntriesByUserIdAndDateUseCase: LoadMoodEntriesByUserIdAndDateUseCase,
        loadAuthorizeUserIdUseCase: LoadAuthorizeUserIdUseCase,
    ): ViewModelProvider.Factory =
        MoodEntriesViewModelFactory(
            moodEntryUIConverter = moodEntryUIConverter,
            loadMoodEntriesByUserIdAndDateUseCase = loadMoodEntriesByUserIdAndDateUseCase,
            loadAuthorizeUserIdUseCase = loadAuthorizeUserIdUseCase,
        )
}