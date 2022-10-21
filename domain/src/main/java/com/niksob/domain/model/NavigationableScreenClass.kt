package com.niksob.domain.model

import com.niksob.domain.navigation.NavigationableScreen
import com.niksob.domain.navigation.ScreenFactory

data class NavigationableScreenClass(
    val clazz: Class<out NavigationableScreen>,
    val factory: ScreenFactory? = null,
) {
    val newInstance: NavigationableScreen
        get() {
            if (factory == null) {
                return clazz.getDeclaredConstructor().newInstance()
            }
            return factory.create()
        }
}
