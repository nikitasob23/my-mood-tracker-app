package com.niksob.di.module.view.mood_entry_day.ui_component.mood_entries_recycle_view

import androidx.recyclerview.widget.RecyclerView
import com.niksob.app.view.mood_entry_day.adapter.factory.MoodEntryAdapterFactory
import com.niksob.app.view.mood_entry_day.ui_component.MoodEntriesRecycleUIView
import dagger.Module
import dagger.Provides

@Module(includes = [MoodEntriesRecycleViewUIComponentModule::class])
class MoodEntriesRecycleViewModule {
    @Provides
    fun provideRecycleView(
        moodEntryRecycleView: RecyclerView,
        layoutManager: RecyclerView.LayoutManager,
        moodEntryAdapterFactory: MoodEntryAdapterFactory,
    ) = MoodEntriesRecycleUIView(
        moodEntryRecycleView = moodEntryRecycleView,
        recyclerViewLayoutManager = layoutManager,
        moodEntryAdapterFactory = moodEntryAdapterFactory,
    )
}