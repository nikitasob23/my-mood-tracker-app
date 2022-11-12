package com.niksob.domain.data.converter.base

interface DtoConverter<T : Any, U : Any> {

    fun toDto(d: T): U

    fun fromDto(dto: U): T
}