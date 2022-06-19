package com.niksob.domain.utils.date

import java.time.LocalDate
import java.time.LocalTime
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter


const val DATE_PATTERN = "MM-dd-yy"
const val TIME_PATTERN = "HH:mm"

class ZonedDateTimeUtil {
    companion object {
        @Suppress("NewApi")
        fun fromDateAndTime(utcDateStr: String, utcTimeStr: String): ZonedDateTime {
            val utcDate = LocalDate.parse(utcDateStr, dateFormatter)
            val utcTime = LocalTime.parse(utcTimeStr, timeFormatter)
            val utcDateTime = utcTime.atDate(utcDate)

            val zonedDateTime = ZonedDateTime.of(utcDateTime, ZonedDateTime.now().zone)
            val offsetInSeconds = ZonedDateTime.now().offset.totalSeconds

            return zonedDateTime.plusSeconds(offsetInSeconds.toLong())
        }
    }
}

@Suppress("NewApi")
private val dateFormatter = DateTimeFormatter.ofPattern(DATE_PATTERN)

@Suppress("NewApi")
private val timeFormatter = DateTimeFormatter.ofPattern(TIME_PATTERN)

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