package br.concrete.bootcamp_concrete_julho_2020

sealed class LoginViewModelState {
    data class Error(val stringResId: Int) : LoginViewModelState()

    object Success : LoginViewModelState()
}
