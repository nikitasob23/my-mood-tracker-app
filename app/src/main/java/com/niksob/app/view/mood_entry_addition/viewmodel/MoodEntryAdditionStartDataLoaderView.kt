package com.niksob.app.view.mood_entry_addition.viewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.niksob.app.view.base.loader.StartDataLoader
import com.niksob.app.view.mood_entry_addition.viewmodel.injection.InjectableMoodEntryLoader

open class MoodEntryAdditionStartDataLoaderView : StartDataLoader, InjectableMoodEntryLoader() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        rootView = super.onCreateView(inflater, container, savedInstanceState)
        onCreateViewDataLoading()
        return rootView
    }

    override fun onCreateViewDataLoading() = loadMoodEntryByUserId()
}