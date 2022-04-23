package com.niksob.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.google.firebase.auth.FirebaseAuth
import com.niksob.data.storage.string.AppStringProvider
import com.niksob.data.repository.AuthRepositoryImpl
import com.niksob.data.storage.db.DbAuthStorage
import com.niksob.data.storage.db.firebase.DbAuthFirebase
import com.niksob.data.storage.string.AppStringStorage
import com.niksob.domain.data.repository.AuthRepository
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query
import com.niksob.domain.usecase.login.SignOutUseCase
import com.niksob.presentation.R
import com.niksob.appstring.AndroidStringProvider


class SignOutTestView(
    private val uid: String,
): BaseView() {

    override val layout = R.layout.sign_out_test_view

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)

        val stringProvider: AppStringProvider = AndroidStringProvider(requireContext().applicationContext)
        val stringStorage = AppStringStorage(stringProvider)
        val auth = FirebaseAuth.getInstance()
        val storage: DbAuthStorage = DbAuthFirebase(auth, stringStorage)
        val repo: AuthRepository = AuthRepositoryImpl(storage)
        val signOutUseCase = SignOutUseCase(repo)

        val callback = Callback<Query> { response ->

            Toast.makeText(requireContext().applicationContext, response.reason, Toast.LENGTH_SHORT).show()

            if (!response.completed) {
                return@Callback
            }
            navigation?.goToNextView(LoginView())
            progressBar?.hideProgress()
        }

        rootView.findViewById<AppCompatButton>(R.id.sign_out_test_view__sign_out_btn).setOnClickListener {
            progressBar?.showProgress()
            signOutUseCase.execute(callback)
        }

        return rootView
    }
}