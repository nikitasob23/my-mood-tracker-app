package com.niksob.di.module.viewmodel.auth.moodentry.factory

import androidx.lifecycle.ViewModelProvider
import com.niksob.app.viewmodel.moodentry.MoodEntriesViewModelFactory
import com.niksob.data.provider.AppStringProvider
import com.niksob.di.module.storage.string.StringStorageModule
import com.niksob.di.module.usecase.LoadMoodEntriesByUserIdUseCaseModule
import com.niksob.di.module.usecase.auth.LoadAuthorizeUserIdUseCaseModule
import com.niksob.domain.usecase.auth.LoadAuthorizeUserIdUseCase
import com.niksob.domain.usecase.db.LoadMoodEntriesByUserIdAndDateUseCase
import dagger.Module
import dagger.Provides

@Module(includes = [
    LoadAuthorizeUserIdUseCaseModule::class,
    LoadMoodEntriesByUserIdUseCaseModule::class,
    StringStorageModule::class,
])
class MoodEntriesListViewModelFactoryModule {
    @Provides
    fun provideViewModelFactory(
        loadAuthorizeUserIdUseCase: LoadAuthorizeUserIdUseCase,
        loadMoodEntriesByUserIdAndDateUseCase: LoadMoodEntriesByUserIdAndDateUseCase,
        stringProvider: AppStringProvider,
    ): ViewModelProvider.Factory =
        MoodEntriesViewModelFactory(
            loadAuthorizeUserIdUseCase = loadAuthorizeUserIdUseCase,
            loadMoodEntriesByUserIdAndDateUseCase = loadMoodEntriesByUserIdAndDateUseCase,
            stringProvider = stringProvider,
        )
}