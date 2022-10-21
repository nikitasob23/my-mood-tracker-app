package com.niksob.di.component.view.mood_entry.navigation

import com.niksob.di.module.view.mood_entry.navigation.NavigatableMoodEntryAdditionViewModule
import com.niksob.domain.model.NavigationableScreenClass
import dagger.Component

@Component(modules = [NavigatableMoodEntryAdditionViewModule::class])
interface NavigatableMoodEntryAdditionViewComponent {
    fun getNavigatableScreenClass(): NavigationableScreenClass
}