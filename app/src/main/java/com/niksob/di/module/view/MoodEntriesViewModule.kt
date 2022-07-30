package com.niksob.di.module.view

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.app.viewmodel.moodentry.MoodEntriesViewModel
import com.niksob.app.viewmodel.moodentry.MoodEntriesViewModelImpl
import com.niksob.app.viewmodel.moodentry.MoodEntriesViewModelFactory
import com.niksob.data.provider.AppStringProvider
import com.niksob.di.module.usecase.LoadMoodEntriesByUserIdUseCaseModule
import com.niksob.di.module.usecase.auth.LoadAuthorizeUserIdUseCaseModule
import com.niksob.domain.usecase.auth.LoadAuthorizeUserIdUseCase
import com.niksob.domain.usecase.db.LoadMoodEntriesByUserIdUseCase
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
) {
    @Provides
    fun provideViewModel(
        viewModelFactory: ViewModelProvider.Factory,
        viewModelClass: Class<MoodEntriesViewModelImpl>
    ): MoodEntriesViewModel =
        ViewModelProvider(viewModelStoreOwner, viewModelFactory)[viewModelClass]

    @Provides
    fun provideViewModelClass() = MoodEntriesViewModelImpl::class.java

    @Provides
    fun provideViewModelFactory(
        loadAuthorizeUserIdUseCase: LoadAuthorizeUserIdUseCase,
        loadMoodEntriesByUserIdUseCase: LoadMoodEntriesByUserIdUseCase,
        stringProvider: AppStringProvider,
    ): ViewModelProvider.Factory =
        MoodEntriesViewModelFactory(
            loadAuthorizeUserIdUseCase = loadAuthorizeUserIdUseCase,
            loadMoodEntriesByUserIdUseCase = loadMoodEntriesByUserIdUseCase,
            stringProvider = stringProvider,
        )
}