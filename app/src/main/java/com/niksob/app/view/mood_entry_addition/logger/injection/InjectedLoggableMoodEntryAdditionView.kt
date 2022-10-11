package com.niksob.app.view.mood_entry_addition.logger.injection

import com.niksob.app.view.mood_entry_addition.logger.LoggableMoodEntryAdditionView
import com.niksob.di.component.view.mood_entry_addition.AdditionMoodEntryViewComponent

open class InjectedLoggableMoodEntryAdditionView : LoggableMoodEntryAdditionView() {

    override val injectableComponent: AdditionMoodEntryViewComponent
        get() = injectableComponentBuilder.build()

    override fun inject() = injectableComponent.inject(this)
}