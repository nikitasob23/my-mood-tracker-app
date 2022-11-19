package com.niksob.di.module.view.mood_entry_day.loader

import com.niksob.app.view.base.loader.observation.logger.ViewLogger
import com.niksob.app.view.base.loader.observation.toast_message.ViewToastMessage
import com.niksob.app.view.mood_entry_day.loader.MoodEntryViewLoader
import com.niksob.app.viewmodel.mood_entry.base.observation.MoodEntryDayViewModel
import com.niksob.di.module.progressbar.AppProgressBarFromContextModule
import com.niksob.di.module.view.mood_entry_day.logger.MoodEntryDayViewLoggerModule
import com.niksob.di.module.view.mood_entry_day.toast_message.MoodEntryViewToastMessageModule
import com.niksob.di.module.viewmodel.mood_entry_day.MoodEntryDayViewModelModule
import com.niksob.domain.model.MoodEntries
import com.niksob.domain.navigation.appprogressbar.AppProgressBar
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        MoodEntryDayViewModelModule::class,
        AppProgressBarFromContextModule::class,
        MoodEntryDayViewLoggerModule::class,
        MoodEntryViewToastMessageModule::class,
    ]
)
class MoodEntryViewLoaderModule {
    @Provides
    fun provideMoodEntryViewLoader(
        viewModel: MoodEntryDayViewModel,
        progressbar: AppProgressBar,
        logger: ViewLogger<MoodEntries>,
        toastMessage: ViewToastMessage<MoodEntries>,
    ) = MoodEntryViewLoader(
        viewModel = viewModel,
        progressbar = progressbar,
        logger = logger,
        toastMessage = toastMessage,
    )
}