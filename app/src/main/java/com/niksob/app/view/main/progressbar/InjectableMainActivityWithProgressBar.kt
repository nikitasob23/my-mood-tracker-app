package com.niksob.app.view.main.progressbar

import android.view.ViewGroup
import com.niksob.app.R
import com.niksob.di.component.view.main.DaggerMainActivityComponent
import com.niksob.di.module.app.AppProgressBarModule

open class InjectableMainActivityWithProgressBar : MainActivityWithProgressBar() {

    override val injectableComponentBuilder: DaggerMainActivityComponent.Builder
        get() = super.injectableComponentBuilder
            .appProgressBarModule(appProgressBarModule)

    private val appProgressBarModule get() = AppProgressBarModule(progressBarLayoutComponent)

    private lateinit var progressBarLayoutComponent: ViewGroup

    override fun initComponents() {
        super.initComponents()
        progressBarLayoutComponent = findViewById(R.id.main_layout__main_progress_bar)
    }
}