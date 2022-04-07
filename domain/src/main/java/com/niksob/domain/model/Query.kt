package com.niksob.domain.model


data class Query(
    val data: Any? = null,
    val completed: Boolean = false,
    val reason: String = "",
    val callback: Callback<Query>? = null,
)