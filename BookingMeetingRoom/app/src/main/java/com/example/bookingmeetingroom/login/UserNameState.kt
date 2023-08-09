package com.example.bookingmeetingroom.login

import java.util.regex.Pattern


private const val USERNAME_VALIDATION_REGEX = "^(.+).(.+)\$"

class UserNameState :
    TextFieldState(validator = ::isUserNameValid, errorFor = ::userNameValidationError)

/**
 * Returns an error to be displayed or null if no error was found
 */
private fun userNameValidationError(userName: String): String {
    return "نام کاربری اشتباه  $userName"
}

private fun isUserNameValid(userName: String): Boolean {
    return Pattern.matches(USERNAME_VALIDATION_REGEX, userName)
}
