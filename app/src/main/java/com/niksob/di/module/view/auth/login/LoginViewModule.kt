package com.niksob.di.module.view.auth.login

import com.niksob.app.view.provider.ViewClassProvider
import com.niksob.domain.model.NavigationableScreenClass
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class LoginViewModule {
    @Provides
    @Named("login_in_view_class")
    fun provideLoginInViewClass() = NavigationableScreenClass(ViewClassProvider.LOGIN_IN_VIEW.clazz)

    @Provides
    @Named("sign_up_view_class")
    fun provideSignUpViewClass() = NavigationableScreenClass(ViewClassProvider.SIGN_UP_VIEW.clazz)
}