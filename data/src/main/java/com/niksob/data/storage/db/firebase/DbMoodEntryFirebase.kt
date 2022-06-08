package com.niksob.data.storage.db.firebase

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.niksob.data.storage.db.MoodEntryStorage
import com.niksob.data.storage.string.AppStringStorage
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query


private const val ENTRY_DEGREE_KEY = "degree"
private const val ENTRY_TIME_KEY = "time"

private const val SUCCESS_LOAD_REASON_STR_ID = "mood_entry_was_load"
private const val FAILURE_LOAD_REASON_STR_ID = "mood_entry_was_not_load"
private const val SUCCESS_SAVING_REASON_STR_ID = "success_saving"
private const val FAILURE_SAVING_REASON_STR_ID = "failure_saving"

class DbMoodEntryFirebase(
    private val dbRef: DatabaseReference,
    private val stringStorage: AppStringStorage,
) : MoodEntryStorage {

    private fun getValueEventListener(callback: Callback<Query>, path: String) =
        object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                for (data in snapshot.children) {
                    val id = data.key
                    val fullPath = "$path/$id"

                    val degree = data.child(ENTRY_DEGREE_KEY)
                        .getValue(Int::class.java)
                    val time = data.child(ENTRY_TIME_KEY)
                        .getValue(String::class.java)

                    val degreeTimeMap = mapOf(
                        ENTRY_DEGREE_KEY to degree,
                        ENTRY_TIME_KEY to time,
                    )

                    val moodEntryDto = mapOf(
                        fullPath to degreeTimeMap,
                    )

                    val responseDto = Query(
                        data = moodEntryDto,
                        completed = true,
                        reason = stringStorage.getString(FAILURE_LOAD_REASON_STR_ID)
                    )

                    callback.call(responseDto)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("!!!", "Failed loading mood entry by data. Error message: ${error.message}")

                val response = Query(
                    reason = stringStorage.getString(FAILURE_LOAD_REASON_STR_ID)
                )
                callback.call(response)
            }

        }

    override fun loadByDate(request: Query) {
        val moodEntryPath = request.data as String


        dbRef.child(moodEntryPath)
            .addValueEventListener(getValueEventListener(request.callback!!, moodEntryPath))
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @Suppress("UNCHECKED_CAST")
    override fun save(request: Query) {
        val moodEntryDto = request.data as Map<String, Any>

        moodEntryDto.entries.forEach { (path, value) ->
            dbRef.child(path)
                .setValue(value)
                .addOnSuccessListener { onSuccess(request.callback!!) }
                .addOnFailureListener { e -> onFailure(request.callback!!, e) }
        }
    }

    private fun onSuccess(callback: Callback<Query>) {

        Log.d(this::class.simpleName, "Successful addition MoodEntryDto")

        val response = Query(
            completed = true,
            reason = stringStorage.getString(SUCCESS_SAVING_REASON_STR_ID),
        )
        callback.call(response)
    }

    private fun onFailure(callback: Callback<Query>, e: Exception) {
        Log.d(this::class.simpleName, "Failure addition MoodEntryDto.Exception message: ${e.message}")

        val response = Query(
            reason = stringStorage.getString(FAILURE_SAVING_REASON_STR_ID) + ". Exception: ${e.message}",
        )
        callback.call(response)
    }
}