package com.niksob.di.module.view.mood_entry_day.loader.viewmodel.with_param

import com.niksob.app.view.mood_entry_day.loader.ui_mood_entry.MoodEntryByDateIntervalLoader
import com.niksob.app.viewmodel.mood_entry_day.mood_entry.MoodEntryDayViewModel
import com.niksob.di.module.viewmodel.mood_entry_day.MoodEntryDayViewModelModule
import dagger.Module
import dagger.Provides

@Module(includes = [MoodEntryDayViewModelModule::class])
class MoodEntryViewDataLoaderModule {
    @Provides
    fun provideViewDataLoader(viewModel: MoodEntryDayViewModel) =
        MoodEntryByDateIntervalLoader(viewModel)
}