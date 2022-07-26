package com.niksob.app.view.moodentry

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.niksob.app.R
import com.niksob.app.view.base.MVVMBaseView
import com.niksob.app.viewmodel.moodentry.MoodEntriesViewModel
import com.niksob.di.component.view.moodentry.DaggerMoodEntriesViewComponent
import com.niksob.di.module.app.ContextModule
import com.niksob.di.module.view.moodentry.MoodEntriesViewModule
import com.niksob.domain.model.MoodEntry
import com.niksob.domain.model.Query

class MoodEntriesView : MVVMBaseView() {

    override val layout get() = R.layout.entries_view

    private lateinit var moodEntryRecycleView: RecyclerView

    @Suppress("UNCHECKED_CAST")
    private val moodEntriesObserver = Observer<Query> { response ->
        initMoodEntriesList(response.data as List<MoodEntry>)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewDataLoading() {

        val moodEntriesViewModel = viewModel as MoodEntriesViewModel

        if (viewModel!!.loadingIsCompleted()) {
            val response = moodEntriesViewModel.moodEntriesResponse.value
            initMoodEntriesList(response!!.data as List<MoodEntry>)
            return
        }
        moodEntriesViewModel.loadMoodEntriesByUserId()
    }

    override fun inject() {

        val contextModule = ContextModule(requireContext().applicationContext)

        val moodEntriesViewModule = MoodEntriesViewModule(
            viewModelStoreOwner = viewModelStoreOwner,
            viewLifecycleOwner = viewLifecycleOwner,
            moodEntriesObserver = moodEntriesObserver
        )

        val component = DaggerMoodEntriesViewComponent.builder()
            .contextModule(contextModule)
            .moodEntriesViewModule(moodEntriesViewModule)
            .build()

        component.inject(this)
    }

    override fun initComponents() {
        moodEntryRecycleView = rootView.findViewById(R.id.entries_view__entry_recycle_view)
    }

    private fun initMoodEntriesList(moodEntries: List<MoodEntry>) {
        moodEntryRecycleView.apply {
            layoutManager = LinearLayoutManager(requireContext().applicationContext)
            adapter = MoodEntryAdapter(moodEntries)
        }
    }
}