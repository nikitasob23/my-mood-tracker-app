package com.niksob.app.viewmodel.moodentry.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.niksob.app.viewmodel.moodentry.observation.ObservableMoodEntriesListViewModelImpl
import com.niksob.app.viewmodel.moodentry.transfer.TransferObservableMoodEntriesListViewModel
import com.niksob.domain.usecase.auth.loading_auth_user.observation.LoadAuthorizeUserIdUseCase
import com.niksob.domain.usecase.db.mood_entry.observation.LoadMoodEntriesByUserIdAndDateUseCase

class TransferObservableMoodEntriesListViewModelFactory(
    private val loadMoodEntriesByUserIdAndDateUseCase: LoadMoodEntriesByUserIdAndDateUseCase,
    private val loadAuthorizeUserIdUseCase: LoadAuthorizeUserIdUseCase,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        val viewModel = ObservableMoodEntriesListViewModelImpl(
            loadMoodEntriesByUserIdAndDateUseCase,
            loadAuthorizeUserIdUseCase
        )
        @Suppress("UNCHECKED_CAST")
        return TransferObservableMoodEntriesListViewModel(viewModel) as T
    }
}