package com.niksob.di.component

import com.niksob.app.view.moodentry.MoodEntriesView
import com.niksob.di.module.view.MoodEntriesViewModule
import dagger.Component

@Component(modules = [MoodEntriesViewModule::class])
interface MoodEntriesViewComponent {
    fun inject(view: MoodEntriesView)
}