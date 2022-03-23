package com.niksob.di.module

import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.niksob.data.db.DbAuthStorage
import com.niksob.data.db.firebase.DbAuthFirebase
import com.niksob.data.repository.AuthRepositoryImpl
import com.niksob.domain.data.repository.AuthRepository
import com.niksob.domain.usecase.loginin.LoginInUseCase
import com.niksob.domain.usecase.loginin.ValidateEmailUseCase
import com.niksob.domain.usecase.loginin.ValidatePasswordUseCase
import com.niksob.presentation.viewmodel.factory.LoginInViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class LoginInViewModule {

    @Provides
    fun provideLoginInViewModelFactory(
        loginInUseCase: LoginInUseCase,
        validateEmailUseCase: ValidateEmailUseCase,
        validatePasswordUseCase: ValidatePasswordUseCase,
    ): ViewModelProvider.Factory =
        LoginInViewModelFactory(loginInUseCase, validateEmailUseCase, validatePasswordUseCase)

    @Provides
    fun provideLoginInUseCase(repo: AuthRepository) = LoginInUseCase(repo)

    @Provides
    fun provideAuthRepository(storage: DbAuthStorage): AuthRepository = AuthRepositoryImpl(storage)

    @Provides
    fun provideDbAuthStorage(auth: FirebaseAuth): DbAuthStorage = DbAuthFirebase(auth)

    @Provides
    fun provideValidateEmailUseCase() = ValidateEmailUseCase()

    @Provides
    fun provideValidatePasswordUseCase() = ValidatePasswordUseCase()
}