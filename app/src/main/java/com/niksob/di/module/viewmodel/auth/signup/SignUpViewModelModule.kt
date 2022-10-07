package com.niksob.di.module.viewmodel.auth.signup

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.app.viewmodel.auth.signup.base.SignUpViewModel
import com.niksob.app.viewmodel.auth.signup.validation.SignUpViewModelWithLoginDataValidation
import com.niksob.di.module.app.AppMainActivityViewModelStoreOwnerModule
import com.niksob.di.module.viewmodel.auth.signup.factory.SignUpViewModelFactoryModule
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(
    includes = [
        AppMainActivityViewModelStoreOwnerModule::class,
        SignUpViewModelFactoryModule::class,
    ]
)
class SignUpViewModelModule {
    @Provides
    @Named("sign_up_view_model")
    fun provideViewModel(
        viewModelStoreOwner: ViewModelStoreOwner,
        @Named("sign_up_view_model_factory") viewModelFactory: ViewModelProvider.Factory,
        ViewModelClass: Class<SignUpViewModelWithLoginDataValidation>,
    ): SignUpViewModel =
        ViewModelProvider(viewModelStoreOwner, viewModelFactory)[ViewModelClass]

    @Provides
    fun provideViewModelClass() = SignUpViewModelWithLoginDataValidation::class.java
}