package com.niksob.di.component.view.mood_entry_addition

import com.niksob.app.view.mood_entry_addition.logger.injection.InjectedLoggableMoodEntryAdditionView
import com.niksob.di.component.base.InjectableComponent
import com.niksob.di.module.logger.AppDebugLoggerModule
import com.niksob.di.module.progressbar.AppProgressBarFromContextModule
import com.niksob.di.module.toast.ShortToastMessageModule
import com.niksob.di.module.view.mood_entry_addition.navigation.NavigatableMoodEntryAdditionViewModule
import com.niksob.di.module.viewmodel.mood_entry.MoodEntriesListViewWithEntriesLoaderObserverModule
import dagger.Component

@Component(
    modules = [
        NavigatableMoodEntryAdditionViewModule::class,
        MoodEntriesListViewWithEntriesLoaderObserverModule::class,
        AppProgressBarFromContextModule::class,
        ShortToastMessageModule::class,
        AppDebugLoggerModule::class,
    ]
)
interface AdditionMoodEntryViewComponent : InjectableComponent {
    fun inject(view: InjectedLoggableMoodEntryAdditionView)
}