package com.niksob.app.viewmodel.mood_entry.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.niksob.app.viewmodel.mood_entry.base.BaseMoodEntriesListViewModel
import com.niksob.domain.usecase.auth.loading_auth_user.LoadAuthorizeUserIdUseCase
import com.niksob.domain.usecase.db.mood_entry.LoadMoodEntriesByUserIdAndDateUseCase

class MoodEntriesListViewModelFactory(
    private val loadAuthorizeUserIdUseCase: LoadAuthorizeUserIdUseCase,
    private val loadMoodEntriesByUserIdAndDateUseCase: LoadMoodEntriesByUserIdAndDateUseCase,
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        BaseMoodEntriesListViewModel(
            loadAuthorizeUserIdUseCase = loadAuthorizeUserIdUseCase,
            loadMoodEntriesByUserIdAndDateUseCase = loadMoodEntriesByUserIdAndDateUseCase,
        ) as T
}