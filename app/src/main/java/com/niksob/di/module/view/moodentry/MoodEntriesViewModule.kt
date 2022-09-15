package com.niksob.di.module.view.moodentry

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.app.viewmodel.ViewModelWithLoadingStatus
import com.niksob.app.viewmodel.moodentry.MoodEntriesViewModel
import com.niksob.app.viewmodel.moodentry.MoodEntriesViewModelImpl
import com.niksob.di.module.viewmodel.factory.MoodEntriesListViewModelFactoryModule
import com.niksob.domain.model.Query
import dagger.Module
import dagger.Provides

@Module(includes = [MoodEntriesListViewModelFactoryModule::class])
class MoodEntriesViewModule(
    private val viewModelStoreOwner: ViewModelStoreOwner,
    private val viewLifecycleOwner: LifecycleOwner,
    private val moodEntriesObserver: Observer<Query>,
) {

    @Provides
    fun provideViewModelWithObservers(viewModel: MoodEntriesViewModel): ViewModelWithLoadingStatus {
        viewModel.moodEntriesResponse.observe(viewLifecycleOwner, moodEntriesObserver)
        return viewModel as ViewModelWithLoadingStatus
    }

    @Provides
    fun provideViewModel(
        viewModelFactory: ViewModelProvider.Factory,
        viewModelClass: Class<MoodEntriesViewModelImpl>
    ): MoodEntriesViewModel = ViewModelProvider(viewModelStoreOwner, viewModelFactory)[viewModelClass]

    @Provides
    fun provideViewModelClass() = MoodEntriesViewModelImpl::class.java
}