package com.niksob.app.view.mood.entry

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.niksob.app.R
import com.niksob.app.view.main.activity.base.MVVMBaseView
import com.niksob.app.viewmodel.moodentry.MoodEntriesViewModel
import com.niksob.di.component.view.moodentry.DaggerMoodEntriesViewComponent
import com.niksob.di.module.app.ContextModule
import com.niksob.di.module.view.moodentry.MoodEntriesViewModule
import com.niksob.domain.model.MoodEntries
import com.niksob.domain.model.Query

class MoodEntriesView : MVVMBaseView() {

    override val layout get() = R.layout.entries_view

    private lateinit var moodEntryRecycleView: RecyclerView

    private val moodEntriesObserver = Observer<Query> { response ->
        @Suppress("UNCHECKED_CAST")
        initMoodEntriesList(response.data as MoodEntries)
    }

    override fun onCreateViewDataLoading() {

        @Suppress("UNCHECKED_CAST")
        val moodEntriesViewModel = viewModel as MoodEntriesViewModel

        if (viewModel!!.loadingIsCompleted()) {
            val response = moodEntriesViewModel.moodEntriesResponse.value
            initMoodEntriesList(response!!.data as MoodEntries)
            return
        }
        moodEntriesViewModel.loadMoodEntriesByUserId()
    }

    private val contextModule get() = ContextModule(requireContext().applicationContext)

    private val moodEntriesViewModule
        get() = MoodEntriesViewModule(
            viewModelStoreOwner = viewModelStoreOwner,
            viewLifecycleOwner = viewLifecycleOwner,
            moodEntriesObserver = moodEntriesObserver
        )

    private val component
        get() = DaggerMoodEntriesViewComponent.builder()
            .contextModule(contextModule)
            .moodEntriesViewModule(moodEntriesViewModule)
            .build()

    override fun inject() = component.inject(this)

    override fun initComponents() {
        moodEntryRecycleView = rootView.findViewById(R.id.entries_view__entry_recycle_view)
    }

    private fun initMoodEntriesList(moodEntries: MoodEntries) =
        moodEntryRecycleView.apply {
            layoutManager = LinearLayoutManager(requireContext().applicationContext)
            adapter = MoodEntryAdapter(moodEntries)
        }
}