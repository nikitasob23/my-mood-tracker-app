package com.niksob.app.viewmodel.mood_entry_day.mood_entry

import com.niksob.data.model.UIMoodEntries
import io.reactivex.Single

interface MoodEntryDayViewModel {

    fun loadByDateInterval(): Single<UIMoodEntries>
}