package com.niksob.app.viewmodel.mood_entry_day

import com.niksob.domain.model.mood_entry.MoodEntries
import io.reactivex.Single

interface MoodEntryDayViewModel {

    fun loadByDateInterval(): Single<MoodEntries>
}