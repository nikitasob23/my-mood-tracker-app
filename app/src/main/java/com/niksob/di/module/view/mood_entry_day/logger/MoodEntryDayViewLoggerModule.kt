package com.niksob.di.module.view.mood_entry_day.logger

import android.content.Context
import com.niksob.app.R
import com.niksob.app.view.base.loader.observation.logger.ViewLogger
import com.niksob.app.view.base.loader.observation.logger.ViewLoggerImpl
import com.niksob.di.module.app.ContextModule
import com.niksob.di.module.logger.AppDebugLoggerModule
import com.niksob.domain.model.MoodEntries
import com.niksob.domain.utils.logger.AppDebugLogger
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(
    includes = [
        AppDebugLoggerModule::class,
        ContextModule::class,
    ]
)
class MoodEntryDayViewLoggerModule {

    @Provides
    fun provideViewLogger(
        logger: AppDebugLogger,
        @Named("start_load_logger_message") startLoadMessage: String,
        @Named("success_load_logger_message") successLoadMessage: String,
        @Named("cancelled_load_logger_message") cancelledLoadMessage: String,
    ): ViewLogger<MoodEntries> = ViewLoggerImpl(
        logger = logger,
        startLoadMessage = startLoadMessage,
        successLoadMessage = successLoadMessage,
        cancelledLoadMessage = cancelledLoadMessage,
    )

    @Provides
    @Named("start_load_logger_message")
    fun provideStartLoadMessage(context: Context) = context.getString(R.string.started_load_mood_entries)

    @Provides
    @Named("success_load_logger_message")
    fun provideSuccessLoadMessage(context: Context) = context.getString(R.string.succeed_load_mood_entries)

    @Provides
    @Named("cancelled_load_logger_message")
    fun provideCancelledLoadMessage(context: Context) = context.getString(R.string.failure_load_mood_entries)
}