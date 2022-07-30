package com.niksob.app.view.moodentry

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.niksob.app.R
import com.niksob.app.view.BaseView
import com.niksob.app.viewmodel.moodentry.MoodEntriesViewModel
import com.niksob.di.component.DaggerMoodEntriesViewComponent
import com.niksob.di.module.app.ContextModule
import com.niksob.di.module.view.MoodEntriesViewModule
import com.niksob.domain.model.MoodEntry
import com.niksob.domain.model.Query
import javax.inject.Inject

class MoodEntriesView : BaseView() {

    override val layout = R.layout.entries_view

    @Inject
    lateinit var viewModel: MoodEntriesViewModel

    @Suppress("UNCHECKED_CAST")
    private val moodEntriesObserver = Observer<Query> { response ->

        if (!response.completed) {

            navigation?.goToPreviousView()
            return@Observer
        }

        val entries = response.data as List<MoodEntry>
        initMoodEntriesList(entries)

        progressBar?.hideProgress()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)

        progressBar?.showProgress()

        inject()

        viewModel.apply {
            loadMoodEntriesByUserId()
            moodEntriesResponse.observe(viewLifecycleOwner, moodEntriesObserver)
        }
        return rootView
    }

    private fun inject() {
        DaggerMoodEntriesViewComponent.builder()
            .contextModule(ContextModule(requireContext().applicationContext))
            .moodEntriesViewModule(MoodEntriesViewModule(viewModelStoreOwner = this))
            .build()
            .inject(this)
    }

    private fun initMoodEntriesList(moodEntries: List<MoodEntry>) {
        rootView.findViewById<RecyclerView>(R.id.entries_view__entry_recycle_view).apply {

            layoutManager = LinearLayoutManager(requireContext().applicationContext)
            adapter = MoodEntryAdapter(moodEntries, requireContext().applicationContext)
        }
    }
}