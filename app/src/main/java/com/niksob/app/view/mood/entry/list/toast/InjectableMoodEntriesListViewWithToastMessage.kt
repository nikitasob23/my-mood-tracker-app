package com.niksob.app.view.mood.entry.list.toast

import com.niksob.di.component.view.moodentry.MoodEntriesListViewComponent

open class InjectableMoodEntriesListViewWithToastMessage : MoodEntriesListViewWithToastMessage() {

    override val injectableComponent: MoodEntriesListViewComponent get() = injectableComponentBuilder.build()

    override fun inject() = injectableComponent.inject(this)
}