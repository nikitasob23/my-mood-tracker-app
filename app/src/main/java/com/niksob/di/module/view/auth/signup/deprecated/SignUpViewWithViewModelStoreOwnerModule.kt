package com.niksob.di.module.view.auth.signup.deprecated

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.app.view.mood.entry.MoodEntriesView
import com.niksob.app.viewmodel.auth.signup.deprecated.SignUpViewModelImpl
import com.niksob.di.module.viewmodel.signup.factory.SignUpViewModelFactoryModule
import com.niksob.domain.navigation.NavigationableScreen
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [SignUpViewModelFactoryModule::class])
class SignUpViewWithViewModelStoreOwnerModule(
    private val viewModelStoreOwner: ViewModelStoreOwner,
) {
    @Provides
    fun provideViewModel(
        viewModelFactory: ViewModelProvider.Factory,
        viewModelClass: Class<SignUpViewModelImpl>
    ) =
        ViewModelProvider(viewModelStoreOwner, viewModelFactory)[viewModelClass]

    @Provides
    fun provideViewModelClass() = SignUpViewModelImpl::class.java

    @Provides
    @Named("mood_entries_view_class")
    fun provideMoodEntriesViewClass(): Class<out NavigationableScreen> = MoodEntriesView::class.java
}
