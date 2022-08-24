package com.niksob.di.module.logger

import com.niksob.domain.utils.logger.AppDebugLogger
import com.niksob.utils.logger.AndroidDebugLogger
import dagger.Module
import dagger.Provides

@Module
class AppDebugLoggerModule {
    @Provides
    fun provideLogger() : AppDebugLogger = AndroidDebugLogger()
}