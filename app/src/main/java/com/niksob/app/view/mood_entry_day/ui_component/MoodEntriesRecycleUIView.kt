package com.niksob.app.view.mood_entry_day.ui_component

import androidx.recyclerview.widget.RecyclerView
import com.niksob.app.view.base.ui_components.ViewComponent
import com.niksob.app.view.mood_entry_day.adapter.factory.MoodEntryAdapterFactory
import com.niksob.data.model.UIMoodEntries

open class MoodEntriesRecycleUIView(
    private val moodEntryRecycleView: RecyclerView,
    private val recyclerViewLayoutManager: RecyclerView.LayoutManager,
    private val moodEntryAdapterFactory: MoodEntryAdapterFactory,
) : ViewComponent<UIMoodEntries> {

    override fun bind(data: UIMoodEntries) {
        moodEntryRecycleView.apply {
            layoutManager = recyclerViewLayoutManager
            adapter = moodEntryAdapterFactory.create(data)
        }
    }
}