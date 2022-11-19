package com.niksob.di.component.view.mood_entry_day

import com.niksob.app.view.mood_entry_day.base.MoodEntryDayUIView
import com.niksob.di.component.base.InjectableComponent
import com.niksob.di.module.view.mood_entry_day.loader.toast_message.MoodEntryDayViewDataLoaderWithToastMessageModule
import com.niksob.di.module.view.mood_entry_day.ui_component.mood_entries_recycle_view.MoodEntriesRecycleViewModule
import dagger.Component

@Component(
    modules = [
        MoodEntryDayViewDataLoaderWithToastMessageModule::class,
        MoodEntriesRecycleViewModule::class,
    ]
)
interface MoodEntryDayUIViewComponent : InjectableComponent {
    fun inject(view: MoodEntryDayUIView)
}