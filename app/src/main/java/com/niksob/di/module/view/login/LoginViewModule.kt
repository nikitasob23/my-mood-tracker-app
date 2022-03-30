package com.niksob.di.module.view.login

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.di.module.repository.AuthRepositoryModule
import com.niksob.domain.data.repository.AuthRepository
import com.niksob.domain.usecase.login.LoadAuthorizeUserIdUseCase
import com.niksob.presentation.viewmodel.LoginViewModel
import com.niksob.presentation.viewmodel.factory.LoginViewModelFactory
import dagger.Module
import dagger.Provides

@Module(includes = [AuthRepositoryModule::class])
class LoginViewModule(
    private val viewModelStoreOwner: ViewModelStoreOwner,
) {
    @Provides
    fun provideLoginInViewModel(
        viewModelFactory: ViewModelProvider.Factory,
        viewModelClass: Class<LoginViewModel>
    ) =
        ViewModelProvider(viewModelStoreOwner, viewModelFactory)[viewModelClass]

    @Provides
    fun provideViewModelClass() = LoginViewModel::class.java

    @Provides
    fun provideLoginInViewModelFactory(
        loadAuthorizeUserIdUseCase: LoadAuthorizeUserIdUseCase,
    ): ViewModelProvider.Factory =
        LoginViewModelFactory(loadAuthorizeUserIdUseCase)

    @Provides
    fun provideLoadAuthorizeUserIdUseCase(repo: AuthRepository) = LoadAuthorizeUserIdUseCase(repo)
}