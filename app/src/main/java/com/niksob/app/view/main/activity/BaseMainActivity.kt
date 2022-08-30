package com.niksob.app.view.main.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.niksob.app.R

open class BaseMainActivity : ViewComponentsInitializer, AppCompatActivity() {

    protected val layout = R.layout.main_layout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        initComponents()
    }

    override fun initComponents() = Unit
}