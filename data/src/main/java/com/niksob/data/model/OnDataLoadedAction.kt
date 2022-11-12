package com.niksob.data.model

interface OnDataLoadedAction<T : Any> {

    fun onDataLoaded(resultData: T)

    fun onDataCancelled(e: Throwable)
}