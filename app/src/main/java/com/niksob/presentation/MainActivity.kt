package com.niksob.presentation

import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.niksob.domain.navigation.appprogressbar.AppProgressBar
import com.niksob.di.component.DaggerActivityComponent
import com.niksob.di.module.ActivityModule
import com.niksob.di.module.AppProgressBarModule
import com.niksob.domain.navigation.NavigationableScreen
import com.niksob.domain.navigation.ScreenNavigation
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var navigation: ScreenNavigation

    @Inject
    lateinit var mainProgressBar: AppProgressBar

    @Inject
    lateinit var homeScreen: NavigationableScreen

    private lateinit var progressBar: ProgressBar
    private lateinit var mainScreenFrameLayout: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)

        initComponents()

        inject()

        navigation.goToNextView(homeScreen)
    }

    private fun initComponents() {
        progressBar = findViewById(R.id.main_layout__progress_bar)
        mainScreenFrameLayout = findViewById(R.id.main_layout__main_screen)
    }

    private fun inject() {
        val component = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .appProgressBarModule(AppProgressBarModule(progressBar, mainScreenFrameLayout))
            .build()
        component.inject(this)
    }
}