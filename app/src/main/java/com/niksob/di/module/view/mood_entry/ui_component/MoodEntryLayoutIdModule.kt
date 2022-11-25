package com.niksob.di.module.view.mood_entry.ui_component

import com.niksob.app.R
import com.niksob.app.model.LayoutId
import dagger.Module
import dagger.Provides

@Module
class MoodEntryLayoutIdModule {
    @Provides
    fun provideLayoutId() = LayoutId(R.layout.addition_mood_entry_panel_layout)
}