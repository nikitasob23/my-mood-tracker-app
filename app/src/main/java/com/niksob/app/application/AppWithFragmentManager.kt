package com.niksob.app.application

import android.app.Application
import androidx.fragment.app.FragmentManager
import javax.inject.Inject

open class AppWithFragmentManager : Application() {
    @Inject
    lateinit var fragmentManager: FragmentManager
}
