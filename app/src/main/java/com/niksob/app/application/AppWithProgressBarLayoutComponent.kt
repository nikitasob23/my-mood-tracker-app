package com.niksob.app.application

import android.view.ViewGroup
import javax.inject.Inject

open class AppWithProgressBarLayoutComponent : AppWithMainViewModelStoreOwner() {
    @Inject
    lateinit var progressBarLayoutComponent: ViewGroup
}
