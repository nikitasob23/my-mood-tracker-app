package com.niksob.app.view.mood_entry_day.mood_entry_loader.base

import com.niksob.domain.model.MoodEntries
import io.reactivex.Single

interface MoodEntryLoader {
    fun loadByDateInterval(): Single<MoodEntries>
}