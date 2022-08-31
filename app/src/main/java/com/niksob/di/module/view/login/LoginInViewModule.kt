package com.niksob.di.module.view.login

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.data.provider.AppStringProvider
import com.niksob.di.module.storage.string.StringStorageModule
import com.niksob.di.module.usecase.auth.LoginInWithEmailAndPasswordUseCaseModule
import com.niksob.di.module.usecase.auth.LoginValidationModule
import com.niksob.domain.usecase.auth.LoginInWithEmailAndPasswordUseCase
import com.niksob.domain.usecase.auth.ValidateEmailUseCase
import com.niksob.domain.usecase.auth.ValidatePasswordUseCase
import com.niksob.app.view.mood.entry.MoodEntriesView
import com.niksob.app.viewmodel.auth.LoginInViewModel
import com.niksob.app.viewmodel.auth.factory.LoginInViewModelFactory
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        LoginInWithEmailAndPasswordUseCaseModule::class,
        LoginValidationModule::class,
        StringStorageModule::class
    ]
)
class LoginInViewModule(
    private val viewModelStoreOwner: ViewModelStoreOwner,
) {
    @Provides
    fun provideLoginInViewModel(
        viewModelFactory: ViewModelProvider.Factory,
        viewModelClass: Class<LoginInViewModel>
    ) =
        ViewModelProvider(viewModelStoreOwner, viewModelFactory)[viewModelClass]

    @Provides
    fun provideViewModelClass() = LoginInViewModel::class.java

    @Provides
    fun provideLoginInViewModelFactory(
        loginInUseCase: LoginInWithEmailAndPasswordUseCase,
        validateEmailUseCase: ValidateEmailUseCase,
        validatePasswordUseCase: ValidatePasswordUseCase,
        stringProvider: AppStringProvider,
    ): ViewModelProvider.Factory =
        LoginInViewModelFactory(loginInUseCase, validateEmailUseCase, validatePasswordUseCase, stringProvider)

    @Provides
    fun provideMoodEntriesViewClass() = MoodEntriesView::class.java
}