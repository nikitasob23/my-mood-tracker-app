package com.niksob.presentation.navigation

import android.util.Log
import android.widget.ProgressBar
import com.niksob.domain.navigation.NavigationableScreen
import com.niksob.domain.usecase.PopBackFragmentUseCase
import com.niksob.domain.usecase.SetFragmentUseCase
import com.niksob.domain.navigation.ScreenNavigation
import com.niksob.domain.navigation.appprogressbar.AppProgressBar

class FragmentNavigation(
    private val setFragmentUseCase: SetFragmentUseCase,
    private val popBackFragmentUseCase: PopBackFragmentUseCase,
    var progressBar: AppProgressBar? = null,
) : ScreenNavigation {

    override fun goToNextView(screen: NavigationableScreen) {
        Log.d(this::class.simpleName, "goToView() started")
        screen.attachNavigation(this)
        screen.attachAppProgressBar(progressBar)
        setFragmentUseCase.execute(screen)
    }

    override fun goToPreviousView() {
        popBackFragmentUseCase.execute()
    }
}