package com.niksob.domain.utils.date

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter


const val DATE_PATTERN = "MM-dd-yy"
const val TIME_PATTERN = "HH:mm"

val ZonedDateTime.utcDate: String
    @Suppress("NewApi")
    get() {
        val offsetInSeconds = this.offset.totalSeconds
        var localDateTime = this.toLocalDateTime()

        localDateTime = localDateTime.minusSeconds(offsetInSeconds.toLong())

        val date = localDateTime.toLocalDate()
        val formatter = DateTimeFormatter.ofPattern(DATE_PATTERN)

        return date.format(formatter)
    }

val ZonedDateTime.utcTime: String
    @Suppress("NewApi")
    get() {

        val offsetInSeconds = this.offset.totalSeconds
        var localDateTime = this.toLocalDateTime()

        localDateTime = localDateTime.minusSeconds(offsetInSeconds.toLong())

        val time = localDateTime.toLocalTime()
        val formatter = DateTimeFormatter.ofPattern(TIME_PATTERN)

        return time.format(formatter)
    }

val ZonedDateTime.localDate: String
    @Suppress("NewApi")
    get() {

        val localDateTime = this.toLocalDateTime()
        val date = localDateTime.toLocalDate()
        val formatter = DateTimeFormatter.ofPattern(DATE_PATTERN)

        return date.format(formatter)
    }

val ZonedDateTime.localTime: String
    @Suppress("NewApi")
    get() {

        val localDateTime = this.toLocalDateTime()
        val time = localDateTime.toLocalTime()
        val formatter = DateTimeFormatter.ofPattern(TIME_PATTERN)

        return time.format(formatter)
    }