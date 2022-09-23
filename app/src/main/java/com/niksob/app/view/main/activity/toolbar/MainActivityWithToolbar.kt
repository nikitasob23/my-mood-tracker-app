package com.niksob.app.view.main.activity.toolbar

import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.niksob.app.R
import com.niksob.app.view.main.activity.progressbar.app.injection.InjectableAppMainActivityWithProgressBar

open class MainActivityWithToolbar : InjectableAppMainActivityWithProgressBar() {

    protected lateinit var appToolbar: Toolbar

    private val toolbarExitMenuLayout get() = R.menu.toolbar_exit_menu

    private val toolbarLayoutId get() = R.id.main_layout__toolbar

    private val toolbarExitMenuId get() = R.id.toolbar_exit_menu

    override fun initComponents() {
        super.initComponents()
        initToolbar()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(toolbarExitMenuLayout, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == toolbarExitMenuId) {
            signOut()
        }
        return true
    }

    private fun initToolbar() {
        appToolbar = findViewById(toolbarLayoutId)
        setSupportActionBar(appToolbar)
    }
}