package com.niksob.di.module.viewmodel.mood_entry_day

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.app.viewmodel.base.mood_entry.MoodEntriesByDateIntervalViewModel
import com.niksob.app.viewmodel.mood_entry_day.mood_entry.MoodEntryDayViewModel
import com.niksob.di.module.app.AppMainActivityViewModelStoreOwnerModule
import com.niksob.di.module.viewmodel.mood_entry.factory.MoodEntryViewModelFactoryModule
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        MoodEntryViewModelFactoryModule::class,
        AppMainActivityViewModelStoreOwnerModule::class,
    ]
)
class MoodEntryDayViewModelModule {
    @Provides
    fun provideMoodEntryDayViewModel(
        owner: ViewModelStoreOwner,
        viewModelFactory: ViewModelProvider.Factory,
        viewModelClass: Class<MoodEntriesByDateIntervalViewModel>,
    ): MoodEntryDayViewModel =
        ViewModelProvider(owner, viewModelFactory)[viewModelClass]

    @Provides
    fun provideViewModelClass() = MoodEntriesByDateIntervalViewModel::class.java
}