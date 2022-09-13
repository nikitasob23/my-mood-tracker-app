package com.niksob.di.module.view.auth.login

import com.niksob.app.view.auth.loginin.NavigatableLoginInView
import com.niksob.app.view.auth.signup.NavigationableSignUpView
import com.niksob.domain.navigation.NavigationableScreen
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class LoginViewModule {

    @Provides
    @Named("provide_login_in_view_class")
    fun provideLoginInViewClass(): Class<out NavigationableScreen> = NavigatableLoginInView::class.java

    @Provides
    @Named("provide_sign_up_view_class")
    fun provideSignUpViewClass(): Class<out NavigationableScreen> = NavigationableSignUpView::class.java
}