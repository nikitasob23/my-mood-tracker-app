package com.niksob.presentation.navigation

import android.util.Log
import com.niksob.domain.navigation.NavigationableScreen
import com.niksob.domain.usecase.PopBackFragmentUseCase
import com.niksob.domain.usecase.SetFragmentUseCase
import com.niksob.domain.navigation.ScreenNavigation

class FragmentNavigation(
    private val setFragmentUseCase: SetFragmentUseCase,
    private val popBackFragmentUseCase: PopBackFragmentUseCase,
) : ScreenNavigation {

    override fun goToNextView(screen: NavigationableScreen) {
        Log.d(this::class.simpleName, "goToView() started")
        screen.attachNavigation(this)
        setFragmentUseCase.execute(screen)
    }

    override fun goToPreviousView() {
        popBackFragmentUseCase.execute()
    }
}