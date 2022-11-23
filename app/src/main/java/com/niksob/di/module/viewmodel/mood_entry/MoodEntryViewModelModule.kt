package com.niksob.di.module.viewmodel.mood_entry

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.app.viewmodel.base.mood_entry.MoodEntryByIdViewModel
import com.niksob.app.viewmodel.mood_entry.MoodEntryViewModel
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
class MoodEntryViewModelModule {
    @Provides
    fun provideMoodEntryViewModel(
        owner: ViewModelStoreOwner,
        viewModelFactory: ViewModelProvider.Factory,
        viewModelClass: Class<MoodEntryByIdViewModel>,
    ): MoodEntryViewModel =
        ViewModelProvider(owner, viewModelFactory)[viewModelClass]

    @Provides
    fun provideViewModelClass() = MoodEntryByIdViewModel::class.java
}