package com.niksob.di.component.application

import com.niksob.app.application.App
import com.niksob.di.module.app.*
import com.niksob.di.module.app.progressbar.AppProgressBarLayoutComponentModule
import dagger.Component

@Component(modules = [
    FragmentManagerModule::class,
    MainActivityViewModelStoreOwnerModule::class,
    AppProgressBarLayoutComponentModule::class,
    AppToolbarModule::class,
])
interface ApplicationComponent {
    fun inject(application: App)
}