package com.example.devfinalevaluation.view

object RegistrationUtil {
    fun validate(
        userName: String,
        password: String,
    ): Boolean {
        if (password.length < 8) {
            return false
        }
        if (userName.isEmpty()) {
            return false
        }
        if (password.isEmpty()) {
            return false
        }
        return true
    }
}