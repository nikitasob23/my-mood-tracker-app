package com.niksob.app.viewmodel.moodentry

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.niksob.app.viewmodel.DataLoadingStatus
import com.niksob.app.viewmodel.MVVMBaseViewModel
import com.niksob.data.provider.AppStringProvider
import com.niksob.domain.model.Callback
import com.niksob.domain.model.MoodEntriesData
import com.niksob.domain.model.Query
import com.niksob.domain.usecase.auth.LoadAuthorizeUserIdUseCase
import com.niksob.domain.usecase.db.LoadMoodEntriesByUserIdAndDateUseCase
import java.time.ZonedDateTime


private const val LOADED_DAYS_INTERVAL = 5
private const val AUTH_FAILED_REASON_ID = "authorize_failed"

private const val UID_REQUEST_STATUS_LOG_MESSAGE_PREFIX = "Loading current user id is success: "
private const val MOOD_ENTRIES_REQUEST_STATUS_LOG_MESSAGE_PREFIX = "Loading mood entries is success: "
private const val REQUEST_REASON_LOG_MESSAGE_PREFIX = ", reason: "


class MoodEntriesViewModel(
    private val loadAuthorizeUserIdUseCase: LoadAuthorizeUserIdUseCase,
    private val loadMoodEntriesByUserIdUseCase: LoadMoodEntriesByUserIdAndDateUseCase,
    private val stringProvider: AppStringProvider,
) : MVVMBaseViewModel() {

    private val TAG get() = MoodEntriesViewModel::class.simpleName

    private val _moodEntriesResponse = MutableLiveData<Query>()

    val moodEntriesResponse: LiveData<Query> get() = _moodEntriesResponse

    @RequiresApi(Build.VERSION_CODES.O)
    fun loadMoodEntriesByUserId() {

        dataLoadingStatus.value = DataLoadingStatus.LOADING

        val callback = Callback<Query> { userIdResponse ->
            onAuthorizeUserIdLoaded(userIdResponse)
            dataLoadingStatus.value = DataLoadingStatus.LOADING_COMPLETED
        }
        loadAuthorizeUserIdUseCase.execute(callback)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun onAuthorizeUserIdLoaded(userIdResponse: Query) {

        Log.d(
            TAG, UID_REQUEST_STATUS_LOG_MESSAGE_PREFIX + userIdResponse.completed
                    + REQUEST_REASON_LOG_MESSAGE_PREFIX + userIdResponse.reason
        )

        if (!userIdResponse.completed) {
            _moodEntriesResponse.value = Query(
                reason = stringProvider.getString(AUTH_FAILED_REASON_ID)
            )
            dataLoadingStatus.value = DataLoadingStatus.LOADING_FAILURE
            return
        }

        val entriesData = MoodEntriesData(
            uid = userIdResponse.data as String,
            dateTime = ZonedDateTime.now(),
            loadedDaysInterval = LOADED_DAYS_INTERVAL
        )
        loadMoodEntries(entriesData)
    }

    private fun loadMoodEntries(entriesData: MoodEntriesData) {

        dataLoadingStatus.value = DataLoadingStatus.LOADING

        val request = Query(
            data = entriesData,
            callback = Callback { moodEntriesResponse ->

                Log.d(
                    TAG, MOOD_ENTRIES_REQUEST_STATUS_LOG_MESSAGE_PREFIX + moodEntriesResponse.completed
                            + REQUEST_REASON_LOG_MESSAGE_PREFIX + moodEntriesResponse.reason
                )
                _moodEntriesResponse.value = moodEntriesResponse
                dataLoadingStatus.value = DataLoadingStatus.LOADING_COMPLETED
            }
        )
        loadMoodEntriesByUserIdUseCase.execute(request)
    }
}