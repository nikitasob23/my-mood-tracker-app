package com.niksob.domain.usecase.db

import com.niksob.domain.data.converter.DbMoodEntryConverter
import com.niksob.domain.data.repository.MoodEntryRepository
import com.niksob.domain.model.Callback
import com.niksob.domain.model.MoodEntriesData
import com.niksob.domain.model.Query
import com.niksob.domain.usecase.UseCase

@Suppress("UNCHECKED_CAST")
class LoadMoodEntriesByUserIdUseCase(
    private val entryRepo: MoodEntryRepository,
    private val dbMoodEntryConverter: DbMoodEntryConverter,
) : UseCase {
    override fun execute(request: Query) {
        val requestData = request.data!! as MoodEntriesData
        val requestCallback = request.callback!!

        val requestDto = Query(
            data = dbMoodEntryConverter.toDto(requestData),
            callback = Callback { responseDto ->

                val responseDtoData = responseDto.data!! as Map<String, Any>
                val response = Query(
                    data = dbMoodEntryConverter.fromDto(responseDtoData, requestData.uid),
                    completed = responseDto.completed,
                    reason = responseDto.reason,
                )
                requestCallback.call(response)
            }
        )
        entryRepo.loadByUserIdAndDate(requestDto)
    }
}