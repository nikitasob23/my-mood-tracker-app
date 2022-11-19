package com.niksob.app.view.mood_entry_day.loader

import com.niksob.app.view.base.loader.observation.loader.ViewDataLoader
import com.niksob.app.viewmodel.mood_entry.base.observation.MoodEntryDayViewModel
import com.niksob.domain.model.MoodEntries

class MoodEntryDayViewDataLoader(
    private val viewModel: MoodEntryDayViewModel,
) : ViewDataLoader<MoodEntries> {

    override fun load() = viewModel.loadByDateInterval()
}