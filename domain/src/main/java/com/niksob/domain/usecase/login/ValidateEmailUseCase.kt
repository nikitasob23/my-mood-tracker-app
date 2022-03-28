package com.niksob.domain.usecase.login

import java.util.regex.Pattern

const val REGEX_EMAIL =
    "^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})\$"

class ValidateEmailUseCase {

    fun execute(email: String): Boolean {
        return email.isNotEmpty() && Pattern.matches(REGEX_EMAIL, email)
    }
}