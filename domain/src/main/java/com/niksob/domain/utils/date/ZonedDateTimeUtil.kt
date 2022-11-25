package com.niksob.domain.utils.date

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter


const val DATE_PATTERN = "yy-MM-dd"
const val TIME_PATTERN = "HH:mm"

class ZonedDateTimeUtil {
    companion object {
        @Suppress("NewApi")
        fun fromDateAndTime(utcDateStr: String, utcTimeStr: String): ZonedDateTime =
            sequenceOf(utcDateStr to utcTimeStr)
                .map(this::toUtcDateTimePair)
                .map(this::toUtcDateTime)
                .map(this::toZonedDateTime)
                .map(this::addZoneOffset)
                .first()

        @Suppress("NewApi")
        private fun toUtcDateTimePair(dateTimePair: Pair<String, String>) =
            Pair(
                LocalDate.parse(dateTimePair.first, dateFormatter),
                LocalTime.parse(dateTimePair.second, timeFormatter),
            )

        @Suppress("NewApi")
        private fun toUtcDateTime(dateTimePair: Pair<LocalDate, LocalTime>) =
            dateTimePair.second
                .atDate(dateTimePair.first)

        @Suppress("NewApi")
        private fun toZonedDateTime(utcDateTime: LocalDateTime) =
            ZonedDateTime.of(utcDateTime, ZonedDateTime.now().zone)

        @Suppress("NewApi")
        private fun addZoneOffset(zonedDateTime: ZonedDateTime) =
            zonedDateTime.plusSeconds(offsetInSeconds.toLong())

        @Suppress("NewApi")
        private val offsetInSeconds = ZonedDateTime.now().offset.totalSeconds
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