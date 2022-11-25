package com.niksob.app.view.base.factory

import com.niksob.domain.navigation.NavigationableScreen

interface ViewFactory<T> {
    fun create(data: T): NavigationableScreen
}