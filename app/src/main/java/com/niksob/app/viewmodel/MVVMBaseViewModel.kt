package com.niksob.app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

enum class DataLoadingStatus {
    LOADING, LOADING_COMPLETED, LOADING_FAILURE,
}

open class MVVMBaseViewModel : ViewModel(){

    var dataLoadingStatus = MutableLiveData<DataLoadingStatus>()

    fun loadingIsCompleted() = dataLoadingStatus.value == DataLoadingStatus.LOADING_COMPLETED
}