package com.niksob.di.module.viewmodel.moodentry

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.app.viewmodel.moodentry.MoodEntriesViewModel
import com.niksob.app.viewmodel.moodentry.MoodEntriesViewModelImpl
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
        viewModelClass: Class<MoodEntriesViewModelImpl>,
        viewModelStoreOwner: ViewModelStoreOwner,
    ): MoodEntriesViewModel = ViewModelProvider(viewModelStoreOwner, viewModelFactory)[viewModelClass]

    @Provides
    fun provideViewModelClass() = MoodEntriesViewModelImpl::class.java
}