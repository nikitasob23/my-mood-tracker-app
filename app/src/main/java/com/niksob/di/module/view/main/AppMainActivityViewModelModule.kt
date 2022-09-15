package com.niksob.di.module.view.main

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.di.module.usecase.auth.LoadAuthorizeUserIdUseCaseModule
import com.niksob.domain.usecase.auth.LoadAuthorizeUserIdUseCase
import com.niksob.app.view.auth.login.navigation.InjectedNavigatableLoginView
import com.niksob.app.view.mood.entry.list.InjectedMoodEntriesListView
import com.niksob.app.viewmodel.main.MainActivityViewModel
import com.niksob.app.viewmodel.main.MainActivityViewModelImpl
import com.niksob.app.viewmodel.main.factory.MainSignOutViewModelWithStoreOwnerCleaningFactory
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
class AppMainActivityViewModelModule {

    @Provides
    @Named("main_activity_view_model")
    fun provideViewModel(
        viewModelFactory: ViewModelProvider.Factory,
        viewModelClass: Class<MainActivityViewModelImpl>,
        viewModelStoreOwner: ViewModelStoreOwner,
    ): MainActivityViewModel =
        ViewModelProvider(viewModelStoreOwner, viewModelFactory)[viewModelClass]

    @Provides
    fun provideViewModelClass() = MainActivityViewModelImpl::class.java

    @Provides
    fun provideViewModelFactory(
        loadAuthorizeUserIdUseCase: LoadAuthorizeUserIdUseCase,
        signOutUseCase: SignOutUseCase,
        viewModelStoreOwner: ViewModelStoreOwner,
    ): ViewModelProvider.Factory =
        MainSignOutViewModelWithStoreOwnerCleaningFactory(
            loadAuthorizeUserIdUseCase = loadAuthorizeUserIdUseCase,
            signOutUseCase = signOutUseCase,
            viewModelStoreOwner = viewModelStoreOwner,
        )

    @Provides
    @Named("login_view_class")
    fun provideLoginViewClass(): Class<out NavigationableScreen> =
        InjectedNavigatableLoginView::class.java

    @Provides
    @Named("mood_entries_view_class")
    fun provideMoodEntriesViewClass(): Class<out NavigationableScreen> =
        InjectedMoodEntriesListView::class.java
}