package com.niksob.di.module.view.login

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.data.StringProvider
import com.niksob.domain.data.repository.AuthRepository
import com.niksob.domain.usecase.login.SignUpWithEmailAndPasswordUseCase
import com.niksob.domain.usecase.login.ValidateEmailUseCase
import com.niksob.domain.usecase.login.ValidatePasswordUseCase
import com.niksob.presentation.viewmodel.SignUpViewModel
import com.niksob.presentation.viewmodel.factory.SignUpViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class SignUpViewModule(
    private val viewModelStoreOwner: ViewModelStoreOwner,
) {
    @Provides
    fun provideViewModel(
        viewModelFactory: ViewModelProvider.Factory,
        viewModelClass: Class<SignUpViewModel>
    ) =
        ViewModelProvider(viewModelStoreOwner, viewModelFactory)[viewModelClass]

    @Provides
    fun provideViewModelClass() = SignUpViewModel::class.java

    @Provides
    fun provideViewModelFactory(
        loginUpUseCase: SignUpWithEmailAndPasswordUseCase,
        validateEmailUseCase: ValidateEmailUseCase,
        validatePasswordUseCase: ValidatePasswordUseCase,
        stringProvider: StringProvider,
    ): ViewModelProvider.Factory =
        SignUpViewModelFactory(loginUpUseCase, validateEmailUseCase, validatePasswordUseCase, stringProvider)

    @Provides
    fun provideSignUpUseCase(repo: AuthRepository) = SignUpWithEmailAndPasswordUseCase(repo)
}
