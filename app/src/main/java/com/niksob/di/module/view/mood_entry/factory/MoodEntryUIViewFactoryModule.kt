package com.niksob.di.module.view.mood_entry.factory

import com.niksob.app.view.base.factory.ViewFactory
import com.niksob.app.view.provider.MOOD_ENTRY_VIEW_FACTORY
import com.niksob.domain.model.MoodEntryId
import dagger.Module
import dagger.Provides

@Module
class MoodEntryUIViewFactoryModule {
    @Provides
    fun provideMoodEntryUIViewFactory(): ViewFactory<MoodEntryId> = MOOD_ENTRY_VIEW_FACTORY.newInstance()
}