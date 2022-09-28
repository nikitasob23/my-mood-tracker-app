package com.niksob.app.view.moodentrieslist.toast

import com.niksob.di.component.view.moodentry.MoodEntriesListViewComponent

open class InjectableMoodEntriesListViewWithEntriesLoaderWithToastMessage : MoodEntriesListViewWithToastMessageWithEntriesLoader() {

    override val injectableComponent: MoodEntriesListViewComponent get() = injectableComponentBuilder.build()

    override fun inject() = injectableComponent.inject(this)
}