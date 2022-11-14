package com.niksob.app.viewmodel.mood_entry.transfer

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.niksob.app.viewmodel.mood_entry.base.MoodEntriesListViewModel
import com.niksob.app.viewmodel.mood_entry.base.observation.MoodEntryDayViewModel
import com.niksob.domain.model.MoodEntries
import com.niksob.domain.model.Query
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class TransferObservableMoodEntriesListViewModel(
    private val observableViewModel: MoodEntryDayViewModel,
) : MoodEntriesListViewModel, ViewModel() {

    override val moodEntriesResponse get() = _moodEntriesResponse

    private val _moodEntriesResponse = MutableLiveData<Query>()

    private val subscriber
        get() = object : DisposableSingleObserver<MoodEntries>() {

            override fun onSuccess(t: MoodEntries) {
                val response = Query(data = t, completed = true)
                onLoadMoodEntriesListCompleted(response)
                dispose()
            }

            override fun onError(e: Throwable) {
                val failedResponse = Query(completed = false)
                onLoadMoodEntriesListCompleted(failedResponse)
                dispose()
            }
        }

    override fun loadMoodEntriesByUserId() =
        observableViewModel.loadByDateInterval()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(subscriber)

    override fun onLoadMoodEntriesListCompleted(response: Query) {
        _moodEntriesResponse.value = response
    }
}