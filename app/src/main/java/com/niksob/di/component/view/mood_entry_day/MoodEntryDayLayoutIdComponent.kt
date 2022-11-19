package com.niksob.di.component.view.mood_entry_day

import com.niksob.di.component.base.LayoutIdComponent
import com.niksob.di.module.view.mood_entry_day.ui_component.MoodEntryDayLayoutIdModule
import dagger.Component

@Component(modules = [MoodEntryDayLayoutIdModule::class])
interface MoodEntryDayLayoutIdComponent : LayoutIdComponent