package com.niksob.di.module.storage.db.auth

import com.niksob.data.provider.AuthProvider
import com.niksob.data.storage.auth.auth_registrar.AuthRegistrar
import com.niksob.data.storage.auth.auth_user_id_loader.AuthorizedUserIdLoader
import com.niksob.data.storage.auth.authorizer.Authorizer
import com.niksob.data.storage.auth.signout.SignOutMaker
import com.niksob.data.storage.firebase.auth.auth_user_id_loader.FirebaseAuthorizedUserIdLoader
import com.niksob.data.storage.firebase.auth.auth_user_id_loader.data_loaded_action.AuthUserIdOnCompletedAction
import com.niksob.data.storage.firebase.auth.authorizer.FirebaseAuthorizer
import com.niksob.data.storage.firebase.auth.authorizer.data_loaded_action.AuthorizerOnCompletedAction
import com.niksob.data.storage.firebase.auth.registrar.FirebaseAuthRegistrar
import com.niksob.data.storage.firebase.auth.registrar.data_loaded_action.RegistrarOnCompletedAction
import com.niksob.data.storage.firebase.auth.signout.FirebaseSignOutMaker
import com.niksob.data.storage.firebase.auth.signout.data_loaded_action.SignOutOnCompletedAction
import com.niksob.di.module.storage.auth.AuthProviderModule
import com.niksob.di.module.storage.db.auth.on_completed_action.OnCompletedActionModule
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        AuthProviderModule::class,
        OnCompletedActionModule::class,
    ]
)
class AuthStorageModule {
    @Provides
    fun provideFirebaseAuthRegistrar(
        authProvider: AuthProvider,
        onCompletedAction: RegistrarOnCompletedAction,
    ): AuthRegistrar =
        FirebaseAuthRegistrar(
            authProvider = authProvider,
            authOnCompletedAction = onCompletedAction,
        )

    @Provides
    fun provideFirebaseAuthorizedUserIdLoader(
        authProvider: AuthProvider,
        onCompletedAction: AuthUserIdOnCompletedAction,
    ): AuthorizedUserIdLoader =
        FirebaseAuthorizedUserIdLoader(authProvider, onCompletedAction)

    @Provides
    fun provideFirebaseSignOut(
        authProvider: AuthProvider,
        onCompletedAction: SignOutOnCompletedAction,
    ): SignOutMaker =
        FirebaseSignOutMaker(authProvider, onCompletedAction)

    @Provides
    fun provideFirebaseAuthorizer(
        authProvider: AuthProvider,
        onCompletedAction: AuthorizerOnCompletedAction,
    ): Authorizer =
        FirebaseAuthorizer(authProvider, onCompletedAction)
}