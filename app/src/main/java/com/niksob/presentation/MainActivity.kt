package com.niksob.presentation

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.niksob.domain.navigation.appprogressbar.AppProgressBar
import com.niksob.di.component.DaggerActivityComponent
import com.niksob.di.module.app.FragmentManagerModule
import com.niksob.di.module.app.AppProgressBarModule
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

    private lateinit var progressBarFrameLayout: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)

        initComponents()

        inject()

        navigation.goToNextView(homeScreen)
    }

    private fun initComponents() {
        progressBarFrameLayout = findViewById(R.id.main_layout__main_progress_bar)
    }

    private fun inject() {
        val component = DaggerActivityComponent.builder()
            .fragmentManagerModule(FragmentManagerModule(supportFragmentManager))
            .appProgressBarModule(AppProgressBarModule(progressBarFrameLayout))
            .build()
        component.inject(this)
    }
}