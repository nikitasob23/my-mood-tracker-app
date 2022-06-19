package com.niksob.app.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.niksob.app.viewmodel.MoodEntriesViewModel
import com.niksob.data.provider.AppStringProvider
import com.niksob.domain.usecase.auth.LoadAuthorizeUserIdUseCase
import com.niksob.domain.usecase.db.LoadMoodEntriesByUserIdUseCase

@Suppress("UNCHECKED_CAST")
class MoodEntriesViewModelFactory(
    private val loadAuthorizeUserIdUseCase: LoadAuthorizeUserIdUseCase,
    private val loadMoodEntriesByUserIdUseCase: LoadMoodEntriesByUserIdUseCase,
    private val stringProvider: AppStringProvider,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        MoodEntriesViewModel(
            loadAuthorizeUserIdUseCase = loadAuthorizeUserIdUseCase,
            loadMoodEntriesByUserIdUseCase = loadMoodEntriesByUserIdUseCase,
            stringProvider = stringProvider,
        ) as T
}