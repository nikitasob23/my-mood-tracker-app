package com.niksob.data.converter

import com.niksob.domain.data.converter.base.DtoConverter
import com.niksob.domain.data.dto.UidDto
import com.niksob.domain.model.Uid

class UserIdDtoConverter : DtoConverter<Uid, UidDto> {

    override fun toDto(d: Uid) = UidDto(data = d.data)

    override fun fromDto(dto: UidDto) = Uid(data = dto.data)
}