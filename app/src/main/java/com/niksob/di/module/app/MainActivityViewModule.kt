package com.niksob.di.module.app

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.di.module.usecase.login.LoadAuthorizeUserIdUseCaseModule
import com.niksob.domain.usecase.login.LoadAuthorizeUserIdUseCase
import com.niksob.presentation.view.LoginView
import com.niksob.presentation.view.SignOutTestView
import com.niksob.presentation.viewmodel.MainActivityViewModel
import com.niksob.presentation.viewmodel.factory.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module(includes = [LoadAuthorizeUserIdUseCaseModule::class])
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
        loadAuthorizeUserIdUseCase: LoadAuthorizeUserIdUseCase
    ): ViewModelProvider.Factory =
        MainViewModelFactory(loadAuthorizeUserIdUseCase)

    @Provides
    fun provideLoginViewClass() = LoginView::class.java

    @Provides
    fun provideSignOutTestViewClass() = SignOutTestView::class.java
}