package com.niksob.app.view.mood_entry_day.injection

import com.niksob.app.view.base.injection.Injectable
import com.niksob.app.view.mood_entry_day.base.MoodEntryDayUIView
import com.niksob.di.component.view.mood_entry_day.MoodEntryDayUIViewComponent
import com.niksob.di.component.view.mood_entry_day.DaggerMoodEntryDayUIViewComponent
import com.niksob.di.module.app.ContextModule
import com.niksob.di.module.view.mood_entry_day.ui_component.MoodEntryDayUIComponentModule

open class InjectedMoodEntryDayUIView : Injectable, MoodEntryDayUIView() {

    override val injectableComponent: MoodEntryDayUIViewComponent get() = injectionComponentBuilder.build()

    protected open val injectionComponentBuilder: DaggerMoodEntryDayUIViewComponent.Builder
        get() = DaggerMoodEntryDayUIViewComponent.builder()
            .contextModule(contextModule)
            .moodEntryDayUIComponentModule(moodEntryDayUIComponentModule)

    private val contextModule get() = ContextModule(context = requireContext().applicationContext)

    private val moodEntryDayUIComponentModule get() = MoodEntryDayUIComponentModule(view = rootView)

    override fun inject() = injectableComponent.inject(this)
}