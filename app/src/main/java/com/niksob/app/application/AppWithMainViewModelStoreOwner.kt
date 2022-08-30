package com.niksob.app.application

import androidx.lifecycle.ViewModelStoreOwner
import javax.inject.Inject

open class AppWithMainViewModelStoreOwner : AppWithFragmentManager() {
    @Inject
    lateinit var mainViewModelStoreOwner: ViewModelStoreOwner
}
