package com.niksob.di.module.view.mood_entry.loader

import com.niksob.app.view.mood_entry.loader.MoodEntryByIdLoader
import com.niksob.app.viewmodel.mood_entry.MoodEntryViewModel
import com.niksob.di.module.viewmodel.mood_entry.MoodEntryViewModelModule
import dagger.Module
import dagger.Provides

@Module(includes = [MoodEntryViewModelModule::class])
class MoodEntryDataLoaderModule {
    @Provides
    fun provideMoodEntryByIdLoader(viewModel: MoodEntryViewModel) = MoodEntryByIdLoader(viewModel)
}