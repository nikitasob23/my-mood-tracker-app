package com.niksob.di.module.view.mood_entry_day.loader.logger.with_param

import android.content.Context
import com.niksob.app.R
import com.niksob.app.view.base.loader.logger.with_param.LoggableViewDataLoader
import com.niksob.app.view.base.loader.progressbar.with_param.ViewDataLoaderWithProgressbar
import com.niksob.data.model.UIMoodEntries
import com.niksob.di.module.app.ContextModule
import com.niksob.di.module.logger.AppDebugLoggerModule
import com.niksob.di.module.view.mood_entry_day.loader.progressbar.MoodEntryDayViewDataLoaderWithProgressbarModule
import com.niksob.domain.utils.logger.AppDebugLogger
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(
    includes = [
        MoodEntryDayViewDataLoaderWithProgressbarModule::class,
        AppDebugLoggerModule::class,
        ContextModule::class,
    ]
)
class LoggableMoodEntryDayViewDataLoaderModule {
    @Provides
    fun provideViewDataLoader(
        loader: ViewDataLoaderWithProgressbar<Any, UIMoodEntries>,
        logger: AppDebugLogger,
        @Named("started_load_mood_entries_logger_message") startLoadMessage: String,
        @Named("succeed_load_mood_entries_logger_message") successLoadMessage: String,
        @Named("failure_load_mood_entries_logger_message") cancelledLoadMessage: String,
    ) =
        LoggableViewDataLoader(
            loader = loader,
            logger = logger,
            startLoadMessage = startLoadMessage,
            successLoadMessage = successLoadMessage,
            cancelledLoadMessage = cancelledLoadMessage,
        )

    @Provides
    @Named("started_load_mood_entries_logger_message")
    fun provideStartLoadMessage(context: Context) = context.getString(R.string.started_load_mood_entries)

    @Provides
    @Named("succeed_load_mood_entries_logger_message")
    fun provideSuccessLoadMessage(context: Context) = context.getString(R.string.succeed_load_mood_entries)

    @Provides
    @Named("failure_load_mood_entries_logger_message")
    fun provideCancelledLoadMessage(context: Context) = context.getString(R.string.failure_load_mood_entries)
}