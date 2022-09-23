package com.niksob.di.module.viewmodel.auth.loginin

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.app.viewmodel.auth.loginin.base.LoginInViewModel
import com.niksob.app.viewmodel.auth.loginin.validation.LoginInViewModelWithValidation
import com.niksob.di.module.app.AppMainActivityViewModelStoreOwnerModule
import com.niksob.di.module.viewmodel.auth.loginin.factory.LoginInViewModelFactoryModule
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(
    includes = [
        LoginInViewModelFactoryModule::class,
        AppMainActivityViewModelStoreOwnerModule::class,
    ]
)
class LoginInViewModelModule {
    @Provides
    @Named("login_in_view_model")
    fun provideLoginInViewModel(
        viewModelFactory: ViewModelProvider.Factory,
        viewModelClassImpl: Class<LoginInViewModelWithValidation>,
        viewModelStoreOwner: ViewModelStoreOwner,
    ): LoginInViewModel =
        ViewModelProvider(viewModelStoreOwner, viewModelFactory)[viewModelClassImpl]

    @Provides
    fun provideViewModelClass() = LoginInViewModelWithValidation::class.java
}