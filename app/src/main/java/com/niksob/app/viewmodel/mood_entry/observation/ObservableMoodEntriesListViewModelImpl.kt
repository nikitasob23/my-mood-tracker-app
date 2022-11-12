package com.niksob.app.viewmodel.mood_entry.observation

import android.os.Build
import androidx.annotation.RequiresApi
import com.niksob.app.viewmodel.base.auth.observable.BaseAuthorizeUserViewModelImpl
import com.niksob.app.viewmodel.mood_entry.base.observation.ObservableMoodEntriesListViewModel
import com.niksob.domain.model.MoodEntries
import com.niksob.domain.model.MoodEntriesData
import com.niksob.domain.model.Uid
import com.niksob.domain.usecase.auth.loading_auth_user.observation.LoadAuthorizeUserIdUseCase
import com.niksob.domain.usecase.db.mood_entry.observation.LoadMoodEntriesByUserIdAndDateUseCase
import io.reactivex.Single
import java.time.ZonedDateTime

private const val LOADED_DAYS_INTERVAL = 5

class ObservableMoodEntriesListViewModelImpl(
    private val loadMoodEntriesByUserIdAndDateUseCase: LoadMoodEntriesByUserIdAndDateUseCase,
    loadAuthorizeUserIdUseCase: LoadAuthorizeUserIdUseCase,
) : ObservableMoodEntriesListViewModel, BaseAuthorizeUserViewModelImpl(loadAuthorizeUserIdUseCase) {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun loadByDateInterval(): Single<MoodEntries> =
        loadAuthorizeUser()
            .map(this::getMoodEntriesData)
            .flatMap(loadMoodEntriesByUserIdAndDateUseCase::execute)

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getMoodEntriesData(uid: Uid) =
        MoodEntriesData(
            uid = uid,
            dateTime = ZonedDateTime.now(),
            loadedDaysInterval = LOADED_DAYS_INTERVAL,
        )
}