package com.niksob.di.module.repository.auth

import com.niksob.data.repository.auth.AuthRepositoryWithAuthorizedUserIdLoaderImpl
import com.niksob.data.repository.auth.AuthRepositoryWithAuthorizerImpl
import com.niksob.data.repository.auth.AuthRepositoryWithRegistrarImpl
import com.niksob.data.repository.auth.AuthRepositoryWithSignOutMakerImpl
import com.niksob.data.repository.auth.observable.AuthRepositoryImpl
import com.niksob.data.storage.base.auth.auth_registrar.AuthRegistrar
import com.niksob.data.storage.base.auth.auth_user_id_loader.AuthorizedUserIdLoader
import com.niksob.data.storage.base.auth.authorizer.Authorizer
import com.niksob.data.storage.base.auth.observable.AuthStorage
import com.niksob.data.storage.base.auth.signout.SignOutMaker
import com.niksob.di.module.storage.db.auth.AuthStorageModule
import com.niksob.domain.data.repository.auth.AuthRepositoryWithAuthorizedUserIdLoader
import com.niksob.domain.data.repository.auth.AuthRepositoryWithAuthorizer
import com.niksob.domain.data.repository.auth.AuthRepositoryWithRegistrar
import com.niksob.domain.data.repository.auth.AuthRepositoryWithSignOutMaker
import com.niksob.domain.data.repository.auth.observable.AuthRepository
import dagger.Module
import dagger.Provides

@Module(includes = [AuthStorageModule::class])
class AuthRepositoryModule {
    @Provides
    fun provideAuthRegistrar(registrar: AuthRegistrar): AuthRepositoryWithRegistrar =
        AuthRepositoryWithRegistrarImpl(registrar)

    @Provides
    fun provideAuthorizedUserIdLoader(loader: AuthorizedUserIdLoader): AuthRepositoryWithAuthorizedUserIdLoader =
        AuthRepositoryWithAuthorizedUserIdLoaderImpl(loader)

    @Provides
    fun provideSignOutMaker(maker: SignOutMaker): AuthRepositoryWithSignOutMaker =
        AuthRepositoryWithSignOutMakerImpl(maker)

    @Provides
    fun provideFirebaseAuthorizer(authorizer: Authorizer): AuthRepositoryWithAuthorizer =
        AuthRepositoryWithAuthorizerImpl(authorizer)

    @Provides
    fun provideObservableAuthRepository(storage: AuthStorage): AuthRepository =
        AuthRepositoryImpl(storage)
}