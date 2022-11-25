package com.niksob.app.view.mood_entry_day.base

import android.annotation.SuppressLint
import com.niksob.app.model.AutoDisposableSingleObserver
import com.niksob.app.view.base.loader.base.with_parameter.ViewDataLoader
import com.niksob.app.view.base.loader.StartDataLoadingUIView
import com.niksob.app.view.mood_entry_day.ui_component.MoodEntriesRecycleUIView
import com.niksob.data.model.UIMoodEntries
import javax.inject.Inject

open class MoodEntryDayUIView : StartDataLoadingUIView() {

    @Inject
    lateinit var moodEntriesLoader: ViewDataLoader<Any, UIMoodEntries>

    @Inject
    lateinit var moodEntriesRecycleView: MoodEntriesRecycleUIView

    @SuppressLint("CheckResult")
    protected open fun loadByDateInterval() =
        moodEntriesLoader.load()
            .subscribe(
                AutoDisposableSingleObserver(
                    onSuccess = moodEntriesRecycleView::bind
                )
            )

    override fun onCreateViewDataLoading() = loadByDateInterval()
}