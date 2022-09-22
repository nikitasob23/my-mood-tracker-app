package com.niksob.di.module.view.auth.login

import com.niksob.app.view.auth.loginin.toast.InjectableLoginInViewWithToastMessages
import com.niksob.app.view.auth.signup.toast.InjectedSignUpViewWithToastMessages
import com.niksob.domain.model.NavigationableScreenClass
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [LoginViewModule::class])
class LoginViewModule2 {
    @Provides
    @Named("login_in_view_class")
    fun provideLoginInViewClass(): NavigationableScreenClass =
        NavigationableScreenClass(InjectableLoginInViewWithToastMessages::class.java)

    @Provides
    @Named("sign_up_view_class")
    fun provideSignUpViewClass(): NavigationableScreenClass =
        NavigationableScreenClass(InjectedSignUpViewWithToastMessages::class.java)
}