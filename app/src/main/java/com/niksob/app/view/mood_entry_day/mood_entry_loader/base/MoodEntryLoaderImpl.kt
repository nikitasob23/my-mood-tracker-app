package com.niksob.app.view.mood_entry_day.mood_entry_loader.base

import com.niksob.app.viewmodel.mood_entry.base.observation.MoodEntryDayViewModel

open class MoodEntryLoaderImpl(
    private val moodEntryViewModel: MoodEntryDayViewModel,
) : MoodEntryLoader {

    override fun loadByDateInterval() = moodEntryViewModel.loadByDateInterval()
}