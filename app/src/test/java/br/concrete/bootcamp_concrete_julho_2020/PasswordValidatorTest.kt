package br.concrete.bootcamp_concrete_julho_2020

import junit.framework.Assert.assertFalse
import org.junit.Test

class PasswordValidatorTest {


    @Test
    fun givenPasswordLengh7_whenValidate_shouldReturnFalse(){
        val passwordValidator = PasswordValidator()
        val result = passwordValidator.validate("1234567")
        assertFalse(result)
    }

}