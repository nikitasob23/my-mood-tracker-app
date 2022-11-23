package com.niksob.app.viewmodel.base.mood_entry

import com.niksob.app.viewmodel.mood_entry.MoodEntryViewModel
import com.niksob.data.converter.DataConverter
import com.niksob.data.model.UIMoodEntries
import com.niksob.data.model.UIMoodEntry
import com.niksob.domain.model.MoodEntries
import com.niksob.domain.model.MoodEntryId
import com.niksob.domain.usecase.auth.loading_auth_user.observation.LoadAuthorizeUserIdUseCase
import com.niksob.domain.usecase.db.mood_entry.observation.LoadMoodEntriesByUserIdAndDateUseCase
import io.reactivex.Single

open class MoodEntryByIdViewModel(
    moodEntryUIConverter: DataConverter<MoodEntries, UIMoodEntries>,
    loadMoodEntriesByUserIdAndDateUseCase: LoadMoodEntriesByUserIdAndDateUseCase,
    loadAuthorizeUserIdUseCase: LoadAuthorizeUserIdUseCase,
) : MoodEntryViewModel, MoodEntriesByDateIntervalViewModel(
    moodEntryUIConverter = moodEntryUIConverter,
    loadMoodEntriesByUserIdAndDateUseCase = loadMoodEntriesByUserIdAndDateUseCase,
    loadAuthorizeUserIdUseCase = loadAuthorizeUserIdUseCase,
) {
    override fun loadById(moodEntryId: MoodEntryId): Single<UIMoodEntry> {
        TODO("Not yet implemented")
    }
}