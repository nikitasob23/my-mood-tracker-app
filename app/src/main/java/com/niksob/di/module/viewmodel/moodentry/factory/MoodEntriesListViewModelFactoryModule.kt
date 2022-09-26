package com.niksob.di.module.viewmodel.moodentry.factory

import androidx.lifecycle.ViewModelProvider
import com.niksob.app.viewmodel.moodentry.factory.MoodEntriesListViewModelFactory
import com.niksob.di.module.usecase.LoadMoodEntriesByUserIdUseCaseModule
import com.niksob.di.module.usecase.auth.LoadAuthorizeUserIdUseCaseModule
import com.niksob.domain.usecase.auth.LoadAuthorizeUserIdUseCase
import com.niksob.domain.usecase.db.LoadMoodEntriesByUserIdAndDateUseCase
import dagger.Module
import dagger.Provides

@Module(includes = [
    LoadAuthorizeUserIdUseCaseModule::class,
    LoadMoodEntriesByUserIdUseCaseModule::class,
])
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