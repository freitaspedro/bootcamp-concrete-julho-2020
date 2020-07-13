package br.concrete.bootcamp_concrete_julho_2020

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class LoginViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val mockPasswordValidator = mockk<PasswordValidator>()
    private val loginViewModel = LoginViewModel(mockPasswordValidator)

    @Test
    fun givenInvalidPassword_whenValidatingPassword_shouldEmitErrorState() {
        every { mockPasswordValidator.validate(any()) } returns false

        loginViewModel.validateLogin("abcde")

        Assert.assertEquals(
            loginViewModel.getViewState().value,
            LoginViewModelState.Error(R.string.generic_login_error)
        )
    }

    @Test
    fun givenValidPassword_whenValidatingPassword_shouldEmitSuccessState() {
        every { mockPasswordValidator.validate(any()) } returns true

        loginViewModel.validateLogin("abcde")

        Assert.assertEquals(
            loginViewModel.getViewState().value,
            LoginViewModelState.Success
        )
    }
}
