package com.niksob.di.module.viewmodel.moodentry

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.app.viewmodel.moodentry.base.BaseMoodEntriesListViewModel
import com.niksob.app.viewmodel.moodentry.base.MoodEntriesListViewModel
import com.niksob.di.module.app.AppMainActivityViewModelStoreOwnerModule
import com.niksob.di.module.viewmodel.moodentry.factory.MoodEntriesListViewModelFactoryModule
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [
    MoodEntriesListViewModelFactoryModule::class,
    AppMainActivityViewModelStoreOwnerModule::class,
])
class MoodEntriesListViewModule {
    @Provides
    @Named("mood_entries_view_model")
    fun provideViewModel(
        viewModelFactory: ViewModelProvider.Factory,
        viewModelClass: Class<BaseMoodEntriesListViewModel>,
        viewModelStoreOwner: ViewModelStoreOwner,
    ): MoodEntriesListViewModel = ViewModelProvider(viewModelStoreOwner, viewModelFactory)[viewModelClass]

    @Provides
    fun provideViewModelClass() = BaseMoodEntriesListViewModel::class.java
}