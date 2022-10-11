package com.niksob.di.component.view.auth.signup

import com.niksob.app.view.auth.signup.logger.InjectedLoggableSignUpView
import com.niksob.app.view.auth.signup.progressbar.InjectedSignUpViewWithProgressbar
import com.niksob.app.view.auth.signup.toast.InjectedSignUpViewWithToastMessages
import com.niksob.di.component.base.InjectableComponent
import com.niksob.app.view.auth.signup.uicomponent.InjectedSignUpViewWithSignUpComponent
import com.niksob.di.module.progressbar.AppProgressBarFromContextModule
import com.niksob.di.module.toast.ShortToastMessageModule
import com.niksob.di.module.view.auth.signup.navigation.SignUpViewWithNavigationModule
import com.niksob.di.module.viewmodel.auth.signup.SignUpViewModelWithAuthObserverModule
import com.niksob.di.module.viewmodel.user.UserAdditionViewModelWithObserverModule
import dagger.Component

@Component(
    modules = [
        SignUpViewModelWithAuthObserverModule::class,
        UserAdditionViewModelWithObserverModule::class,
        SignUpViewWithNavigationModule::class,
        AppProgressBarFromContextModule::class,
        ShortToastMessageModule::class,
    ]
)
interface SignUpViewComponent : InjectableComponent {
    fun inject(signUpView: InjectedSignUpViewWithSignUpComponent)

    fun inject(signUpView: InjectedSignUpViewWithProgressbar)

    fun inject(signUpView: InjectedSignUpViewWithToastMessages)

    fun inject(signUpView: InjectedLoggableSignUpView)
}