package com.niksob.data.storage.db.firebase.provider

import com.google.firebase.database.FirebaseDatabase

class FirebaseOfflineWork {
    companion object {

        private var enable = false

        fun turnOn() {
            if (enable) {
                return
            }
            turnOnFirebaseOfflineWork()
            enable = true
        }

        private fun turnOnFirebaseOfflineWork() =
            FirebaseDatabase.getInstance().setPersistenceEnabled(true)
    }
}