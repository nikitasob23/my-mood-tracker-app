package com.niksob.app.view.mood_entry_day.base

import android.annotation.SuppressLint
import com.niksob.app.model.AutoDisposableSingleObserver
import com.niksob.app.view.base.loader.observation.loader.ViewDataLoader
import com.niksob.app.view.base.loader.ui_view.StartDataLoadingUIView
import com.niksob.app.view.mood_entry_day.ui_component.MoodEntriesRecycleUIView
import com.niksob.domain.model.MoodEntries
import javax.inject.Inject

open class MoodEntryDayUIView : StartDataLoadingUIView() {

    @Inject
    lateinit var moodEntriesLoader: ViewDataLoader<MoodEntries>

    @Inject
    lateinit var moodEntriesRecycleView: MoodEntriesRecycleUIView

    @SuppressLint("CheckResult")
    protected open fun loadByDateInterval() {
        moodEntriesLoader.load()
            .subscribeWith(
                AutoDisposableSingleObserver(
                    onSuccess = moodEntriesRecycleView::configureMoodEntryRecycleView
                )
            )
    }

    override fun onCreateViewDataLoading() = loadByDateInterval()
}