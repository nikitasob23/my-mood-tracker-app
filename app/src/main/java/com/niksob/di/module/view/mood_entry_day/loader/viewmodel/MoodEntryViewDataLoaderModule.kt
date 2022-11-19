package com.niksob.di.module.view.mood_entry_day.loader.viewmodel

import com.niksob.app.view.mood_entry_day.loader.MoodEntryDayViewDataLoader
import com.niksob.app.viewmodel.mood_entry.base.observation.MoodEntryDayViewModel
import com.niksob.di.module.viewmodel.mood_entry_day.MoodEntryDayViewModelModule
import dagger.Module
import dagger.Provides

@Module(includes = [MoodEntryDayViewModelModule::class])
class MoodEntryViewDataLoaderModule {
    @Provides
    fun provideViewDataLoader(viewModel: MoodEntryDayViewModel) =
        MoodEntryDayViewDataLoader(viewModel)
}