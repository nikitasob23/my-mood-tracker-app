package com.niksob.app.view.mood_entry_day.adapter.factory

import androidx.recyclerview.widget.RecyclerView
import com.niksob.app.view.mood_entry_day.adapter.MoodEntryAdapter
import com.niksob.domain.model.MoodEntries

class MoodEntryAdapterFactoryImpl : MoodEntryAdapterFactory {
    override fun create(moodEntries: MoodEntries): RecyclerView.Adapter<MoodEntryAdapter.MoodEntryViewHolder> =
        MoodEntryAdapter(moodEntries)
}