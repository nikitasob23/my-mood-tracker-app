package com.niksob.app.viewmodel.mood_entry

import com.niksob.data.model.UIMoodEntry
import com.niksob.domain.model.MoodEntryId
import io.reactivex.Single

interface MoodEntryViewModel {
    fun loadById(moodEntryId: MoodEntryId): Single<UIMoodEntry>
}