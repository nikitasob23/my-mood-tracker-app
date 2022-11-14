package com.niksob.di.module.viewmodel.mood_entry.factory

import androidx.lifecycle.ViewModelProvider
import com.niksob.app.viewmodel.mood_entry.factory.MoodEntriesListViewModelFactory
import com.niksob.di.module.usecase.LoadMoodEntriesByUserIdAndDateUseCaseModule
import com.niksob.di.module.usecase.auth.LoadAuthorizeUserIdUseCaseModule
import com.niksob.domain.usecase.auth.loading_auth_user.LoadAuthorizeUserIdUseCase
import com.niksob.domain.usecase.db.mood_entry.LoadMoodEntriesByUserIdAndDateUseCase
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        LoadAuthorizeUserIdUseCaseModule::class,
        LoadMoodEntriesByUserIdAndDateUseCaseModule::class,
    ]
)
class MoodEntriesListViewModelFactoryModule {
    @Provides
    fun provideViewModelFactory(
        loadAuthorizeUserIdUseCase: LoadAuthorizeUserIdUseCase,
        loadMoodEntriesByUserIdAndDateUseCase: LoadMoodEntriesByUserIdAndDateUseCase,
    ): ViewModelProvider.Factory =
        MoodEntriesListViewModelFactory(
            loadAuthorizeUserIdUseCase = loadAuthorizeUserIdUseCase,
            loadMoodEntriesByUserIdAndDateUseCase = loadMoodEntriesByUserIdAndDateUseCase,
        )
}