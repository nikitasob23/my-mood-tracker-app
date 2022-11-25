package com.niksob.app.viewmodel.base.mood_entry.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.niksob.app.viewmodel.base.mood_entry.MoodEntryByIdViewModel
import com.niksob.data.converter.DataConverter
import com.niksob.data.model.UIMoodEntries
import com.niksob.domain.model.mood_entry.MoodEntries
import com.niksob.domain.usecase.auth.loading_auth_user.observation.LoadAuthorizeUserIdUseCase
import com.niksob.domain.usecase.db.mood_entry.observation.LoadMoodEntriesByUserIdAndDateUseCase

class MoodEntriesViewModelFactory(
    private val moodEntryUIConverter: DataConverter<MoodEntries, UIMoodEntries>,
    private val loadMoodEntriesByUserIdAndDateUseCase: LoadMoodEntriesByUserIdAndDateUseCase,
    private val loadAuthorizeUserIdUseCase: LoadAuthorizeUserIdUseCase,
): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        MoodEntryByIdViewModel(
            moodEntryUIConverter = moodEntryUIConverter,
            loadMoodEntriesByUserIdAndDateUseCase = loadMoodEntriesByUserIdAndDateUseCase,
            loadAuthorizeUserIdUseCase = loadAuthorizeUserIdUseCase,
        ) as T
}