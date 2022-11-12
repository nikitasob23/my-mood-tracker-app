package com.niksob.data.model

interface OnDataCompletedAction {
    fun onDataCompleted()

    fun onDataCancelled(e: Throwable)
}