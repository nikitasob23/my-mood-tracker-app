package com.niksob.di.module.view.mood_entry_day.loader.progressbar

import com.niksob.app.view.base.loader.observation.loader.progressbar.ViewDataLoaderWithProgressbar
import com.niksob.app.view.mood_entry_day.loader.MoodEntryDayViewDataLoader
import com.niksob.di.module.progressbar.AppProgressBarFromContextModule
import com.niksob.di.module.view.mood_entry_day.loader.viewmodel.MoodEntryViewDataLoaderModule
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
        loader: MoodEntryDayViewDataLoader,
        progressbar: AppProgressBar,
    ) =
        ViewDataLoaderWithProgressbar(
            loader = loader,
            progressbar = progressbar,
        )
}