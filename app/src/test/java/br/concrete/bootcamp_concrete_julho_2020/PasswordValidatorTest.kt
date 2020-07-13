package br.concrete.bootcamp_concrete_julho_2020

import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Test

class PasswordValidatorTest {

    @Test
    fun givenPasswordShorterThanEight_whenValidate_shouldReturnFalse(){
        val passwordValidator = PasswordValidator()
        val result = passwordValidator.validate("@aB12")
        assertFalse(result)
    }

    @Test
    fun givenPasswordWithoutUpperCase_whenValidate_shouldReturnFalse(){
        val passwordValidator = PasswordValidator()
        val result = passwordValidator.validate("ab1#oiu3fd")
        assertFalse(result)
    }

    @Test
    fun givenPasswordWithoutLowerCase_whenValidate_shouldReturnFalse(){
        val passwordValidator = PasswordValidator()
        val result = passwordValidator.validate("QWWE#@#12133")
        assertFalse(result)
    }

    @Test
    fun givenPasswordWithoutNumber_whenValidate_shouldReturnFalse(){
        val passwordValidator = PasswordValidator()
        val result = passwordValidator.validate("abpo#oiufd")
        assertFalse(result)
    }

    @Test
    fun givenPasswordWithoutSpecialChar_whenValidate_shouldReturnFalse(){
        val passwordValidator = PasswordValidator()
        val result = passwordValidator.validate("aGG5oiu3fd")
        assertFalse(result)
    }

    @Test
    fun givenEmptyPassword_whenValidate_shouldReturnFalse(){
        val passwordValidator = PasswordValidator()
        val result = passwordValidator.validate("")
        assertFalse(result)
    }

    @Test
    fun givenCorrectPassword_whenValidate_shouldReturnTrue(){
        val passwordValidator = PasswordValidator()
        val result = passwordValidator.validate("Ab12#@aB")
        assertTrue(result)
    }
}
