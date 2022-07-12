package com.niksob.app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

private const val DATA_NOT_LOADING_STATUS = false

class BaseViewModel : ViewModel(){

    var dataIsLoading = MutableLiveData<Boolean>(DATA_NOT_LOADING_STATUS)
}
