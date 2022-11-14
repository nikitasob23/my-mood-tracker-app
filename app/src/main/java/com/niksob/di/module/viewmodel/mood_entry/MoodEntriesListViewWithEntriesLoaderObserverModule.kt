package com.niksob.di.module.viewmodel.mood_entry

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.niksob.app.viewmodel.moodentry.base.MoodEntriesListViewModel
import com.niksob.domain.model.Query
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [MoodEntriesListViewModule::class])
class MoodEntriesListViewWithEntriesLoaderObserverModule(
    private val moodEntriesObserver: Observer<Query>,
    private val lifecycleOwner: LifecycleOwner,
) {
    @Provides
    fun provideViewModelWithObserver(
        @Named("mood_entries_view_model") viewModel: MoodEntriesListViewModel
    ): MoodEntriesListViewModel {
        viewModel.moodEntriesResponse.observe(lifecycleOwner, moodEntriesObserver)
        return viewModel
    }
}