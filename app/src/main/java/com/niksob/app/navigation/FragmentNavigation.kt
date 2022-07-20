package com.niksob.app.navigation

import android.util.Log
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.domain.navigation.NavigationableScreen
import com.niksob.domain.usecase.navigation.PopBackFragmentUseCase
import com.niksob.domain.usecase.navigation.SetFragmentUseCase
import com.niksob.domain.navigation.ScreenNavigation
import com.niksob.domain.navigation.appprogressbar.AppProgressBar


private const val ON_GO_TO_NEXT_VIEW_PREFIX_MESSAGE = "Go to view: "

class FragmentNavigation(
    private val setFragmentUseCase: SetFragmentUseCase,
    private val popBackFragmentUseCase: PopBackFragmentUseCase,
    var appProgressBar: AppProgressBar? = null,
    var toolbar: Toolbar? = null,
    var viewModelStoreOwner: ViewModelStoreOwner,
) : ScreenNavigation {

    override fun <T : NavigationableScreen> goToNextView(screenClass: Class<T>) {
        Log.d(this::class.simpleName, ON_GO_TO_NEXT_VIEW_PREFIX_MESSAGE + screenClass.simpleName)

        val screen = screenClass.newInstance()
        screen.attachNavigation(this)
        screen.attachAppProgressBar(appProgressBar)

        if (screen is NavigationableFragment) {
            val navigationableFragment = screen as NavigationableFragment
            navigationableFragment.attachToolbar(toolbar)
            navigationableFragment.attachViewModelStoreOwner(viewModelStoreOwner)
        }
        setFragmentUseCase.execute(screen)
    }

    override fun goToPreviousView() {
        popBackFragmentUseCase.execute()
    }
}