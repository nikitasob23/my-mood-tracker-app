package com.niksob.app.navigation

import com.niksob.domain.model.NavigationableScreenClass
import com.niksob.domain.navigation.AppScreenNavigation
import com.niksob.domain.usecase.navigation.PopBackFragmentUseCase
import com.niksob.domain.usecase.navigation.SetFragmentUseCase

open class AppFragmentNavigation2(
    setFragmentUseCase: SetFragmentUseCase,
    popBackFragmentUseCase: PopBackFragmentUseCase,
) : AppScreenNavigation,
    AppFragmentNavigation(
        setFragmentUseCase,
        popBackFragmentUseCase,
    ) {
    override fun goToNextView(screenClass: NavigationableScreenClass) {
        super.goToNextView(screenClass.clazz)
    }
}