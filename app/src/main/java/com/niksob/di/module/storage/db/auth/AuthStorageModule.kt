package com.niksob.di.module.storage.db.auth

import com.niksob.data.base.OnCompletedAction
import com.niksob.data.provider.AuthProvider
import com.niksob.data.storage.base.auth.auth_registrar.AuthRegistrar
import com.niksob.data.storage.base.auth.auth_user_id_loader.AuthorizedUserIdLoader
import com.niksob.data.storage.base.auth.authorizer.Authorizer
import com.niksob.data.storage.base.auth.observable.AuthStorage
import com.niksob.data.storage.base.auth.signout.SignOutMaker
import com.niksob.data.storage.firebase.auth.auth_user_id_loader.FirebaseAuthorizedUserIdLoader
import com.niksob.data.storage.firebase.auth.authorizer.FirebaseAuthorizer
import com.niksob.data.storage.firebase.auth.observable.AuthStorageImpl
import com.niksob.data.storage.firebase.auth.registrar.FirebaseAuthRegistrar
import com.niksob.data.storage.firebase.auth.signout.FirebaseSignOutMaker
import com.niksob.data.storage.firebase.base.loader.FirebaseAuthorizedUserLoader
import com.niksob.di.module.storage.auth.AuthProviderModule
import com.niksob.di.module.storage.db.auth.on_completed_action.AuthOnCompletedActionModule
import com.niksob.di.module.storage.db.auth.loader.FirebaseAuthorizedUserLoaderModule
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        AuthProviderModule::class,
        AuthOnCompletedActionModule::class,
        FirebaseAuthorizedUserLoaderModule::class,
    ]
)
class AuthStorageModule {
    @Provides
    fun provideFirebaseAuthRegistrar(
        authProvider: AuthProvider,
        onCompletedAction: OnCompletedAction,
    ): AuthRegistrar =
        FirebaseAuthRegistrar(
            authProvider = authProvider,
            authOnCompletedAction = onCompletedAction,
        )

    @Provides
    fun provideFirebaseAuthorizedUserIdLoader(
        authProvider: AuthProvider,
        onCompletedAction: OnCompletedAction,
    ): AuthorizedUserIdLoader =
        FirebaseAuthorizedUserIdLoader(authProvider, onCompletedAction)

    @Provides
    fun provideFirebaseSignOut(
        authProvider: AuthProvider,
        onCompletedAction: OnCompletedAction,
    ): SignOutMaker =
        FirebaseSignOutMaker(authProvider, onCompletedAction)

    @Provides
    fun provideFirebaseAuthorizer(
        authProvider: AuthProvider,
        onCompletedAction: OnCompletedAction,
    ): Authorizer =
        FirebaseAuthorizer(authProvider, onCompletedAction)

    @Provides
    fun provideObservableAuthStorage(loader: FirebaseAuthorizedUserLoader): AuthStorage =
        AuthStorageImpl(loader)
}