package com.niksob.app.view.mood_entry_day.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.niksob.app.R
import com.niksob.app.model.AutoDisposableSingleObserver
import com.niksob.app.model.LayoutId
import com.niksob.app.view.base.injection.InjectableUIView
import com.niksob.app.view.mood_entries_list.adapter.factory.MoodEntryAdapterFactory
import com.niksob.app.view.mood_entry_day.loader.MoodEntryViewLoader
import com.niksob.domain.model.MoodEntries
import javax.inject.Inject

open class MoodEntryDayUIView : InjectableUIView() {

    override val layoutId = LayoutId(R.layout.entries_view)

    @Inject
    lateinit var moodEntryRecycleView: RecyclerView

    @Inject
    lateinit var moodEntryAdapterFactory: MoodEntryAdapterFactory

    @Inject
    lateinit var loader: MoodEntryViewLoader

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        onCreateViewDataLoading()
        return rootView
    }

    protected open fun loadByDateInterval() =
        loader.loadByDateInterval()
            .subscribeWith(AutoDisposableSingleObserver<MoodEntries>(
                onSuccess = this::configureMoodEntryRecycleView,
            ))

    private fun onCreateViewDataLoading() {
        loadByDateInterval()
    }

    private fun configureMoodEntryRecycleView(moodEntries: MoodEntries) {
            moodEntryRecycleView.apply {
                layoutManager = LinearLayoutManager(requireContext().applicationContext)
                adapter = this@MoodEntryDayUIView.moodEntryAdapterFactory.create(moodEntries)
            }
        }
}