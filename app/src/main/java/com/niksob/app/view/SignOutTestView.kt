package com.niksob.app.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.niksob.data.storage.string.AppStringProvider
import com.niksob.data.repository.AuthRepositoryImpl
import com.niksob.data.storage.db.AuthStorage
import com.niksob.data.storage.db.firebase.AuthFirebase
import com.niksob.data.storage.string.AppStringStorage
import com.niksob.domain.data.repository.AuthRepository
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query
import com.niksob.domain.usecase.auth.SignOutUseCase
import com.niksob.app.R
import com.niksob.data.provider.FirebaseProvider
import com.niksob.utils.appstring.AndroidStringProvider


class SignOutTestView : BaseView() {

    override val layout = R.layout.sign_out_test_view

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)

//        val stringProvider: AppStringProvider = AndroidStringProvider(requireContext().applicationContext)
//        val stringStorage = AppStringStorage(stringProvider)
        val dbRef = "https://mygoodmood-8d862-default-rtdb.europe-west1.firebasedatabase.app/"
//        val dbProvider = FirebaseProvider(dbRef)
//        val storage: AuthStorage = AuthFirebase(dbProvider, stringStorage)
//        val repo: AuthRepository = AuthRepositoryImpl(storage)
//        val signOutUseCase = SignOutUseCase(repo)

        val callback = Callback<Query> { response ->

            Toast.makeText(requireContext().applicationContext, response.reason, Toast.LENGTH_SHORT).show()

            if (!response.completed) {
                return@Callback
            }
            navigation?.goToNextView(LoginView::class.java)
            progressBar?.hideProgress()
        }

        rootView.findViewById<AppCompatButton>(R.id.sign_out_test_view__sign_out_btn).setOnClickListener {
            progressBar?.showProgress()
//            signOutUseCase.execute(callback)
        }

        rootView.findViewById<AppCompatButton>(R.id.add_data_test_view__sign_out_btn).setOnClickListener {
            saveEntry()
        }

        return rootView
    }

    private fun saveEntry() {
//        val baseDbRef = "https://mygoodmood-8d862-default-rtdb.europe-west1.firebasedatabase.app/"
//        var dbRef = FirebaseDatabase.getInstance(baseDbRef).reference
//        dbRef = dbRef.child("mood_entries")
//
//        val strProvider = AndroidStringProvider(this.context!!)
//        val strStorage = AppStringStorage(strProvider)
//
//        val entryStorage = DbMoodEntryFirebase(dbRef, strStorage)
//
//        val moodEntry = MoodEntry(
//            id = dbRef.push().key!!,
//            uid = "tXRTSjgv43MvIITRx6T4YYUUuI13",
//            dateTime = ZonedDateTime.now(),
//            degree = 3,
//        )
//
//        val outputTextView = rootView.findViewById<AppCompatTextView>(R.id.output_text__test_sign_out_btn)
//        val callback = Callback<Query> { responseDto ->
//            outputTextView.text = responseDto.reason
//        }
//
////        val moodEntryDto = DbMoodEntryConverter.toDto(moodEntry)
//        val moodEntryDto = "/${moodEntry.uid}/${moodEntry.dateTime.utcDate}"
//
//        val request = Query(
//            data = moodEntryDto,
//            callback = callback,
//        )
//
//        entryStorage.loadByDate(request)
    }
}