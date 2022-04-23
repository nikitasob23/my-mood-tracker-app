package com.niksob.di.module.view.login

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.data.storage.string.AppStringProvider
import com.niksob.di.module.storage.StringStorageModule
import com.niksob.di.module.usecase.AddUserUseCaseModule
import com.niksob.di.module.usecase.login.LoginValidationModule
import com.niksob.di.module.usecase.login.SignUpWithEmailAndPasswordUseCaseModule
import com.niksob.domain.usecase.db.AddUserUseCase
import com.niksob.domain.usecase.login.SignUpWithEmailAndPasswordUseCase
import com.niksob.domain.usecase.login.ValidateEmailUseCase
import com.niksob.domain.usecase.login.ValidatePasswordUseCase
import com.niksob.presentation.view.SignOutTestView
import com.niksob.presentation.viewmodel.SignUpViewModel
import com.niksob.presentation.viewmodel.factory.SignUpViewModelFactory
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        SignUpWithEmailAndPasswordUseCaseModule::class,
        AddUserUseCaseModule::class,
        LoginValidationModule::class,
        StringStorageModule::class,
    ]
)
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
        signUpUseCase: SignUpWithEmailAndPasswordUseCase,
        addUserUseCase: AddUserUseCase,
        validateEmailUseCase: ValidateEmailUseCase,
        validatePasswordUseCase: ValidatePasswordUseCase,
        stringProvider: AppStringProvider,
    ): ViewModelProvider.Factory =
        SignUpViewModelFactory(
            signUpUseCase,
            addUserUseCase,
            validateEmailUseCase,
            validatePasswordUseCase,
            stringProvider
        )

    @Provides
    fun provideSignOutTestViewClass() = SignOutTestView::class.java
}
