package com.niksob.di.module.toast

import android.content.Context
import com.niksob.app.toast.ShortToastMessage
import com.niksob.app.toast.ToastMessage
import com.niksob.di.module.app.ContextModule
import dagger.Module
import dagger.Provides

@Module(includes = [ContextModule::class])
class ShortToastMessageModule {
    @Provides
    fun provideShortToastMessage(context: Context): ToastMessage = ShortToastMessage(context)
}