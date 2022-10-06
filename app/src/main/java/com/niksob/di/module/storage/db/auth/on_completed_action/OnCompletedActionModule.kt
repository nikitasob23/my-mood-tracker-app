package com.niksob.di.module.storage.db.auth.on_completed_action

import com.niksob.data.storage.firebase.auth.auth_user_id_loader.data_loaded_action.AuthUserIdOnCompletedAction
import com.niksob.data.storage.firebase.auth.auth_user_id_loader.reason.AuthUserIdReasonResponseProvider
import com.niksob.data.storage.firebase.auth.authorizer.data_loaded_action.AuthorizerOnCompletedAction
import com.niksob.data.storage.firebase.auth.authorizer.reason.AuthorizerResponseReasonProvider
import com.niksob.data.storage.firebase.auth.registrar.data_loaded_action.RegistrarOnCompletedAction
import com.niksob.data.storage.firebase.auth.registrar.reason.RegistrarReasonResponseProvider
import com.niksob.data.storage.firebase.auth.signout.data_loaded_action.SignOutOnCompletedAction
import com.niksob.data.storage.firebase.auth.signout.response.SignOutResponseReasonProvider
import com.niksob.di.module.storage.db.auth.reason.StorageReasonModule
import dagger.Module
import dagger.Provides

@Module(includes = [StorageReasonModule::class])
class OnCompletedActionModule {
    @Provides
    fun provideRegistrarReasonResponseProvider(reasonProvider: RegistrarReasonResponseProvider) =
        RegistrarOnCompletedAction(reasonProvider)

    @Provides
    fun provideAuthUserIdOnCompletedAction(reasonProvider: AuthUserIdReasonResponseProvider) =
        AuthUserIdOnCompletedAction(reasonProvider)

    @Provides
    fun provideSignOutOnCompletedAction(reasonProvider: SignOutResponseReasonProvider) =
        SignOutOnCompletedAction(reasonProvider)

    @Provides
    fun provideAuthorizerOnCompletedAction(reasonProvider: AuthorizerResponseReasonProvider) =
        AuthorizerOnCompletedAction(reasonProvider)
}