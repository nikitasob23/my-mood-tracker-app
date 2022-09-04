package com.niksob.di.module.navigation

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.di.module.app.progressbar.AppProgressBarModule
import com.niksob.di.module.app.FragmentManagerModule
import com.niksob.app.navigation.FragmentNavigation
import com.niksob.app.navigation.FragmentSetter
import com.niksob.di.module.app.MainActivityViewModelStoreOwnerModule
import com.niksob.domain.navigation.ScreenNavigation
import com.niksob.domain.navigation.ScreenSetter
import com.niksob.domain.navigation.appprogressbar.AppProgressBar
import com.niksob.domain.usecase.navigation.PopBackFragmentUseCase
import com.niksob.domain.usecase.navigation.SetFragmentUseCase
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        FragmentManagerModule::class,
        AppProgressBarModule::class,
        MainActivityViewModelStoreOwnerModule::class,
    ]
)
class ScreenNavigationModule {

    @Provides
    fun provideFragmentNavigation(
        setFragmentUseCase: SetFragmentUseCase,
        popBackFragmentUseCase: PopBackFragmentUseCase,
        appProgressBar: AppProgressBar,
        viewModelStoreOwner: ViewModelStoreOwner,
    ): ScreenNavigation =
        FragmentNavigation(
            setFragmentUseCase = setFragmentUseCase,
            popBackFragmentUseCase = popBackFragmentUseCase,
            appProgressBar = appProgressBar,
            viewModelStoreOwner = viewModelStoreOwner,
        )

    @Provides
    fun provideSetFragmentUseCase(screenSetter: ScreenSetter) = SetFragmentUseCase(screenSetter)

    @Provides
    fun providePopBackFragmentUseCase(screenSetter: ScreenSetter) = PopBackFragmentUseCase(screenSetter)

    @Provides
    fun provideFragmentSetter(manager: FragmentManager): ScreenSetter = FragmentSetter(manager)
}