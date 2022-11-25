package com.niksob.di.module.viewmodel.mood_entry_day.factory

import androidx.lifecycle.ViewModelProvider
import com.niksob.app.viewmodel.mood_entry_day.factory.MoodEntryDayViewModelFactory
import com.niksob.di.module.usecase.LoadMoodEntriesByUserIdAndDateUseCaseModule
import com.niksob.di.module.usecase.auth.LoadAuthorizeUserIdUseCaseModule
import com.niksob.domain.usecase.auth.loading_auth_user.observation.LoadAuthorizeUserIdUseCase
import com.niksob.domain.usecase.db.mood_entry.observation.LoadMoodEntriesByUserIdAndDateUseCase
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        LoadMoodEntriesByUserIdAndDateUseCaseModule::class,
        LoadAuthorizeUserIdUseCaseModule::class,
    ]
)
class MoodEntryDayViewModelFactoryModule {
    @Provides
    fun provideObservableMoodEntriesListViewModelFactory(
        loadMoodEntriesByUserIdAndDateUseCase : LoadMoodEntriesByUserIdAndDateUseCase,
        loadAuthorizeUserIdUseCase: LoadAuthorizeUserIdUseCase,
    ): ViewModelProvider.Factory =
        MoodEntryDayViewModelFactory(
            loadMoodEntriesByUserIdAndDateUseCase = loadMoodEntriesByUserIdAndDateUseCase,
            loadAuthorizeUserIdUseCase = loadAuthorizeUserIdUseCase,
        )
}