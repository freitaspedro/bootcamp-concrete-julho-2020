package br.concrete.bootcamp_concrete_julho_2020

import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import java.lang.Exception

var passwordValidator: PasswordValidator = PasswordValidator()

fun PasswordValidatorTest.mockPasswordValidator(func: PasswordValidatorArrange.() -> Unit): PasswordValidatorAct {
    PasswordValidatorArrange().apply {
        func()
    }
    return PasswordValidatorAct()
}

class PasswordValidatorArrange{

    fun createPasswordValidator() {
        passwordValidator = PasswordValidator()
    }

}

class PasswordValidatorAct {

    infix fun act(func: PasswordValidatorAct.() -> Boolean): PasswordValidatorAssert{
        val passwordValidatorAssert = PasswordValidatorAssert()
        passwordValidatorAssert.resultValidation = func()
        return passwordValidatorAssert
    }

    fun validate(password: String): Boolean = passwordValidator.validate(password)

}

class PasswordValidatorAssert {

    var resultValidation: Boolean? = null

    infix fun assert(func: PasswordValidatorAssert.() -> Unit){
        func()
    }

    fun isTrue(){
        resultValidation?.let {
            assertTrue(it)
        } ?: run {
            throw Exception("Result NOT INITIALIZED.")
        }
    }

    fun isFalse(){
        resultValidation?.let {
            assertFalse(it)
        } ?: run {
            throw Exception("Result NOT INITIALIZED.")
        }
    }

}