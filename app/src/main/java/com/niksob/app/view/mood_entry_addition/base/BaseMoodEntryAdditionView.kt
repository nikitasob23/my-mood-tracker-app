package com.niksob.app.view.mood_entry_addition.base

import com.niksob.app.R
import com.niksob.app.view.base.injection.BaseInjectableView
import com.niksob.domain.model.MoodEntry

open class BaseMoodEntryAdditionView(
    var moodEntry: MoodEntry? = null,
) : BaseInjectableView() {

    override val layout get() = R.layout.addition_mood_entry_view_layout
}