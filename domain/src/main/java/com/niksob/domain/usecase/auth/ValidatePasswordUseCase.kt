package com.niksob.domain.usecase.auth

import java.util.regex.Pattern

const val PASSWORD_REGEX = "/(?=.*[0-9])(?=.*[!@#\$%^&*])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#\$%^&*]{6,}/g"

class ValidatePasswordUseCase {

    fun execute(password: String): Boolean {
        return password.isNotEmpty() && Pattern.matches(PASSWORD_REGEX, password)
    }
}