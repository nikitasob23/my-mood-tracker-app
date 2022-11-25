package com.niksob.app.view.mood_entry_day.adapter.factory

import androidx.recyclerview.widget.RecyclerView
import com.niksob.app.view.mood_entry_day.adapter.MoodEntryAdapter
import com.niksob.data.model.UIMoodEntries

interface MoodEntryAdapterFactory {
    fun create(moodEntries: UIMoodEntries): RecyclerView.Adapter<MoodEntryAdapter.MoodEntryViewHolder>
}