package com.niksob.app.view.mood_entries_list.navigation.injection

import com.niksob.app.view.mood_entries_list.navigation.NavigatableMoodEntriesListView
import com.niksob.di.component.view.mood_entry.navigation.DaggerNavigatableMoodEntryAdditionViewComponent
import com.niksob.di.module.view.mood_entry.factory.MoodEntryAdditionViewFactoryModule
import com.niksob.domain.model.MoodEntry

open class InjectableNavigatableMoodEntriesListView : NavigatableMoodEntriesListView() {

    override fun moveToMoodEntryAdditionScreen(moodEntry: MoodEntry) {
        moodEntriesAdditionClass = moodEntriesAdditionClassComponent(moodEntry)
            .getNavigatableScreenClass()
        super.moveToMoodEntryAdditionScreen(moodEntry)
    }

    private fun moodEntriesAdditionClassComponent(moodEntry: MoodEntry) =
        moodEntriesAdditionClassComponentBuilder(moodEntry).build()

    private fun moodEntriesAdditionClassComponentBuilder(
        moodEntry: MoodEntry,
    ): DaggerNavigatableMoodEntryAdditionViewComponent.Builder {
        val moodEntryAdditionViewFactoryModule = MoodEntryAdditionViewFactoryModule(moodEntry)

        return DaggerNavigatableMoodEntryAdditionViewComponent.builder()
            .moodEntryAdditionViewFactoryModule(moodEntryAdditionViewFactoryModule)
    }
}