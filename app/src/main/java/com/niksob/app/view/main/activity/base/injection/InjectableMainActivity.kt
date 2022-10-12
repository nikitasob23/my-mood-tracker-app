package com.niksob.app.view.main.activity.base.injection

import android.os.Bundle
import com.niksob.app.view.base.injection.Injectable
import com.niksob.app.view.main.activity.base.BaseMainActivity

open class InjectableMainActivity : Injectable, BaseMainActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
    }

    override fun inject() = Unit
}