package com.niksob.di.module.viewmodel.user

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.app.viewmodel.user.BaseUserAdditionViewModel
import com.niksob.app.viewmodel.user.UserAdditionViewModel
import com.niksob.di.module.app.AppMainActivityViewModelStoreOwnerModule
import com.niksob.di.module.viewmodel.user.factory.UserAdditionViewModelFactoryModule
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [
    AppMainActivityViewModelStoreOwnerModule::class,
    UserAdditionViewModelFactoryModule::class,
])
class UserAdditionViewModelModule {

    @Provides
    @Named("user_addition_view_model")
    fun provideViewModel(
        viewModelStoreOwner: ViewModelStoreOwner,
        @Named("user_addition_view_model_factory") viewModelFactory: ViewModelProvider.Factory,
        viewModelClass: Class<BaseUserAdditionViewModel>
    ): UserAdditionViewModel =
        ViewModelProvider(viewModelStoreOwner, viewModelFactory)[viewModelClass]

    @Provides
    fun provideViewModelClass() = BaseUserAdditionViewModel::class.java
}