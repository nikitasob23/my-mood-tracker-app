package com.niksob.di.module.view.main

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.di.module.usecase.auth.LoadAuthorizeUserIdUseCaseModule
import com.niksob.domain.usecase.auth.LoadAuthorizeUserIdUseCase
import com.niksob.app.view.auth.login.DeprecatedLoginView
import com.niksob.app.view.mood.entry.MoodEntriesView
import com.niksob.app.viewmodel.main.MainActivityViewModel
import com.niksob.app.viewmodel.main.factory.MainViewModelFactory
import com.niksob.di.module.app.MainActivityViewModelStoreOwnerModule
import com.niksob.di.module.usecase.auth.SignOutUseCaseModule
import com.niksob.domain.usecase.auth.SignOutUseCase
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        LoadAuthorizeUserIdUseCaseModule::class,
        SignOutUseCaseModule::class,
        MainActivityViewModelStoreOwnerModule::class,
    ]
)
open class MainActivityViewModelModule {

    @Provides
    fun provideViewModel(
        viewModelFactory: ViewModelProvider.Factory,
        viewModelClass: Class<MainActivityViewModel>,
        viewModelStoreOwner: ViewModelStoreOwner,
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
    fun provideLoginViewClass() = DeprecatedLoginView::class.java

    @Provides
    fun provideMoodEntriesViewClass() = MoodEntriesView::class.java
}