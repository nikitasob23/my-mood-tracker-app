package com.niksob.di.component.view.mood_entry_addition.factory

import com.niksob.di.module.view.moodentry.factory.MoodEntryAdditionViewFactoryModule
import com.niksob.domain.navigation.ScreenFactory
import dagger.Component

@Component(modules = [MoodEntryAdditionViewFactoryModule::class])
interface MoodEntryAdditionViewFactoryComponent {
    fun getNavigatableScreenFactory(): ScreenFactory
}