package com.niksob.utils.date

import com.niksob.domain.utils.date.DATE_PATTERN
import com.niksob.domain.utils.date.DateUtil
import com.niksob.domain.utils.date.TIME_PATTERN
import org.junit.Assert
import org.junit.Test
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

const val SECONDS_IN_HOUR = 3600
const val TIME_ZONE_WITH_NEGATIVE_OFFSET = "US/Eastern" // -4:00 from UTC

class DateUtilTest {

    private val date = "05.12.21"

    private val hours = 15
    private val minutes = 31
    private val splitSym = ":"

    private val time = hours.toString() + splitSym + minutes.toString()

    private fun time(hours: Int) =
        hours.toString() + splitSym + minutes.toString()

    private fun zonedHour(
        zoneOffset: ZoneOffset = ZonedDateTime.now().offset
    ) =
        (hours * SECONDS_IN_HOUR + zoneOffset.totalSeconds) / SECONDS_IN_HOUR

    private fun getZonedDateTime(zoneName: String): ZonedDateTime {
        var formatter = DateTimeFormatter.ofPattern(TIME_PATTERN)
        val localTime = LocalTime.parse(time, formatter)

        formatter = DateTimeFormatter.ofPattern(DATE_PATTERN)
        val localDate = LocalDate.parse(date, formatter)

        val localDateTime = localTime.atDate(localDate)

        val zoneId = ZoneId.of(zoneName)
        return ZonedDateTime.of(localDateTime, zoneId)
    }

    @Test
    fun `correct Convert Utc To local Time With Negative Zone Offset`() {
        val resultTime = DateUtil.toLocalTime(date, time)

        val expectedTime = time(zonedHour())
        Assert.assertEquals(expectedTime, resultTime)
    }

    @Test
    fun `correct Convert Local Time To Utc With Positive Zone Offset`() {
        val zonedDateTime = getZonedDateTime(TIME_ZONE_WITH_NEGATIVE_OFFSET)
        val expectedTime = time(hours + 4)

        val actualTime = DateUtil.toUtcTime(zonedDateTime)

        Assert.assertEquals(expectedTime, actualTime)
    }
}