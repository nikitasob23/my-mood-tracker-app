package com.niksob.di.module.view.mood_entry.loader.progressbar.logger

import android.content.Context
import com.niksob.app.R
import com.niksob.app.view.base.loader.logger.with_param.LoggableViewDataLoader
import com.niksob.app.view.base.loader.progressbar.with_param.ViewDataLoaderWithProgressbar
import com.niksob.data.model.UIMoodEntry
import com.niksob.di.module.logger.AppDebugLoggerModule
import com.niksob.di.module.view.mood_entry.loader.progressbar.MoodEntryByIdLoaderWithProgressbarModule
import com.niksob.domain.model.MoodEntryId
import com.niksob.domain.utils.logger.AppDebugLogger
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(
    includes = [
        MoodEntryByIdLoaderWithProgressbarModule::class,
        AppDebugLoggerModule::class,
    ]
)
class LoggableMoodEntryByIdLoaderModule {
    @Provides
    fun provideLoggableMoodEntryByIdLoader(
        loader: ViewDataLoaderWithProgressbar<MoodEntryId, UIMoodEntry>,
        logger: AppDebugLogger,
        @Named("started_load_mood_entries_logger_message") startLoadMessage: String,
        @Named("succeed_load_mood_entries_logger_message") successLoadMessage: String,
        @Named("failure_load_mood_entries_logger_message") cancelledLoadMessage: String,
    ) = LoggableViewDataLoader(
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