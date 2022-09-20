package com.niksob.app.view.main.activity.injection

import android.os.Bundle
import com.niksob.app.view.base.inject.Injectable
import com.niksob.app.view.main.activity.BaseMainActivity

open class InjectableMainActivity : Injectable, BaseMainActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
    }

    override fun inject() = Unit
}