package com.niksob.app.view.mood_entry.loader

import com.niksob.app.view.base.loader.base.with_parameter.ViewDataLoader
import com.niksob.app.viewmodel.mood_entry.MoodEntryViewModel
import com.niksob.data.model.UIMoodEntry
import com.niksob.domain.model.MoodEntryId

class MoodEntryByIdLoader(
    private val viewModel: MoodEntryViewModel,
) : ViewDataLoader<MoodEntryId, UIMoodEntry> {

    override fun load(data: MoodEntryId?) = viewModel.loadById(data!!)
}