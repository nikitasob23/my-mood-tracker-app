package com.niksob.app.view.mood_entry_day.adapter.factory

import androidx.recyclerview.widget.RecyclerView
import com.niksob.app.view.mood_entry_day.adapter.MoodEntryAdapter
import com.niksob.data.model.UIMoodEntries

class MoodEntryAdapterFactoryImpl : MoodEntryAdapterFactory {
    override fun create(moodEntries: UIMoodEntries): RecyclerView.Adapter<MoodEntryAdapter.MoodEntryViewHolder> =
        MoodEntryAdapter(moodEntries)
}