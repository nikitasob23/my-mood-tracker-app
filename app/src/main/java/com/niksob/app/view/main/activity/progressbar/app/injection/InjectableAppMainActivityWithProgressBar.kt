package com.niksob.app.view.main.activity.progressbar.app.injection

import android.view.ViewGroup
import com.niksob.app.R
import com.niksob.app.view.main.activity.progressbar.MainActivityWithProgressBar
import com.niksob.di.component.application.DaggerApplicationComponent
import com.niksob.di.module.progressbar.AppProgressBarLayoutComponentModule

open class InjectableAppMainActivityWithProgressBar : MainActivityWithProgressBar() {

    override val injectableAppComponentBuilder: DaggerApplicationComponent.Builder
        get() = super.injectableAppComponentBuilder
            .appProgressBarLayoutComponentModule(appProgressBarLayoutComponentModule)

    private val appProgressBarLayoutComponentModule get() = AppProgressBarLayoutComponentModule(progressBarLayoutComponent)

    private lateinit var progressBarLayoutComponent: ViewGroup

    override fun initComponents() {
        super.initComponents()
        progressBarLayoutComponent = findViewById(R.id.main_layout__main_progress_bar)
    }
}