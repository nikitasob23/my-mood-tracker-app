package com.niksob.di.module.storage.db.auth

import com.niksob.data.provider.AuthProvider
import com.niksob.data.storage.auth.auth_user_id_loader.AuthUserIdLoader
import com.niksob.data.storage.firebase.auth.auth_user_id_loader.AuthUserIdLoaderImpl
import com.niksob.data.storage.firebase.auth.auth_user_id_loader.data_loaded_action.AuthUserIdOnCompletedAction
import com.niksob.data.storage.firebase.auth.auth_user_id_loader.reason.AuthUserIdReasonResponseProvider
import com.niksob.data.storage.provider.AppStringStorage
import com.niksob.di.module.storage.auth.AuthProviderModule
import com.niksob.di.module.storage.string.StringStorageModule
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        AuthProviderModule::class,
        StringStorageModule::class,
    ]
)
class AuthStorageModule {
    @Provides
    fun provideMoodEntryStorage(
        authProvider: AuthProvider,
        onCompletedAction: AuthUserIdOnCompletedAction,
    ): AuthUserIdLoader =
        AuthUserIdLoaderImpl(
            authProvider = authProvider,
            authUserIdOnCompletedAction = onCompletedAction,
        )

    @Provides
    fun provideAuthorizerOnCompletedAction(reasonProvider: AuthUserIdReasonResponseProvider) =
        AuthUserIdOnCompletedAction(reasonProvider)

    @Provides
    fun provideAuthorizerResponseReasonProvider(stringStorage: AppStringStorage) =
        AuthUserIdReasonResponseProvider(stringStorage)
}