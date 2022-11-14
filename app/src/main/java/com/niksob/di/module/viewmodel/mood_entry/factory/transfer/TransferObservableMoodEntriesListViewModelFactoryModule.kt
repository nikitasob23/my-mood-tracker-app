package com.niksob.di.module.viewmodel.mood_entry.factory.transfer

import androidx.lifecycle.ViewModelProvider
import com.niksob.app.viewmodel.mood_entry.factory.TransferObservableMoodEntriesListViewModelFactory
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
class TransferObservableMoodEntriesListViewModelFactoryModule {
    @Provides
    fun provideTransferViewModel(
        loadMoodEntriesByUserIdAndDateUseCase: LoadMoodEntriesByUserIdAndDateUseCase,
        loadAuthorizeUserIdUseCase: LoadAuthorizeUserIdUseCase,
    ): ViewModelProvider.Factory =
        TransferObservableMoodEntriesListViewModelFactory(
            loadMoodEntriesByUserIdAndDateUseCase = loadMoodEntriesByUserIdAndDateUseCase,
            loadAuthorizeUserIdUseCase = loadAuthorizeUserIdUseCase,
        )
}
