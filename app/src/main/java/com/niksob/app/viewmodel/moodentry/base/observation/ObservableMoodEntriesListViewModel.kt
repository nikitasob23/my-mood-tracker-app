package com.niksob.app.viewmodel.moodentry.base.observation

import com.niksob.domain.model.MoodEntries
import io.reactivex.Single

interface ObservableMoodEntriesListViewModel {

    fun loadByDateInterval(): Single<MoodEntries>
}