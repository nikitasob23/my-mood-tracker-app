package com.niksob.app.viewmodel.moodentry.base

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import com.niksob.app.viewmodel.base.auth.AuthorizeUserViewModelImpl
import com.niksob.domain.model.Callback
import com.niksob.domain.model.MoodEntriesData
import com.niksob.domain.model.Query
import com.niksob.domain.model.Uid
import com.niksob.domain.usecase.auth.loading_auth_user.LoadAuthorizeUserIdUseCase
import com.niksob.domain.usecase.db.mood_entry.LoadMoodEntriesByUserIdAndDateUseCase
import java.time.ZonedDateTime

private const val LOADED_DAYS_INTERVAL = 5

open class BaseMoodEntriesListViewModel(
    private val loadMoodEntriesByUserIdAndDateUseCase: LoadMoodEntriesByUserIdAndDateUseCase,
    loadAuthorizeUserIdUseCase: LoadAuthorizeUserIdUseCase,
) : MoodEntriesListViewModel, AuthorizeUserViewModelImpl(loadAuthorizeUserIdUseCase) {

    override val moodEntriesResponse get() = mutableMoodEntriesResponse

    protected val mutableMoodEntriesResponse = MutableLiveData<Query>()

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getMoodEntriesData(userId: Uid) =
        MoodEntriesData(
            uid = userId,
            dateTime = ZonedDateTime.now(),
            loadedDaysInterval = LOADED_DAYS_INTERVAL,
        )

    override fun onLoadMoodEntriesListCompleted(response: Query) {
        mutableMoodEntriesResponse.value = response
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun loadMoodEntriesByUserId() {
        val onLoadAuthorizeUserCompleted: (Query) -> Unit = { uidResponse ->

            loadMoodEntriesByUserId(uidResponse.data as Uid)
        }
        loadAuthorizeUser(onLoadAuthorizeUserCompleted)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    protected fun loadMoodEntriesByUserId(uid: Uid) {

        val response = Query(
            data = getMoodEntriesData(uid),
            callback = Callback { response -> onLoadMoodEntriesListCompleted(response) },
        )
        loadMoodEntriesByUserIdAndDateUseCase.execute(response)
    }
}