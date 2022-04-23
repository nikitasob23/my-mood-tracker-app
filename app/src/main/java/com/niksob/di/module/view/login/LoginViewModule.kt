package com.niksob.di.module.view.login

import com.niksob.presentation.view.LoginInView
import com.niksob.presentation.view.SignUpView
import dagger.Module
import dagger.Provides

@Module
class LoginViewModule {

    @Provides
    fun provideLoginInViewClass() = LoginInView::class.java

    @Provides
    fun provideSignUpViewClass() = SignUpView::class.java
}