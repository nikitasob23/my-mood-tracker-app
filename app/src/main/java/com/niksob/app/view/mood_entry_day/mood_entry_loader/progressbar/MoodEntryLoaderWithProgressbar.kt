package com.niksob.app.view.mood_entry_day.mood_entry_loader.progressbar

import com.niksob.app.view.mood_entry_day.mood_entry_loader.base.MoodEntryLoaderImpl
import com.niksob.app.viewmodel.mood_entry.base.observation.MoodEntryDayViewModel
import com.niksob.domain.model.MoodEntries
import com.niksob.domain.navigation.appprogressbar.AppProgressBar
import io.reactivex.Single

class MoodEntryLoaderWithProgressbar(
    moodEntryViewModel: MoodEntryDayViewModel,
    private val progressbar: AppProgressBar
) : MoodEntryLoaderImpl(moodEntryViewModel) {

    override fun loadByDateInterval(): Single<MoodEntries> {
        progressbar.showProgress()
        val data = super.loadByDateInterval()
        progressbar.hideProgress()

        return data
    }
}