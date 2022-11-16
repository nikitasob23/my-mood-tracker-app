package com.niksob.di.component.view.mood_entry_day

import com.niksob.app.view.mood_entry_day.base.MoodEntryDayUIView
import com.niksob.di.component.base.InjectableComponent
import com.niksob.di.module.view.mood_entry_day.loader.MoodEntryViewLoaderModule
import com.niksob.di.module.view.mood_entry_day.ui_component.MoodEntryDayUIComponentModule
import dagger.Component

@Component(
    modules = [
        MoodEntryViewLoaderModule::class,
        MoodEntryDayUIComponentModule::class,
    ]
)
interface MoodEntryDayUIViewComponent : InjectableComponent {
    fun inject(view: MoodEntryDayUIView)
}