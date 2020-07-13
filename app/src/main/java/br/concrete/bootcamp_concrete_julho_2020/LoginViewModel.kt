package br.concrete.bootcamp_concrete_julho_2020

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel(
    private val passwordValidator: PasswordValidator
) : ViewModel() {

    private val state = MutableLiveData<LoginViewModelState>()

    fun getViewState(): LiveData<LoginViewModelState> = state

    fun validateLogin(password: String) {
        val isValid = passwordValidator.validate(password)

        if (!isValid) {
            state.value = LoginViewModelState.Error(R.string.generic_login_error)
        } else {
            state.value = LoginViewModelState.Success
        }
    }
}
