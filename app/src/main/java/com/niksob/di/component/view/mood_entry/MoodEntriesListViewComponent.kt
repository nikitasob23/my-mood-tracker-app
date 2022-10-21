package com.niksob.di.component.view.mood_entry

import com.niksob.app.view.base.viewmodel.mood_entry.injection.InjectedMoodEntriesLoaderView
import com.niksob.di.component.base.InjectableComponent
import com.niksob.di.module.logger.AppDebugLoggerModule
import com.niksob.di.module.navigation.ScreenNavigationModule
import com.niksob.di.module.progressbar.AppProgressBarFromContextModule
import com.niksob.di.module.toast.ShortToastMessageModule
import com.niksob.di.module.viewmodel.moodentry.MoodEntriesListViewWithEntriesLoaderObserverModule
import dagger.Component

@Component(
    modules = [
        MoodEntriesListViewWithEntriesLoaderObserverModule::class,
        ScreenNavigationModule::class,
        AppProgressBarFromContextModule::class,
        ShortToastMessageModule::class,
        AppDebugLoggerModule::class,
    ]
)
interface MoodEntriesListViewComponent : InjectableComponent {
    fun inject(moodEntriesListView: InjectedMoodEntriesLoaderView)
}