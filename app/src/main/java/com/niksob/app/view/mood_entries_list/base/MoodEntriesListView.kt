package com.niksob.app.view.mood_entries_list.base

import com.niksob.app.R
import com.niksob.app.view.base.viewmodel.mood_entry.injection.InjectedMoodEntriesLoaderView

open class MoodEntriesListView : InjectedMoodEntriesLoaderView() {

    override val layout get() = R.layout.entries_view
}