package com.niksob.di.module.viewmodel.moodentry

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.app.R
import com.niksob.app.viewmodel.moodentry.base.BaseMoodEntriesListViewModel
import com.niksob.app.viewmodel.moodentry.base.MoodEntriesListViewModel
import com.niksob.di.module.app.AppMainActivityViewModelStoreOwnerModule
import com.niksob.di.module.app.ContextModule
import com.niksob.di.module.viewmodel.moodentry.factory.MoodEntriesListViewModelFactoryModule
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [
    ContextModule::class,
    MoodEntriesListViewModelFactoryModule::class,
    AppMainActivityViewModelStoreOwnerModule::class,
])
class MoodEntriesListViewModule {
    @Provides
    @Named("mood_entries_view_model")
    fun provideViewModel(
        viewModelFactory: ViewModelProvider.Factory,
        viewModelClass: Class<BaseMoodEntriesListViewModel>,
        viewModelStoreOwner: ViewModelStoreOwner,
    ): MoodEntriesListViewModel = ViewModelProvider(viewModelStoreOwner, viewModelFactory)[viewModelClass]

    @Provides
    fun provideViewModelClass() = BaseMoodEntriesListViewModel::class.java

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