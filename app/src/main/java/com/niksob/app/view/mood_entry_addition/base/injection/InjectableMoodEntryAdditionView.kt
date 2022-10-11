package com.niksob.app.view.mood_entry_addition.base.injection

import com.niksob.app.view.mood_entry_addition.base.BaseMoodEntryAdditionView
import com.niksob.di.component.view.mood_entry_addition.DaggerAdditionMoodEntryViewComponent
import com.niksob.di.module.app.ContextModule

open class InjectableMoodEntryAdditionView : BaseMoodEntryAdditionView() {

    protected open val injectableComponentBuilder: DaggerAdditionMoodEntryViewComponent.Builder
        get() = DaggerAdditionMoodEntryViewComponent.builder()
            .contextModule(contextModule)

    private val contextModule get() = ContextModule(requireContext().applicationContext)
}