package com.niksob.di.module.view.mood_entry.loader.progressbar

import com.niksob.app.view.base.loader.progressbar.with_param.ViewDataLoaderWithProgressbar
import com.niksob.app.view.mood_entry.loader.MoodEntryByIdLoader
import com.niksob.di.module.progressbar.AppProgressBarFromContextModule
import com.niksob.di.module.view.mood_entry.loader.MoodEntryDataLoaderModule
import com.niksob.domain.navigation.appprogressbar.AppProgressBar
import dagger.Module
import dagger.Provides

@Module(includes = [
    MoodEntryDataLoaderModule::class,
    AppProgressBarFromContextModule::class,
])
class MoodEntryByIdLoaderWithProgressbarModule {
    @Provides
    fun provideMoodEntryByIdLoaderWithProgressbar(
        loader: MoodEntryByIdLoader,
        progressbar: AppProgressBar,
    ) = ViewDataLoaderWithProgressbar(
        loader = loader,
        progressbar = progressbar,
    )
}