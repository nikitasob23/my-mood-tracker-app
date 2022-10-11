package com.niksob.app.view.moodentrieslist.viewmodel.startdataloader

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.niksob.app.view.moodentrieslist.ui_component.MoodEntriesListWithRecycleViewWithEntriesLoader

open class MoodEntriesListViewWithStartDataLoaderWithEntriesLoader : MoodEntriesListWithRecycleViewWithEntriesLoader() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        rootView = super.onCreateView(inflater, container, savedInstanceState)
        onCreateViewDataLoading()
        return rootView
    }

    private fun onCreateViewDataLoading() {
        loadMoodEntriesByUserId()
    }
}