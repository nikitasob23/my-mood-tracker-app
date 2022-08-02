package com.niksob.data.provider

interface ResponseReasonProvider {

    val successStatus : Boolean

    val successfulReason: String

    fun failureReason(failureMessage: String?): String
}
