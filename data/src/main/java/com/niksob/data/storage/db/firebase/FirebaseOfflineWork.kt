package com.niksob.data.storage.db.firebase

import com.google.firebase.database.FirebaseDatabase

class FirebaseOfflineWork {
    companion object {

        private var enable = false

        fun turnOn() {
            if (enable) {
                return
            }
            FirebaseDatabase.getInstance().setPersistenceEnabled(true)
            enable = true
        }
    }
}