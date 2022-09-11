package com.niksob.di.module.view.main

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.di.module.usecase.auth.LoadAuthorizeUserIdUseCaseModule
import com.niksob.domain.usecase.auth.LoadAuthorizeUserIdUseCase
import com.niksob.app.view.auth.login.InjectedNavigatableLoginView
import com.niksob.app.view.mood.entry.MoodEntriesView
import com.niksob.app.viewmodel.main.MainActivityViewModel
import com.niksob.app.viewmodel.main.factory.MainViewModelFactory
import com.niksob.di.module.app.AppMainActivityViewModelStoreOwnerModule
import com.niksob.di.module.app.ContextModule
import com.niksob.di.module.usecase.auth.SignOutUseCaseModule
import com.niksob.domain.navigation.NavigationableScreen
import com.niksob.domain.usecase.auth.SignOutUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(
    includes = [
        ContextModule::class,
        LoadAuthorizeUserIdUseCaseModule::class,
        SignOutUseCaseModule::class,
        AppMainActivityViewModelStoreOwnerModule::class,
    ]
)
open class AppMainActivityViewModelModule {

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
    @Named("login_view_class")
    fun provideLoginViewClass(): Class<out NavigationableScreen> = InjectedNavigatableLoginView::class.java

    @Provides
    @Named("mood_entries_view_class")
    fun provideMoodEntriesViewClass(): Class<out NavigationableScreen> = MoodEntriesView::class.java
}