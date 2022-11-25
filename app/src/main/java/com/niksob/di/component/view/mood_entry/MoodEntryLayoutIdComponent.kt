package com.niksob.di.component.view.mood_entry

import com.niksob.di.component.base.LayoutIdComponent
import com.niksob.di.module.view.mood_entry.ui_component.MoodEntryLayoutIdModule
import dagger.Component

@Component(modules = [MoodEntryLayoutIdModule::class])
interface MoodEntryLayoutIdComponent : LayoutIdComponent