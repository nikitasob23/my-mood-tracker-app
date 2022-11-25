package com.niksob.app.view.mood_entry.base

import android.os.Build
import androidx.annotation.RequiresApi
import com.niksob.app.model.AutoDisposableSingleObserver
import com.niksob.app.view.base.loader.StartDataLoadingUIView
import com.niksob.app.view.base.loader.base.with_parameter.ViewDataLoader
import com.niksob.app.view.mood_entry.ui_component.MoodEntryPanelView
import com.niksob.data.model.UIMoodEntry
import com.niksob.domain.model.MoodEntryId
import javax.inject.Inject

open class MoodEntryUIView(
    private val moodEntryId: MoodEntryId,
) : StartDataLoadingUIView() {

    @Inject
    lateinit var moodEntryPanelView: MoodEntryPanelView

    @Inject
    lateinit var moodEntryByIdLoader: ViewDataLoader<MoodEntryId, UIMoodEntry>

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateViewDataLoading() {
        loadMoodEntryById()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    protected open fun loadMoodEntryById() =
        moodEntryByIdLoader.load(moodEntryId)
            .subscribe(
                AutoDisposableSingleObserver<UIMoodEntry>(
                    onSuccess = moodEntryPanelView::bind,
                )
            )
}