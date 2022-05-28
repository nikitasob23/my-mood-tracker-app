package com.niksob.domain.utils.date

import java.time.LocalDate
import java.time.LocalTime
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter


const val DATE_PATTERN = "MM-dd-yy"
const val TIME_PATTERN = "HH:mm"

@Suppress("NewApi")
class DateUtil {
    companion object {

        val now
            get() = ZonedDateTime.now()

        private val dateFormatter
            get() = DateTimeFormatter.ofPattern(DATE_PATTERN)

        private val timeFormatter
            get() = DateTimeFormatter.ofPattern(TIME_PATTERN)

        fun toUtcDate(zonedDateTime: ZonedDateTime): String {

            val offsetInSeconds = zonedDateTime.offset.totalSeconds
            var localDateTime = zonedDateTime.toLocalDateTime()

            localDateTime = localDateTime.minusSeconds(offsetInSeconds.toLong())

            val date = localDateTime.toLocalDate()
            val formatter = DateTimeFormatter.ofPattern(DATE_PATTERN)

            return date.format(formatter)
        }

        fun toUtcTime(zonedDateTime: ZonedDateTime): String {

            val offsetInSeconds = zonedDateTime.offset.totalSeconds
            var localDateTime = zonedDateTime.toLocalDateTime()

            localDateTime = localDateTime.minusSeconds(offsetInSeconds.toLong())

            val time = localDateTime.toLocalTime()
            val formatter = DateTimeFormatter.ofPattern(TIME_PATTERN)

            return time.format(formatter)
        }

        private fun toZonedDateTime(utcDateStr: String, utcTimeStr: String): ZonedDateTime {

            val utcDate = LocalDate.parse(utcDateStr, dateFormatter)
            val utcTime = LocalTime.parse(utcTimeStr, timeFormatter)
            val utcDateTime = utcTime.atDate(utcDate)

            val zonedDateTime = ZonedDateTime.of(utcDateTime, ZonedDateTime.now().zone)
            val offsetInSeconds = ZonedDateTime.now().offset.totalSeconds

            return zonedDateTime.plusSeconds(offsetInSeconds.toLong())
        }

        fun toLocalDate(utcDateStr: String, utcTimeStr: String): String {
            val zonedDateTime = toZonedDateTime(utcDateStr, utcTimeStr)

            val localDate = zonedDateTime.toLocalDate()
            return dateFormatter.format(localDate)
        }

        fun toLocalTime(utcDateStr: String, utcTimeStr: String): String {
            val zonedDateTime = toZonedDateTime(utcDateStr, utcTimeStr)

            val localTime = zonedDateTime.toLocalTime()
            return timeFormatter.format(localTime)
        }
    }
}