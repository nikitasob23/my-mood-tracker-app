package com.niksob.di.component.view.moodentry

import com.niksob.app.view.moodentry.MoodEntriesView
import com.niksob.di.module.view.moodentry.MoodEntriesViewModule
import dagger.Component

@Component(modules = [MoodEntriesViewModule::class])
interface MoodEntriesViewComponent {
    fun inject(view: MoodEntriesView)
}