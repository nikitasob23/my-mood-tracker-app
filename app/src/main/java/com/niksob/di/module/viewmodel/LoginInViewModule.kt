package com.niksob.di.module.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.google.firebase.auth.FirebaseAuth
import com.niksob.data.repository.AuthRepositoryImpl
import com.niksob.data.storage.db.DbAuthStorage
import com.niksob.data.storage.db.firebase.DbAuthFirebase
import com.niksob.data.StringProvider
import com.niksob.data.storage.string.StringStorage
import com.niksob.domain.data.repository.AuthRepository
import com.niksob.domain.usecase.login.LoginInWithEmailAndPasswordUseCase
import com.niksob.domain.usecase.login.ValidateEmailUseCase
import com.niksob.domain.usecase.login.ValidatePasswordUseCase
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
        loginInUseCase: LoginInWithEmailAndPasswordUseCase,
        validateEmailUseCase: ValidateEmailUseCase,
        validatePasswordUseCase: ValidatePasswordUseCase,
        stringProvider: StringProvider,
    ): ViewModelProvider.Factory =
        LoginInViewModelFactory(loginInUseCase, validateEmailUseCase, validatePasswordUseCase, stringProvider)

    @Provides
    fun provideLoginInUseCase(repo: AuthRepository) = LoginInWithEmailAndPasswordUseCase(repo)

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