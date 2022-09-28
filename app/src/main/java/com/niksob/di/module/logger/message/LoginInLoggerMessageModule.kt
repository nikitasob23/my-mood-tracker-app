package com.niksob.di.module.logger.message

import android.content.Context
import com.niksob.app.view.auth.loginin.logger.message.LoginInLoggerMessage
import com.niksob.app.view.auth.loginin.logger.message.LoginInLoggerMessageImpl
import com.niksob.di.module.app.ContextModule
import dagger.Module
import dagger.Provides

@Module(includes = [ContextModule::class])
class LoginInLoggerMessageModule {
    @Provides
    fun provideLoginInLoggerMessage(context: Context): LoginInLoggerMessage = LoginInLoggerMessageImpl(context)
}