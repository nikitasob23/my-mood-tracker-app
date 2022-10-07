package com.niksob.di.module.storage.db.auth.on_completed_action

import com.niksob.data.base.OnCompletedAction
import com.niksob.data.storage.firebase.auth.authorizer.data_loaded_action.AuthOnCompletedAction
import com.niksob.data.storage.firebase.auth.authorizer.reason.AuthorizerResponseReasonProvider
import com.niksob.di.module.storage.db.auth.reason.StorageReasonModule
import dagger.Module
import dagger.Provides

@Module(includes = [StorageReasonModule::class])
class AuthOnCompletedActionModule {
    @Provides
    fun provideAuthorizerOnCompletedAction(reasonProvider: AuthorizerResponseReasonProvider): OnCompletedAction =
        AuthOnCompletedAction(reasonProvider)
}