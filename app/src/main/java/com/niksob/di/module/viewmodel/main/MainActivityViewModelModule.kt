package com.niksob.di.module.viewmodel.main

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.app.viewmodel.main.MainActivitySignOutViewModelWithStoreOwnerCleaning
import com.niksob.app.viewmodel.main.MainActivityViewModel
import com.niksob.di.module.app.AppMainActivityViewModelStoreOwnerModule
import com.niksob.di.module.app.ContextModule
import com.niksob.di.module.viewmodel.main.factory.MainActivityViewModelFactoryModule
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(
    includes = [
        ContextModule::class,
        MainActivityViewModelFactoryModule::class,
        AppMainActivityViewModelStoreOwnerModule::class,
    ]
)
class MainActivityViewModelModule {
    @Provides
    @Named("main_activity_view_model")
    fun provideViewModel(
        viewModelFactory: ViewModelProvider.Factory,
        viewModelClass: Class<MainActivitySignOutViewModelWithStoreOwnerCleaning>,
        viewModelStoreOwner: ViewModelStoreOwner,
    ): MainActivityViewModel =
        ViewModelProvider(viewModelStoreOwner, viewModelFactory)[viewModelClass]

    @Provides
    fun provideViewModelClass() = MainActivitySignOutViewModelWithStoreOwnerCleaning::class.java
}