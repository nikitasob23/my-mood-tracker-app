package com.niksob.app.viewmodel.moodentry

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import com.niksob.app.viewmodel.DataLoadingStatus
import com.niksob.app.viewmodel.ViewModelWithLoadingStatus
import com.niksob.data.provider.AppStringProvider
import com.niksob.domain.model.Query
import com.niksob.domain.usecase.auth.LoadAuthorizeUserIdUseCase
import com.niksob.domain.usecase.db.LoadMoodEntriesByUserIdUseCase

class MoodEntriesViewModelWithLoadingStatus(
    loadAuthorizeUserIdUseCase: LoadAuthorizeUserIdUseCase,
    loadMoodEntriesByUserIdUseCase: LoadMoodEntriesByUserIdUseCase,
    stringProvider: AppStringProvider,
) : ViewModelWithLoadingStatus,
    MoodEntriesViewModelImpl(loadAuthorizeUserIdUseCase, loadMoodEntriesByUserIdUseCase, stringProvider) {

    override var dataLoadingStatus = MutableLiveData<DataLoadingStatus>()

    override fun loadingIsCompleted() = dataLoadingStatus.value == DataLoadingStatus.LOADING_COMPLETED

    @RequiresApi(Build.VERSION_CODES.O)
    override fun loadMoodEntriesByUserId() {
        dataLoadingStatus.value = DataLoadingStatus.LOADING
        super.loadMoodEntriesByUserId()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onAuthorizeUserIdLoaded(userIdResponse: Query) {

        if (!userIdResponse.completed) {
            dataLoadingStatus.value = DataLoadingStatus.LOADING_FAILURE
            return
        }

        super.onAuthorizeUserIdLoaded(userIdResponse)
        dataLoadingStatus.value = DataLoadingStatus.LOADING_COMPLETED
    }
}