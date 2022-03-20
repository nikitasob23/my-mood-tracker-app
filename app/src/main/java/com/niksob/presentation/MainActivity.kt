package com.niksob.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.niksob.di.component.DaggerAppComponent
import com.niksob.di.module.AppModule
import com.niksob.domain.navigation.ScreenNavigation
import com.niksob.presentation.view.LoginView
import com.niksob.presentation.navigation.NavigationableFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var navigation: ScreenNavigation

    private val homeScreen: NavigationableFragment = LoginView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)

        inject()

        navigation.goToNextView(homeScreen)
    }

    private fun inject() {
        val component = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
        component.inject(this)
    }
}