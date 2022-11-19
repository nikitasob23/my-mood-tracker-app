package com.niksob.di.module.viewmodel.mood_entry_day

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.app.viewmodel.mood_entry_day.MoodEntryDayViewModel
import com.niksob.app.viewmodel.mood_entry_day.MoodEntryDayViewModelImpl
import com.niksob.di.module.app.AppMainActivityViewModelStoreOwnerModule
import com.niksob.di.module.viewmodel.mood_entry_day.factory.MoodEntryDayViewModelFactoryModule
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        MoodEntryDayViewModelFactoryModule::class,
        AppMainActivityViewModelStoreOwnerModule::class,
    ]
)
class MoodEntryDayViewModelModule {
    @Provides
    fun provideMoodEntryDayViewModel(
        owner: ViewModelStoreOwner,
        viewModelFactory: ViewModelProvider.Factory,
        viewModelClass: Class<MoodEntryDayViewModelImpl>,
    ): MoodEntryDayViewModel =
        ViewModelProvider(owner, viewModelFactory)[viewModelClass]

    @Provides
    fun provideViewModelClass() = MoodEntryDayViewModelImpl::class.java
}