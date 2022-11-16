package com.niksob.di.module.view.mood_entry_day.toast_message

import android.content.Context
import com.niksob.app.R
import com.niksob.app.toast.ToastMessage
import com.niksob.app.view.mood_entry_day.common.toast_message.ViewToastMessage
import com.niksob.app.view.mood_entry_day.common.toast_message.ViewToastMessageImpl
import com.niksob.di.module.app.ContextModule
import com.niksob.di.module.toast.ShortToastMessageModule
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(
    includes = [
        ShortToastMessageModule::class,
        ContextModule::class,
    ]
)
class MoodEntryViewToastMessageModule {
    @Provides
    fun provideViewToastMessage(
        toastMessage: ToastMessage,
        @Named("success_load_toast_message") successLoadMessage: String,
        @Named("cancelled_load_toast_message") cancelledLoadMessage: String,
    ): ViewToastMessage = ViewToastMessageImpl(
        toastMessage = toastMessage,
        successLoadMessage = successLoadMessage,
        cancelledLoadMessage = cancelledLoadMessage,
    )

    @Provides
    @Named("success_load_toast_message")
    fun provideSuccessLoadMessage(context: Context) = context.getString(R.string.succeed_load_mood_entries)

    @Provides
    @Named("cancelled_load_toast_message")
    fun provideCancelledLoadMessage(context: Context) = context.getString(R.string.failure_load_mood_entries)
}