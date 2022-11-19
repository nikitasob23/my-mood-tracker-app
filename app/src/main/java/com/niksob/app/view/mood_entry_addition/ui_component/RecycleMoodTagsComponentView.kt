package com.niksob.app.view.mood_entry_addition.ui_component

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.niksob.app.R
import com.niksob.app.view.mood_entry_addition.viewmodel.MoodEntryAdditionStartDataLoaderView
import com.niksob.app.view.mood_entry_day.adapter.MoodTagAdapter
import com.niksob.domain.model.MoodEntries
import com.niksob.domain.model.MoodTag
import com.niksob.domain.model.Query

open class RecycleMoodTagsComponentView : MoodEntryAdditionStartDataLoaderView() {

    protected lateinit var moodTagRecycleView: RecyclerView

    protected open fun initMoodTagsList(moodTags: List<MoodTag>) {
        moodTagRecycleView.apply {
            layoutManager = LinearLayoutManager(
                requireContext().applicationContext,
                LinearLayoutManager.HORIZONTAL,
                true
            )
            adapter = MoodTagAdapter(moodTags)
        }
    }

    override fun onLoadMoodEntryCompleted(response: Query) {
        if (!response.completed) {
            return
        }
        val moodEntry = (response.data as MoodEntries).data.first()
        initMoodTagsList(moodEntry.tags)
    }

    override fun initComponents() {
        super.initComponents()
        moodTagRecycleView = rootView.findViewById(R.id.addition_mood_entry_view_layout__tag_recycle_view)
    }
}