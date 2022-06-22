package com.niksob.app.view.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query
import com.niksob.app.R
import com.niksob.app.view.BaseView


class SignOutTestView : BaseView() {

    override val layout = R.layout.sign_out_test_view

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)

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
        }

        rootView.findViewById<AppCompatButton>(R.id.add_data_test_view__sign_out_btn).setOnClickListener {
            saveEntry()
        }

        return rootView
    }

    private fun saveEntry() {
    }
}