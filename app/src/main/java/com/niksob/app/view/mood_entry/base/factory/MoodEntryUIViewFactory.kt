package com.niksob.app.view.mood_entry.base.factory

import com.niksob.app.view.base.factory.ViewFactory
import com.niksob.app.view.mood_entry.injection.InjectedMoodEntryUIView
import com.niksob.domain.model.MoodEntryId

class MoodEntryUIViewFactory : ViewFactory<MoodEntryId> {

    override fun create(data: MoodEntryId) = InjectedMoodEntryUIView(data)
}