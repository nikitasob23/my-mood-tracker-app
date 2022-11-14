package com.niksob.app.viewmodel.mood_entry_day.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.niksob.app.viewmodel.mood_entry_day.MoodEntryDayViewModelImpl
import com.niksob.domain.usecase.auth.loading_auth_user.observation.LoadAuthorizeUserIdUseCase
import com.niksob.domain.usecase.db.mood_entry.observation.LoadMoodEntriesByUserIdAndDateUseCase

class MoodEntryDayViewModelFactory(
    private val loadMoodEntriesByUserIdAndDateUseCase: LoadMoodEntriesByUserIdAndDateUseCase,
    private val loadAuthorizeUserIdUseCase: LoadAuthorizeUserIdUseCase,
): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        MoodEntryDayViewModelImpl(
            loadMoodEntriesByUserIdAndDateUseCase = loadMoodEntriesByUserIdAndDateUseCase,
            loadAuthorizeUserIdUseCase = loadAuthorizeUserIdUseCase,
        ) as T
}