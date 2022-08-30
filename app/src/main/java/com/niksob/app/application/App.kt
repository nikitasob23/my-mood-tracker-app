package com.niksob.app.application

import androidx.appcompat.widget.Toolbar
import javax.inject.Inject

class App : AppWithProgressBarLayoutComponent() {
    @Inject
    lateinit var appToolbar: Toolbar
}