package com.niksob.presentation

import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.niksob.domain.navigation.appprogressbar.AppProgressBar
import com.niksob.di.component.DaggerMainActivityComponent
import com.niksob.di.module.app.FragmentManagerModule
import com.niksob.di.module.app.AppProgressBarModule
import com.niksob.di.module.app.ContextModule
import com.niksob.di.module.app.MainActivityViewModule
import com.niksob.domain.navigation.ScreenNavigation
import com.niksob.presentation.view.LoginView
import com.niksob.presentation.view.SignOutTestView
import com.niksob.presentation.view.SignUpView
import com.niksob.presentation.viewmodel.MainActivityViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainActivityViewModel

    @Inject
    lateinit var navigation: ScreenNavigation

    @Inject
    lateinit var mainProgressBar: AppProgressBar

    @Inject
    lateinit var loginView: LoginView

    private lateinit var progressBarFrameLayout: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)

        initComponents()
        inject()
        initViewModelUidObserver()

        mainProgressBar.showProgress()

        viewModel.loadAuthorizeUserId()
    }

    private fun initComponents() {
        progressBarFrameLayout = findViewById(R.id.main_layout__main_progress_bar)
    }

    private fun inject() {
        val component = DaggerMainActivityComponent.builder()
            .contextModule(ContextModule(applicationContext))
            .mainActivityViewModule(MainActivityViewModule(this))
            .fragmentManagerModule(FragmentManagerModule(supportFragmentManager))
            .appProgressBarModule(AppProgressBarModule(progressBarFrameLayout))
            .build()
        component.inject(this)
    }

    private fun initViewModelUidObserver() {
        viewModel.response.observe(this) { response ->
            val uid = response.data?.let { response.data as String }

            Log.d(this.javaClass.simpleName, "Login in authorize: success = ${response.completed}; "
                    + "reason = ${response.reason}; UID = $uid")

            if (response.completed) {
                navigation.goToNextView(SignOutTestView(uid!!))
            } else {
                navigation.goToNextView(loginView)
            }

            mainProgressBar.hideProgress()
        }
    }
}