package com.niksob.di.module.view.moodentry

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.app.viewmodel.MVVMBaseViewModel
import com.niksob.app.viewmodel.moodentry.MoodEntriesViewModel
import com.niksob.app.viewmodel.moodentry.factory.MoodEntriesViewModelFactory
import com.niksob.data.provider.AppStringProvider
import com.niksob.di.module.usecase.LoadMoodEntriesByUserIdUseCaseModule
import com.niksob.di.module.usecase.auth.LoadAuthorizeUserIdUseCaseModule
import com.niksob.domain.model.Query
import com.niksob.domain.usecase.auth.LoadAuthorizeUserIdUseCase
import com.niksob.domain.usecase.db.LoadMoodEntriesByUserIdAndDateUseCase
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        LoadAuthorizeUserIdUseCaseModule::class,
        LoadMoodEntriesByUserIdUseCaseModule::class,
    ]
)
class MoodEntriesViewModule(
    private val viewModelStoreOwner: ViewModelStoreOwner,
    private val viewLifecycleOwner: LifecycleOwner,
    private val moodEntriesObserver: Observer<Query>,
) {

    @Provides
    fun provideViewModelWithObservers(viewModel: MoodEntriesViewModel): MVVMBaseViewModel {
        viewModel.moodEntriesResponse.observe(viewLifecycleOwner, moodEntriesObserver)
        return viewModel
    }

    @Provides
    fun provideViewModel(
        viewModelFactory: ViewModelProvider.Factory,
        viewModelClass: Class<MoodEntriesViewModel>
    ) = ViewModelProvider(viewModelStoreOwner, viewModelFactory)[viewModelClass]

    @Provides
    fun provideViewModelClass() = MoodEntriesViewModel::class.java

    @Provides
    fun provideViewModelFactory(
        loadAuthorizeUserIdUseCase: LoadAuthorizeUserIdUseCase,
        loadMoodEntriesByUserIdUseCase: /*LoadMoodEntriesByUserIdUseCase*/LoadMoodEntriesByUserIdAndDateUseCase,
        stringProvider: AppStringProvider,
    ): ViewModelProvider.Factory =
        MoodEntriesViewModelFactory(
            loadAuthorizeUserIdUseCase = loadAuthorizeUserIdUseCase,
            loadMoodEntriesByUserIdUseCase = loadMoodEntriesByUserIdUseCase,
            stringProvider = stringProvider,
        )
}