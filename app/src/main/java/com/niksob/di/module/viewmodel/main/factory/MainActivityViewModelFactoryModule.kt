package com.niksob.di.module.viewmodel.main.factory

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.app.viewmodel.main.factory.MainSignOutViewModelWithStoreOwnerCleaningFactory
import com.niksob.di.module.app.AppMainActivityViewModelStoreOwnerModule
import com.niksob.di.module.usecase.auth.LoadAuthorizeUserIdUseCaseModule
import com.niksob.di.module.usecase.auth.SignOutUseCaseModule
import com.niksob.domain.usecase.auth.LoadAuthorizeUserIdUseCase
import com.niksob.domain.usecase.auth.SignOutUseCase
import dagger.Module
import dagger.Provides

@Module(includes = [
    LoadAuthorizeUserIdUseCaseModule::class,
    SignOutUseCaseModule::class,
    AppMainActivityViewModelStoreOwnerModule::class,
])
class MainActivityViewModelFactoryModule {
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
}