package com.niksob.app.view.base.viewmodel.mood_entry.injection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.niksob.app.view.base.viewmodel.mood_entry.MoodEntriesLoaderView
import com.niksob.di.component.view.mood_entry.DaggerMoodEntriesListViewComponent
import com.niksob.di.component.view.mood_entry.MoodEntriesListViewComponent
import com.niksob.di.module.app.ContextModule
import com.niksob.di.module.viewmodel.moodentry.MoodEntriesListViewWithEntriesLoaderObserverModule
import com.niksob.domain.model.Query

abstract class InjectedMoodEntriesLoaderView : MoodEntriesLoaderView() {

    override val injectableComponent: MoodEntriesListViewComponent get() = injectableComponentBuilder.build()

    protected open val injectableComponentBuilder: DaggerMoodEntriesListViewComponent.Builder
        get() = DaggerMoodEntriesListViewComponent.builder()
            .contextModule(contextModule)
            .moodEntriesListViewWithEntriesLoaderObserverModule(moodEntriesListViewWithEntriesLoaderObserverModule)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        inject()
        return rootView
    }

    override fun inject() = injectableComponent.inject(this)

    private val contextModule get() = ContextModule(requireContext().applicationContext)

    private val moodEntriesListViewWithEntriesLoaderObserverModule
        get() = MoodEntriesListViewWithEntriesLoaderObserverModule(
            moodEntriesObserver = moodEntriesObserver,
            lifecycleOwner = this,
        )

    private val moodEntriesObserver get() = Observer<Query> { response -> onLoadMoodEntriesListCompleted(response) }
}