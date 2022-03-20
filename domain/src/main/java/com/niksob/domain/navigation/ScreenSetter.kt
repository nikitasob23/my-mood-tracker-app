package com.niksob.domain.navigation

interface ScreenSetter {
    fun setNext(screen: NavigationableScreen)

    fun setPrevious()
}