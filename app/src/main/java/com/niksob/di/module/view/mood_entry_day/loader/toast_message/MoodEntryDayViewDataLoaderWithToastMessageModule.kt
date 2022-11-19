package com.niksob.di.module.view.mood_entry_day.loader.toast_message

import android.content.Context
import com.niksob.app.R
import com.niksob.app.toast.ToastMessage
import com.niksob.app.view.base.loader.base.ViewDataLoader
import com.niksob.app.view.base.loader.logger.LoggableViewDataLoader
import com.niksob.app.view.base.loader.toast_message.ViewDataLoaderWithToastMessage
import com.niksob.di.module.app.ContextModule
import com.niksob.di.module.toast.ShortToastMessageModule
import com.niksob.di.module.view.mood_entry_day.loader.logger.LoggableMoodEntryDayViewDataLoaderModule
import com.niksob.domain.model.MoodEntries
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(
    includes = [
        LoggableMoodEntryDayViewDataLoaderModule::class,
        ShortToastMessageModule::class,
        ContextModule::class,
    ]
)
class MoodEntryDayViewDataLoaderWithToastMessageModule {
    @Provides
    fun provideViewDataLoader(
        loader: LoggableViewDataLoader<MoodEntries>,
        toastMessage: ToastMessage,
        @Named("succeed_load_mood_entries_toast_message") successLoadMessage: String,
        @Named("failure_load_mood_entries_toast_message") cancelledLoadMessage: String,
    ): ViewDataLoader<MoodEntries> =
        ViewDataLoaderWithToastMessage(
            loader = loader,
            toastMessage = toastMessage,
            successLoadMessage = successLoadMessage,
            cancelledLoadMessage = cancelledLoadMessage,
        )

    @Provides
    @Named("succeed_load_mood_entries_toast_message")
    fun provideSuccessLoadMessage(context: Context) = context.getString(R.string.succeed_load_mood_entries)

    @Provides
    @Named("failure_load_mood_entries_toast_message")
    fun provideCancelledLoadMessage(context: Context) = context.getString(R.string.failure_load_mood_entries)
}