package com.niksob.di.module.view.login

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.app.view.moodentry.MoodEntriesView
import com.niksob.data.provider.AppStringProvider
import com.niksob.di.module.storage.string.StringStorageModule
import com.niksob.di.module.usecase.AddUserUseCaseModule
import com.niksob.di.module.usecase.auth.LoginValidationModule
import com.niksob.di.module.usecase.auth.SignUpWithEmailAndPasswordUseCaseModule
import com.niksob.domain.usecase.db.AddUserUseCase
import com.niksob.domain.usecase.auth.SignUpWithEmailAndPasswordUseCase
import com.niksob.domain.usecase.auth.ValidateEmailUseCase
import com.niksob.domain.usecase.auth.ValidatePasswordUseCase
import com.niksob.app.viewmodel.auth.SignUpViewModel
import com.niksob.app.viewmodel.auth.factory.SignUpViewModelFactory
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
    fun provideMoodEntriesViewClass() = MoodEntriesView::class.java
}
