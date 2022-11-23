package com.niksob.di.module.view.mood_entry.loader.progressbar.logger.toast_message

import android.content.Context
import com.niksob.app.R
import com.niksob.app.toast.ToastMessage
import com.niksob.app.view.base.loader.base.with_parameter.ViewDataLoader
import com.niksob.app.view.base.loader.logger.with_param.LoggableViewDataLoader
import com.niksob.app.view.base.loader.toast_message.with_param.ViewDataLoaderWithToastMessage
import com.niksob.data.model.UIMoodEntry
import com.niksob.di.module.toast.ShortToastMessageModule
import com.niksob.di.module.view.mood_entry.loader.progressbar.logger.LoggableMoodEntryByIdLoaderModule
import com.niksob.domain.model.MoodEntryId
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(
    includes = [
        LoggableMoodEntryByIdLoaderModule::class,
        ShortToastMessageModule::class,
    ]
)
class MoodEntryByIdLoaderWithToastMessageModule {
    @Provides
    fun provideMoodEntryByIdLoaderWithToastMessage(
        loader: LoggableViewDataLoader<MoodEntryId, UIMoodEntry>,
        toastMessage: ToastMessage,
        @Named("succeed_load_mood_entries_toast_message") successLoadMessage: String,
        @Named("failure_load_mood_entries_toast_message") cancelledLoadMessage: String,
    ): ViewDataLoader<MoodEntryId, UIMoodEntry> =
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