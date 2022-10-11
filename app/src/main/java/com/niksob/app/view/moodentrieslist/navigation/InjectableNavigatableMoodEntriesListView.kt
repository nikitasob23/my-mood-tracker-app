package com.niksob.app.view.moodentrieslist.navigation

import com.niksob.di.component.view.mood_entry_addition.factory.DaggerMoodEntryAdditionViewFactoryComponent
import com.niksob.di.component.view.mood_entry_addition.factory.MoodEntryAdditionViewFactoryComponent
import com.niksob.di.module.view.moodentry.factory.MoodEntryAdditionViewFactoryModule
import com.niksob.domain.model.MoodEntry

open class InjectableNavigatableMoodEntriesListView : NavigatableMoodEntriesListView() {

    protected open val moodEntryAdditionViewFactoryComponentBuilder: DaggerMoodEntryAdditionViewFactoryComponent.Builder
        get() = DaggerMoodEntryAdditionViewFactoryComponent.builder()
            .moodEntryAdditionViewFactoryModule(moodEntryAdditionViewFactoryModule)

    protected open val moodEntryAdditionViewFactoryComponent: MoodEntryAdditionViewFactoryComponent
        get() = moodEntryAdditionViewFactoryComponentBuilder.build()

    private val moodEntryAdditionViewFactoryModule get() = MoodEntryAdditionViewFactoryModule(moodEntry)

    protected lateinit var moodEntry: MoodEntry

    override fun moveMoodEntryAdditionScreen(moodEntry: MoodEntry) {
        this.moodEntry = moodEntry
        moodEntryAdditionViewFactory = moodEntryAdditionViewFactoryComponent.getNavigatableScreenFactory()
        super.moveMoodEntryAdditionScreen(moodEntry)
    }
}