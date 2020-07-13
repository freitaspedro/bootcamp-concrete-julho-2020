package br.concrete.bootcamp_concrete_julho_2020

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalStateException

class LoginViewModelFactory(
    private val passwordValidator: PasswordValidator
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(passwordValidator) as T
        }

        throw IllegalStateException("Unknown ViewModel Class")
    }
}
