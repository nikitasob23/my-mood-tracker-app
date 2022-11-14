package com.niksob.di.module.message

import android.content.Context
import com.niksob.app.R
import com.niksob.di.module.app.ContextModule
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [ContextModule::class])
class MoodEntriesListViewMessageModule {
    @Provides
    @Named("success_load_message")
    fun provideSuccessLoadMessageId(context: Context) = context.getString(R.string.succeed_load_mood_entries)

    @Provides
    @Named("failure_load_message")
    fun provideFailureLoadMessageId(context: Context) = context.getString(R.string.failure_load_mood_entries)

    @Provides
    @Named("start_load_message")
    fun provideStartLoadMessageId(context: Context) = context.getString(R.string.started_load_mood_entries)
}