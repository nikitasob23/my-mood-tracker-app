package com.niksob.app.view.mood_entries_list.adapter.factory

import com.niksob.app.view.mood_entries_list.adapter.MoodEntryAdapter
import com.niksob.domain.model.MoodEntries

class MoodEntryAdapterFactoryImpl : MoodEntryAdapterFactory {

    override fun create(moodEntries: MoodEntries) =
        MoodEntryAdapter(moodEntries)
}