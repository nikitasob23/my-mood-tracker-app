package com.niksob.di.component.view.auth.signup

import com.niksob.app.view.auth.signup.progressbar.InjectedSignUpViewWithProgressbar
import com.niksob.app.view.auth.signup.toast.InjectedSignUpViewWithToastMessages
import com.niksob.di.component.InjectableComponent
import com.niksob.app.view.auth.signup.uicomponent.InjectedSignUpViewWithSignUpComponent
import com.niksob.di.module.app.progressbar.AppProgressBarFromContextModule
import com.niksob.di.module.toast.ShortToastMessageModule
import com.niksob.di.module.view.auth.signup.navigation.SignUpViewWithNavigationModule
import com.niksob.di.module.viewmodel.auth.signup.SignUpViewModelWithNewUserObserverModule
import dagger.Component

@Component(modules = [
    SignUpViewModelWithNewUserObserverModule::class,
    SignUpViewWithNavigationModule::class,
    AppProgressBarFromContextModule::class,
    ShortToastMessageModule::class,
])
interface SignUpViewComponent : InjectableComponent {
    fun inject(signUpView: InjectedSignUpViewWithSignUpComponent)

    fun inject(signUpView: InjectedSignUpViewWithProgressbar)

    fun inject(signUpView: InjectedSignUpViewWithToastMessages)
}