package com.niksob.di.module.view.auth.login

import com.niksob.app.view.auth.loginin.mvvm.InjectableMVVMLoginInView
import com.niksob.app.view.auth.signup.NavigationableSignUpView
import com.niksob.domain.model.NavigationableScreenClass
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [LoginViewModule::class])
class LoginViewModule2 {
    @Provides
    @Named("login_in_view_class")
    fun provideLoginInViewClass(): NavigationableScreenClass =
        NavigationableScreenClass(InjectableMVVMLoginInView::class.java)

    @Provides
    @Named("sign_up_view_class")
    fun provideSignUpViewClass(): NavigationableScreenClass =
        NavigationableScreenClass(NavigationableSignUpView::class.java)
}