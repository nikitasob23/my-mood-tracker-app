package com.niksob.app.view.mood_entry_day.loader

import com.niksob.app.view.base.loader.base.ViewDataLoader
import com.niksob.app.viewmodel.mood_entry_day.MoodEntryDayViewModel
import com.niksob.domain.model.MoodEntries

class MoodEntryDayViewDataLoader(
    private val viewModel: MoodEntryDayViewModel,
) : ViewDataLoader<MoodEntries> {

    override fun load() = viewModel.loadByDateInterval()
}