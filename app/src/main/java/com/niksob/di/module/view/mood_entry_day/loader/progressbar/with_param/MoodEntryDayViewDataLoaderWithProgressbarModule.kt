package com.niksob.di.module.view.mood_entry_day.loader.progressbar.with_param

import com.niksob.app.view.base.loader.progressbar.with_param.ViewDataLoaderWithProgressbar
import com.niksob.app.view.mood_entry_day.loader.ui_mood_entry.MoodEntryByDateIntervalLoader
import com.niksob.di.module.progressbar.AppProgressBarFromContextModule
import com.niksob.di.module.view.mood_entry_day.loader.viewmodel.with_param.MoodEntryViewDataLoaderModule
import com.niksob.domain.navigation.appprogressbar.AppProgressBar
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        MoodEntryViewDataLoaderModule::class,
        AppProgressBarFromContextModule::class,
    ]
)
class MoodEntryDayViewDataLoaderWithProgressbarModule {
    @Provides
    fun provideMoodEntryViewDataLoader(
        loader: MoodEntryByDateIntervalLoader,
        progressbar: AppProgressBar,
    ) =
        ViewDataLoaderWithProgressbar(
            loader = loader,
            progressbar = progressbar,
        )
}