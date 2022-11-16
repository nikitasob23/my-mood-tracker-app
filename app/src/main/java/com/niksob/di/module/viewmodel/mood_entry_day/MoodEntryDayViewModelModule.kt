package com.niksob.di.module.viewmodel.mood_entry_day

import com.niksob.app.viewmodel.mood_entry.base.observation.MoodEntryDayViewModel
import com.niksob.app.viewmodel.mood_entry_day.MoodEntryDayViewModelImpl
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
class MoodEntryDayViewModelModule {
    @Provides
    fun provideMoodEntryDayViewModel(
        loadMoodEntriesByUserIdAndDateUseCase: LoadMoodEntriesByUserIdAndDateUseCase,
        loadAuthorizeUserIdUseCase: LoadAuthorizeUserIdUseCase,
    ): MoodEntryDayViewModel =
        MoodEntryDayViewModelImpl(
            loadMoodEntriesByUserIdAndDateUseCase = loadMoodEntriesByUserIdAndDateUseCase,
            loadAuthorizeUserIdUseCase = loadAuthorizeUserIdUseCase,
        )
}