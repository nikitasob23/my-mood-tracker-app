package com.niksob.di.module.view.login

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.data.StringProvider
import com.niksob.di.module.repository.AuthRepositoryModule
import com.niksob.di.module.repository.UserRepositoryModule
import com.niksob.di.module.storage.StringStorageModule
import com.niksob.domain.data.repository.AuthRepository
import com.niksob.domain.data.repository.UserRepository
import com.niksob.domain.usecase.db.AddUserUseCase
import com.niksob.domain.usecase.login.SignUpWithEmailAndPasswordUseCase
import com.niksob.domain.usecase.login.ValidateEmailUseCase
import com.niksob.domain.usecase.login.ValidatePasswordUseCase
import com.niksob.presentation.viewmodel.SignUpViewModel
import com.niksob.presentation.viewmodel.factory.SignUpViewModelFactory
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        AuthRepositoryModule::class,
        UserRepositoryModule::class,
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
        loginUpUseCase: SignUpWithEmailAndPasswordUseCase,
        addUserUseCase: AddUserUseCase,
        validateEmailUseCase: ValidateEmailUseCase,
        validatePasswordUseCase: ValidatePasswordUseCase,
        stringProvider: StringProvider,
    ): ViewModelProvider.Factory =
        SignUpViewModelFactory(
            loginUpUseCase,
            addUserUseCase,
            validateEmailUseCase,
            validatePasswordUseCase,
            stringProvider
        )

    @Provides
    fun provideSignUpUseCase(repo: AuthRepository) = SignUpWithEmailAndPasswordUseCase(repo)

    @Provides
    fun provideAddUserUseCase(repo: UserRepository) = AddUserUseCase(repo)
}
