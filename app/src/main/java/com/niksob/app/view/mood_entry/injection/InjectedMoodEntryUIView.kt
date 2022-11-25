package com.niksob.app.view.mood_entry.injection

import com.niksob.app.view.mood_entry.base.MoodEntryUIView
import com.niksob.di.component.view.mood_entry.DaggerMoodEntryLayoutIdComponent
import com.niksob.di.component.view.mood_entry.DaggerMoodEntryUIViewComponent
import com.niksob.di.component.view.mood_entry.MoodEntryUIViewComponent
import com.niksob.di.module.app.ContextModule
import com.niksob.di.module.view.mood_entry.ui_component.MoodEntryPanelViewModule
import com.niksob.domain.model.MoodEntryId

open class InjectedMoodEntryUIView(moodEntryId: MoodEntryId) : MoodEntryUIView(moodEntryId) {

    override val injectableComponent: MoodEntryUIViewComponent get() = injectableComponentBuilder.build()

    protected open val injectableComponentBuilder: DaggerMoodEntryUIViewComponent.Builder
        get() =  DaggerMoodEntryUIViewComponent.builder()
            .contextModule(contextModule)
            .moodEntryPanelViewModule(moodEntryPanelViewModule)

    protected open val injectLayoutIdViewComponentBuilder: DaggerMoodEntryLayoutIdComponent.Builder
        get() = DaggerMoodEntryLayoutIdComponent.builder()

    private val contextModule get() = ContextModule(context = requireContext().applicationContext)

    private val moodEntryPanelViewModule get() = MoodEntryPanelViewModule(view = rootView)

    override fun injectLayoutId() {
        injectLayoutIdViewComponent = injectLayoutIdViewComponentBuilder.build()
        super.injectLayoutId()
    }

    override fun inject() = injectableComponent.inject(this)
}