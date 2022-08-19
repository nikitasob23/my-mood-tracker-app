package com.niksob.app.view.main

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast
import  androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.domain.navigation.appprogressbar.AppProgressBar
import com.niksob.di.component.view.main.DaggerDeprecatedMainActivityComponent
import com.niksob.domain.navigation.ScreenNavigation
import com.niksob.app.R
import com.niksob.app.view.auth.LoginView
import com.niksob.app.view.moodentry.MoodEntriesView
import com.niksob.app.viewmodel.main.MainActivityViewModel
import com.niksob.di.module.app.*
import com.niksob.domain.model.Query
import com.niksob.domain.model.Uid
import javax.inject.Inject

@Deprecated(message = "Deprecated", replaceWith = ReplaceWith("InjectedMainActivity"), level = DeprecationLevel.WARNING)
class DeprecatedMainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainActivityViewModel

    @Inject
    lateinit var navigation: ScreenNavigation

    @Inject
    lateinit var mainProgressBar: AppProgressBar

    @Inject
    lateinit var loginViewClass: Class<LoginView>

    @Inject
    lateinit var moodEntriesViewClass: Class<MoodEntriesView>

    private val mainActivityViewModelStoreOwner: ViewModelStoreOwner = this

    private lateinit var progressBarFrameLayout: FrameLayout

    private lateinit var toolbar: Toolbar

    private val loadAuthUserResponseObserver = Observer<Query> { response ->
        val uid = response.data?.let { response.data as Uid }

        Log.d(
            this.javaClass.simpleName, "Login in authorize: success = ${response.completed}; "
                    + "reason = ${response.reason}; UID = $uid"
        )

        if (response.completed) {
            navigation.goToNextView(moodEntriesViewClass)
        } else {
            navigation.goToNextView(loginViewClass)
        }

        mainProgressBar.hideProgress()
    }

    private val signOutResponseObserver = Observer<Query> { response ->
        Toast.makeText(applicationContext, response.reason, Toast.LENGTH_SHORT)

        if (response.completed) {
            navigation.goToNextView(loginViewClass)
        }
        mainProgressBar.hideProgress()
    }

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

        toolbar = findViewById(R.id.main_layout__toolbar)
        setSupportActionBar(toolbar)
    }

    private fun inject() {
        val component = DaggerDeprecatedMainActivityComponent.builder()
            .contextModule(ContextModule(applicationContext))
            .fragmentManagerModule(FragmentManagerModule(supportFragmentManager))
            .appProgressBarModule(AppProgressBarModule(progressBarFrameLayout))
            .mainActivityViewModelStoreOwnerModule(MainActivityViewModelStoreOwnerModule(mainActivityViewModelStoreOwner))
            .build()
        component.inject(this)
    }

    private fun initViewModelUidObserver() {

        viewModel.loadAuthUserResponse.observe(this, loadAuthUserResponseObserver)
        viewModel.signOutResponse.observe(this, signOutResponseObserver)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_exit_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.toolbar_exit_menu) {
            mainProgressBar.showProgress()
            viewModel.signOut()
        }
        return true
    }
}