package com.niksob.di.module.view.login

import com.niksob.app.view.LoginInView
import com.niksob.app.view.SignUpView
import dagger.Module
import dagger.Provides

@Module
class LoginViewModule {

    @Provides
    fun provideLoginInViewClass() = LoginInView::class.java

    @Provides
    fun provideSignUpViewClass() = SignUpView::class.java
}