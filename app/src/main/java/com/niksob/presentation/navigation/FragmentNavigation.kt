package com.niksob.presentation.navigation

import android.util.Log
import com.niksob.domain.navigation.NavigationableScreen
import com.niksob.domain.usecase.navigation.PopBackFragmentUseCase
import com.niksob.domain.usecase.navigation.SetFragmentUseCase
import com.niksob.domain.navigation.ScreenNavigation
import com.niksob.domain.navigation.appprogressbar.AppProgressBar

class FragmentNavigation(
    private val setFragmentUseCase: SetFragmentUseCase,
    private val popBackFragmentUseCase: PopBackFragmentUseCase,
    var progressBar: AppProgressBar? = null,
) : ScreenNavigation {

    override fun <T : NavigationableScreen> goToNextView(screenClass: Class<T>) {
        Log.d(this::class.simpleName, "Go to view: ${screenClass.simpleName}")

        val screen = screenClass.newInstance()
        screen.attachNavigation(this)
        screen.attachAppProgressBar(progressBar)
        setFragmentUseCase.execute(screen)
    }

    override fun goToPreviousView() {
        popBackFragmentUseCase.execute()
    }
}