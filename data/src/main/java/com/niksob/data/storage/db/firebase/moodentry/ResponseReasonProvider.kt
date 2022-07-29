package com.niksob.data.storage.db.firebase.moodentry

interface ResponseReasonProvider {

    val successStatus : Boolean

    val successfulReason: String

    fun failureReason(failureMessage: String?): String
}
