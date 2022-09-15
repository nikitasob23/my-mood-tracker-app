package com.niksob.di.module.view.moodentry

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.niksob.app.viewmodel.moodentry.MoodEntriesViewModel
import com.niksob.domain.model.Query
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [AppMoodEntriesListViewModule::class])
class AppMoodEntriesListViewWithMVVMObserverModule(
    private val moodEntriesObserver: Observer<Query>,
    private val lifecycleOwner: LifecycleOwner,
) {
    @Provides
    fun provideViewModelWithObserver(
        @Named("mood_entries_view_model") viewModel: MoodEntriesViewModel
    ): MoodEntriesViewModel {
        viewModel.moodEntriesResponse.observe(lifecycleOwner, moodEntriesObserver)
        return viewModel
    }
}