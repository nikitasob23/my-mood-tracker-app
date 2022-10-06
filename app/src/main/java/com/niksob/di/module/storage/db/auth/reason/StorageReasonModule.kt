package com.niksob.di.module.storage.db.auth.reason

import com.niksob.data.storage.firebase.auth.auth_user_id_loader.reason.AuthUserIdReasonResponseProvider
import com.niksob.data.storage.firebase.auth.authorizer.reason.AuthorizerResponseReasonProvider
import com.niksob.data.storage.firebase.auth.registrar.reason.RegistrarReasonResponseProvider
import com.niksob.data.storage.firebase.auth.signout.response.SignOutResponseReasonProvider
import com.niksob.data.storage.provider.AppStringStorage
import com.niksob.di.module.storage.string.StringStorageModule
import dagger.Module
import dagger.Provides

@Module(includes = [StringStorageModule::class])
class StorageReasonModule {
    @Provides
    fun provideRegistrarReasonResponseProvider(stringStorage: AppStringStorage) =
        RegistrarReasonResponseProvider(stringStorage)

    @Provides
    fun provideAuthUserIdReasonResponseProvider(stringStorage: AppStringStorage) =
        AuthUserIdReasonResponseProvider(stringStorage)

    @Provides
    fun provideSignOutResponseReasonProvider(stringStorage: AppStringStorage) =
        SignOutResponseReasonProvider(stringStorage)

    @Provides
    fun provideAuthorizerResponseReasonProvider(stringStorage: AppStringStorage) =
        AuthorizerResponseReasonProvider(stringStorage)
}