package com.niksob.di.module.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.google.firebase.auth.FirebaseAuth
import com.niksob.data.db.DbAuthStorage
import com.niksob.data.db.firebase.DbAuthFirebase
import com.niksob.data.repository.AuthRepositoryImpl
import com.niksob.domain.data.repository.AuthRepository
import com.niksob.domain.usecase.loginin.LoginInUseCase
import com.niksob.domain.usecase.loginin.ValidateEmailUseCase
import com.niksob.domain.usecase.loginin.ValidatePasswordUseCase
import com.niksob.presentation.viewmodel.LoginInViewModel
import com.niksob.presentation.viewmodel.factory.LoginInViewModelFactory
import com.niksob.utils.AndroidStringProvider
import dagger.Module
import dagger.Provides

@Module
class LoginInViewModule(
    private val viewModelStoreOwner: ViewModelStoreOwner,
) {

    @Provides
    fun provideLoginViewModel(
        viewModelFactory: ViewModelProvider.Factory,
        viewModelClass: Class<LoginInViewModel>
    ) =
        ViewModelProvider(viewModelStoreOwner, viewModelFactory)[viewModelClass]

    @Provides
    fun provideViewModelClass() = LoginInViewModel::class.java

    @Provides
    fun provideLoginInViewModelFactory(
        loginInUseCase: LoginInUseCase,
        validateEmailUseCase: ValidateEmailUseCase,
        validatePasswordUseCase: ValidatePasswordUseCase,
        stringProvider: StringProvider,
    ): ViewModelProvider.Factory =
        LoginInViewModelFactory(loginInUseCase, validateEmailUseCase, validatePasswordUseCase)

    @Provides
    fun provideLoginInUseCase(repo: AuthRepository) = LoginInUseCase(repo)

    @Provides
    fun provideAuthRepository(storage: DbAuthStorage): AuthRepository = AuthRepositoryImpl(storage)

    @Provides
    fun provideDbAuthStorage(
        auth: FirebaseAuth,
        stringStorage: StringStorage
    ): DbAuthStorage = DbAuthFirebase(auth, stringStorage)

    @Provides
    fun provideStringStorage(provider: StringProvider) = StringStorage(provider)

    @Provides
    fun provideStringProvider(context: Context): StringProvider = AndroidStringProvider(context)

    @Provides
    fun provideValidateEmailUseCase() = ValidateEmailUseCase()

    @Provides
    fun provideValidatePasswordUseCase() = ValidatePasswordUseCase()
}