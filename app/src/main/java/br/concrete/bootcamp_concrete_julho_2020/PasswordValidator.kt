package br.concrete.bootcamp_concrete_julho_2020

class PasswordValidator (){

    fun validate(password: String): Boolean{
        var result = false
        if(password.length >= 8){
            result = true
        }
        return result
    }

}