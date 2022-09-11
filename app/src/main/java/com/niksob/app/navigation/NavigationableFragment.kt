package com.niksob.app.navigation

import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.domain.navigation.NavigationableScreen
import com.niksob.domain.navigation.ScreenNavigation
import com.niksob.domain.navigation.appprogressbar.AppProgressBar

open class NavigationableFragment : NavigationableScreen, Fragment() {
    var navigation: ScreenNavigation? = null

    var progressBar: AppProgressBar? = null

    var toolbar: Toolbar? = null

    var viewModelStoreOwner: ViewModelStoreOwner = this

    override fun attachNavigation(navigation: ScreenNavigation) {
        this.navigation = navigation
    }

    override fun attachAppProgressBar(progressBar: AppProgressBar?) {
        this.progressBar = progressBar
    }

    fun attachToolbar(toolbar: Toolbar?) {
        this.toolbar = toolbar
        this.toolbar?.visibility = View.VISIBLE
    }

    fun attachViewModelStoreOwner(viewModelStoreOwner: ViewModelStoreOwner?) {

        if (viewModelStoreOwner != null) {
            this.viewModelStoreOwner = viewModelStoreOwner
        }
    }
}