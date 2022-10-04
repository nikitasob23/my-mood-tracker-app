package com.niksob.data.provider

interface ResponseReasonProvider {

    val successfulReason: String

    fun failureReason(failureMessage: String?): String
}
