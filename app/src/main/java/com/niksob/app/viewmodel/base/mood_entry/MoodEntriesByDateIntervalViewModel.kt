package com.niksob.app.viewmodel.base.mood_entry

import android.os.Build
import androidx.annotation.RequiresApi
import com.niksob.app.viewmodel.base.auth.observable.BaseAuthorizeUserViewModelImpl
import com.niksob.app.viewmodel.mood_entry_day.mood_entry.MoodEntryDayViewModel
import com.niksob.data.converter.DataConverter
import com.niksob.data.model.UIMoodEntries
import com.niksob.domain.model.MoodEntries
import com.niksob.domain.model.MoodEntriesData
import com.niksob.domain.model.Uid
import com.niksob.domain.usecase.auth.loading_auth_user.observation.LoadAuthorizeUserIdUseCase
import com.niksob.domain.usecase.db.mood_entry.observation.LoadMoodEntriesByUserIdAndDateUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.time.ZonedDateTime

private const val LOADED_DAYS_INTERVAL = 5

open class MoodEntriesByDateIntervalViewModel(
    private val moodEntryUIConverter: DataConverter<MoodEntries, UIMoodEntries>,
    private val loadMoodEntriesByUserIdAndDateUseCase: LoadMoodEntriesByUserIdAndDateUseCase,
    loadAuthorizeUserIdUseCase: LoadAuthorizeUserIdUseCase,
) : MoodEntryDayViewModel, BaseAuthorizeUserViewModelImpl(loadAuthorizeUserIdUseCase) {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun loadByDateInterval() =
        loadAuthorizeUser()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map(this::getMoodEntriesData)
            .cache()
            .flatMap(loadMoodEntriesByUserIdAndDateUseCase::execute)
            .map(moodEntryUIConverter::convert)

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getMoodEntriesData(uid: Uid) =
        MoodEntriesData(
            uid = uid,
            dateTime = ZonedDateTime.now(),
            loadedDaysInterval = LOADED_DAYS_INTERVAL,
        )
}