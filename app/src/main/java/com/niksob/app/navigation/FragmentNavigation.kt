package com.niksob.app.navigation

import android.util.Log
import androidx.appcompat.widget.Toolbar
import com.niksob.domain.navigation.NavigationableScreen
import com.niksob.domain.usecase.navigation.PopBackFragmentUseCase
import com.niksob.domain.usecase.navigation.SetFragmentUseCase
import com.niksob.domain.navigation.ScreenNavigation
import com.niksob.domain.navigation.appprogressbar.AppProgressBar


private const val ON_GO_TO_NEXT_VIEW_PREFIX_MESSAGE = "Go to view: "

class FragmentNavigation(
    private val setFragmentUseCase: SetFragmentUseCase,
    private val popBackFragmentUseCase: PopBackFragmentUseCase,
    var progressBar: AppProgressBar? = null,
    var toolbar: Toolbar? = null,
) : ScreenNavigation {

    override fun <T : NavigationableScreen> goToNextView(screenClass: Class<T>) {
        Log.d(this::class.simpleName, ON_GO_TO_NEXT_VIEW_PREFIX_MESSAGE + screenClass.simpleName)

        val screen = screenClass.newInstance()
        screen.attachNavigation(this)
        screen.attachAppProgressBar(progressBar)

        if (screen is NavigationableFragment) {
            (screen as NavigationableFragment).attachToolbar(toolbar)
        }
        setFragmentUseCase.execute(screen)
    }

    override fun goToPreviousView() {
        popBackFragmentUseCase.execute()
    }
}