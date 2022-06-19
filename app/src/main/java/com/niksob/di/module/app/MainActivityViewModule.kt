package com.niksob.di.module.app

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.di.module.usecase.auth.LoadAuthorizeUserIdUseCaseModule
import com.niksob.domain.usecase.auth.LoadAuthorizeUserIdUseCase
import com.niksob.app.view.LoginView
import com.niksob.app.view.moodentry.MoodEntriesView
import com.niksob.app.viewmodel.MainActivityViewModel
import com.niksob.app.viewmodel.factory.MainViewModelFactory
import com.niksob.di.module.usecase.auth.SignOutUseCaseModule
import com.niksob.domain.usecase.auth.SignOutUseCase
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        LoadAuthorizeUserIdUseCaseModule::class,
        SignOutUseCaseModule::class,
    ]
)
class MainActivityViewModule(
    private val viewModelStoreOwner: ViewModelStoreOwner,
) {
    @Provides
    fun provideViewModel(
        viewModelFactory: ViewModelProvider.Factory,
        viewModelClass: Class<MainActivityViewModel>
    ) =
        ViewModelProvider(viewModelStoreOwner, viewModelFactory)[viewModelClass]

    @Provides
    fun provideViewModelClass() = MainActivityViewModel::class.java

    @Provides
    fun provideViewModelFactory(
        loadAuthorizeUserIdUseCase: LoadAuthorizeUserIdUseCase,
        signOutUseCase: SignOutUseCase,
    ): ViewModelProvider.Factory =
        MainViewModelFactory(loadAuthorizeUserIdUseCase, signOutUseCase)

    @Provides
    fun provideLoginViewClass() = LoginView::class.java

    @Provides
    fun provideMoodEntriesViewClass() = MoodEntriesView::class.java
}