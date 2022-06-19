package com.niksob.app.view.moodentry

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.niksob.app.R
import com.niksob.app.view.BaseView
import com.niksob.app.viewmodel.MoodEntriesViewModel
import com.niksob.di.component.DaggerMoodEntriesViewComponent
import com.niksob.di.module.app.ContextModule
import com.niksob.di.module.view.MoodEntriesViewModule
import com.niksob.domain.model.MoodEntry
import javax.inject.Inject

class MoodEntriesView : BaseView() {

    override val layout = R.layout.entries_view

    @Inject
    lateinit var viewModel: MoodEntriesViewModel

    private lateinit var entriesAdapter: RecyclerView.Adapter<MoodEntryAdapter.MoodEntryViewHolder>

    private lateinit var entriesRecyclerView: RecyclerView

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)

        progressBar?.showProgress()

        inject()

        viewModel.loadMoodEntriesByUserId()

        initMoodEntryObserver()

        return rootView
    }

    private fun inject() {
        DaggerMoodEntriesViewComponent.builder()
            .contextModule(ContextModule(requireContext().applicationContext))
            .moodEntriesViewModule(MoodEntriesViewModule(viewModelStoreOwner = this))
            .build()
            .inject(this)
    }

    private fun initMoodEntryObserver() {
        viewModel.moodEntriesResponse.observe(viewLifecycleOwner) { response ->
            val moodEntries = ArrayList<MoodEntry>()
            val responseDataList = response.data as List<*>
            responseDataList.forEach { data ->
                moodEntries.add(data as MoodEntry)
            }
            initMoodEntriesList(moodEntries)

            progressBar?.hideProgress()
        }
    }

    private fun initMoodEntriesList(moodEntries: List<MoodEntry>) {
        entriesAdapter = MoodEntryAdapter(moodEntries, requireContext().applicationContext)
        entriesRecyclerView = rootView.findViewById(R.id.entries_view__entry_recycle_view)
        entriesRecyclerView.layoutManager = LinearLayoutManager(requireContext().applicationContext)
        entriesRecyclerView.adapter = entriesAdapter
    }
}