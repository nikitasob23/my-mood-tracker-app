package com.niksob.app.viewmodel

import androidx.lifecycle.MutableLiveData

enum class DataLoadingStatus {
    LOADING, LOADING_COMPLETED, LOADING_FAILURE,
}

interface ViewModelWithLoadingStatus {

    var dataLoadingStatus: MutableLiveData<DataLoadingStatus>

    fun loadingIsCompleted(): Boolean
}