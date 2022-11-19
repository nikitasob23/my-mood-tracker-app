package com.niksob.app.view.mood_entry_day.injection

import com.niksob.app.view.mood_entry_day.base.MoodEntryDayUIView
import com.niksob.di.component.view.mood_entry_day.MoodEntryDayUIViewComponent
import com.niksob.di.component.view.mood_entry_day.DaggerMoodEntryDayUIViewComponent
import com.niksob.di.module.app.ContextModule
import com.niksob.di.module.view.mood_entry_day.ui_component.mood_entries_recycle_view.MoodEntriesRecycleViewUIComponentModule
import com.niksob.di.component.view.mood_entry_day.DaggerMoodEntryDayLayoutIdComponent

open class InjectedMoodEntryDayUIView : MoodEntryDayUIView() {

    override val injectableComponent: MoodEntryDayUIViewComponent get() = injectionComponentBuilder.build()

    protected open val injectionComponentBuilder: DaggerMoodEntryDayUIViewComponent.Builder
        get() = DaggerMoodEntryDayUIViewComponent.builder()
            .contextModule(contextModule)
            .moodEntriesRecycleViewUIComponentModule(moodEntriesRecycleViewUIComponentModule)

    protected open val injectLayoutIdViewComponentBuilder: DaggerMoodEntryDayLayoutIdComponent.Builder
        get() = DaggerMoodEntryDayLayoutIdComponent.builder()

    private val contextModule get() = ContextModule(context = requireContext().applicationContext)

    private val moodEntriesRecycleViewUIComponentModule get() = MoodEntriesRecycleViewUIComponentModule(view = rootView)

    override fun injectLayoutId() {
        injectLayoutIdViewComponent = injectLayoutIdViewComponentBuilder.build()
        super.injectLayoutId()
    }

    override fun inject() = injectableComponent.inject(this)
}