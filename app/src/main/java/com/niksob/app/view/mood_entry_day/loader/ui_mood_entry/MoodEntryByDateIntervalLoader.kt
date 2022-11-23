package com.niksob.app.view.mood_entry_day.loader.ui_mood_entry

import com.niksob.app.view.base.loader.base.with_parameter.ViewDataLoader
import com.niksob.app.viewmodel.mood_entry_day.mood_entry.MoodEntryDayViewModel
import com.niksob.data.model.UIMoodEntries

class MoodEntryByDateIntervalLoader(
    private val viewModel: MoodEntryDayViewModel,
) : ViewDataLoader<Any, UIMoodEntries> {

    override fun load(data: Any?) = viewModel.loadByDateInterval()
}