package com.niksob.app.view.moodentrieslist.ui_component

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.niksob.app.R
import com.niksob.app.view.moodentrieslist.adapter.MoodEntryAdapter
import com.niksob.app.view.moodentrieslist.viewmodel.entryloader.InjectedMoodEntriesListViewWithEntriesLoader
import com.niksob.domain.model.MoodEntries
import com.niksob.domain.model.MoodEntry
import com.niksob.domain.model.Query

open class MoodEntriesListWithRecycleViewWithEntriesLoader : InjectedMoodEntriesListViewWithEntriesLoader() {

    protected lateinit var moodEntryRecycleView: RecyclerView

    override fun onLoadMoodEntriesCompleted(response: Query) {
        if (!response.completed) {
            return
        }
        val moodEntries = response.data as MoodEntries

        initMoodEntriesButtonCallbacks(moodEntries)
        initMoodEntriesList(moodEntries)
    }

    override fun initComponents() {
        super.initComponents()
        moodEntryRecycleView = rootView.findViewById(R.id.entries_view__entry_recycle_view)
    }

    protected open fun initMoodEntriesList(moodEntries: MoodEntries) {
        moodEntryRecycleView.apply {
            layoutManager = LinearLayoutManager(requireContext().applicationContext)
            adapter = MoodEntryAdapter(moodEntries)
        }
    }

    protected open fun initMoodEntriesButtonCallbacks(moodEntries: MoodEntries) {
        moodEntries.data.forEach { entry ->
            entry.clickCallback = { onClickMoodEntryButton(entry) }
        }
    }

    protected open fun onClickMoodEntryButton(moodEntry: MoodEntry) {
        moveMoodEntryAdditionScreen(moodEntry)
    }
}