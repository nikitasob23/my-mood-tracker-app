package com.niksob.di.module.view.mood_entry_day.ui_component

import com.niksob.app.R
import com.niksob.app.model.LayoutId
import dagger.Module
import dagger.Provides

@Module
class MoodEntryDayLayoutIdModule {
    @Provides
    fun provideLayoutId() = LayoutId(R.layout.entries_view)
}