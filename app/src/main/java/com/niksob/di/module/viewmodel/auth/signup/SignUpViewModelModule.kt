package com.niksob.di.module.viewmodel.auth.signup

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.app.viewmodel.auth.signup.base.SignUpViewModel
import com.niksob.app.viewmodel.auth.signup.useraddition.SignUpViewModelWithNewUserAdditionImpl
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
        viewModelFactory: ViewModelProvider.Factory,
        ViewModelClass: Class<SignUpViewModelWithNewUserAdditionImpl>,
    ): SignUpViewModel =
        ViewModelProvider(viewModelStoreOwner, viewModelFactory)[ViewModelClass]

    @Provides
    fun provideViewModelClass() = SignUpViewModelWithNewUserAdditionImpl::class.java
}