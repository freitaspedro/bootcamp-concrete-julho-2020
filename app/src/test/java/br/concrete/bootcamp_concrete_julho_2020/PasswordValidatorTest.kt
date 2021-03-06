package br.concrete.bootcamp_concrete_julho_2020

import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Test

class PasswordValidatorTest {

    @Test
    fun givenPasswordShorterThanEightCharacters_whenValidate_shouldReturnFalse(){
        //arrange
        val passwordValidator = PasswordValidator()
        //act
        val result = passwordValidator.validate("@aB12")
        //assert
        assertFalse(result)
    }

    @Test
    fun givenPasswordWithoutUpperCase_whenValidate_shouldReturnFalse(){
        //arrange
        val passwordValidator = PasswordValidator()
        //act
        val result = passwordValidator.validate("ab1#oiu3fd")
        //assert
        assertFalse(result)
    }

    @Test
    fun givenPasswordWithoutLowerCase_whenValidate_shouldReturnFalse(){
        //arrange
        val passwordValidator = PasswordValidator()
        //act
        val result = passwordValidator.validate("QWWE#@#12133")
        //assert
        assertFalse(result)
    }

    @Test
    fun givenPasswordWithoutNumber_whenValidate_shouldReturnFalse(){
        //arrange
        val passwordValidator = PasswordValidator()
        //act
        val result = passwordValidator.validate("abpo#oiufd")
        //assert
        assertFalse(result)
    }

    @Test
    fun givenPasswordWithoutSpecialChar_whenValidate_shouldReturnFalse(){
        //arrange
        val passwordValidator = PasswordValidator()
        //act
        val result = passwordValidator.validate("aGG5oiu3fd")
        //assert
        assertFalse(result)
    }

    @Test
    fun givenCorrectPassword_whenValidate_shouldReturnTrue(){
        /*//arrange
        val passwordValidator = PasswordValidator()
        //act
        val result = passwordValidator.validate("Ab12#@aB")
        //assert
        assertTrue(result)*/

        mockPasswordValidator {
            validate("Ab12#@aB")
        } assert {
            isTrue()
        }
    }

}