package com.niksob.di.module.view.auth.signup

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.app.view.mood.entry.MoodEntriesView
import com.niksob.app.viewmodel.auth.SignUpViewModel
import com.niksob.di.module.viewmodel.factory.SignUpViewModelFactoryModule
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
        viewModelClass: Class<SignUpViewModel>
    ) =
        ViewModelProvider(viewModelStoreOwner, viewModelFactory)[viewModelClass]

    @Provides
    fun provideViewModelClass() = SignUpViewModel::class.java

    @Provides
    @Named("mood_entries_view_class")
    fun provideMoodEntriesViewClass(): Class<out NavigationableScreen> = MoodEntriesView::class.java
}
