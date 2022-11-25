package com.niksob.di.module.view.mood_entry_day.navigation

import com.niksob.app.view.base.factory.ViewFactory
import com.niksob.app.view.mood_entry_day.navigation.MoodEntryDayScreenNavigation
import com.niksob.di.module.navigation.AppScreenNavigationModule
import com.niksob.di.module.view.mood_entry.factory.MoodEntryUIViewFactoryModule
import com.niksob.domain.model.MoodEntryId
import com.niksob.domain.navigation.AppScreenNavigation
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        AppScreenNavigationModule::class,
        MoodEntryUIViewFactoryModule::class,
    ]
)
class MoodEntryDayScreenNavigationModule {
    @Provides
    fun provideMoodEntryDayScreenNavigation(
        screenNavigation: AppScreenNavigation,
        moodEntryUIViewFactory: ViewFactory<MoodEntryId>,
    ) =
        MoodEntryDayScreenNavigation(
            screenNavigation = screenNavigation,
            moodEntryUIViewFactory = moodEntryUIViewFactory,
        )
}