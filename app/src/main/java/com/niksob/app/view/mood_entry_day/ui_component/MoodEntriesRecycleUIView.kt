package com.niksob.app.view.mood_entry_day.ui_component

import androidx.recyclerview.widget.RecyclerView
import com.niksob.app.view.mood_entry_day.adapter.factory.MoodEntryAdapterFactory
import com.niksob.domain.model.MoodEntries

open class MoodEntriesRecycleUIView(
    private val moodEntryRecycleView: RecyclerView,
    private val recyclerViewLayoutManager: RecyclerView.LayoutManager,
    private val moodEntryAdapterFactory: MoodEntryAdapterFactory,
) {

    fun configureMoodEntryRecycleView(moodEntries: MoodEntries) {
        moodEntryRecycleView.apply {
            layoutManager = recyclerViewLayoutManager
            adapter = moodEntryAdapterFactory.create(moodEntries)
        }
    }
}