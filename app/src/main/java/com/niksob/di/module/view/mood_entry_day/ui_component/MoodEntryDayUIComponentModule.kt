package com.niksob.di.module.view.mood_entry_day.ui_component

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.niksob.app.R
import com.niksob.app.view.mood_entries_list.adapter.factory.MoodEntryAdapterFactory
import com.niksob.app.view.mood_entries_list.adapter.factory.MoodEntryAdapterFactoryImpl
import dagger.Module
import dagger.Provides

@Module
class MoodEntryDayUIComponentModule(
    private val view: View,
) {

    @Provides
    fun provideMoodEntryRecycleView(): RecyclerView = view.findViewById(R.id.entries_view__entry_recycle_view)

    @Provides
    fun provideMoodEntryAdapterFactory(): MoodEntryAdapterFactory = MoodEntryAdapterFactoryImpl()
}