package com.niksob.di.component.view.mood_entry

import com.niksob.app.view.mood_entry.injection.InjectedMoodEntryUIView
import com.niksob.di.component.base.InjectableComponent
import com.niksob.di.module.view.mood_entry.loader.progressbar.logger.toast_message.MoodEntryByIdLoaderWithToastMessageModule
import com.niksob.di.module.view.mood_entry.ui_component.MoodEntryPanelViewModule
import dagger.Component

@Component(
    modules = [
        MoodEntryPanelViewModule::class,
        MoodEntryByIdLoaderWithToastMessageModule::class,
    ]
)
interface MoodEntryUIViewComponent : InjectableComponent {
    fun inject(view: InjectedMoodEntryUIView)
}