package com.niksob.app.view.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.niksob.app.R

open class BaseMainActivity : ViewComponentInitializer, AppCompatActivity() {

    protected val layout get() = R.layout.main_layout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        initComponents()
    }

    override fun initComponents() = Unit
}