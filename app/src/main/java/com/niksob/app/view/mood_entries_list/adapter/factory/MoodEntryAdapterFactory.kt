package com.niksob.app.view.mood_entries_list.adapter.factory

import androidx.recyclerview.widget.RecyclerView
import com.niksob.app.view.mood_entries_list.adapter.MoodEntryAdapter
import com.niksob.domain.model.MoodEntries

interface MoodEntryAdapterFactory {
    fun create(moodEntries: MoodEntries): RecyclerView.Adapter<MoodEntryAdapter.MoodEntryViewHolder>
}