package br.concrete.bootcamp_concrete_julho_2020

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @get:Rule
    val loginActivityTest = IntentsTestRule(LoginActivity::class.java)

    @get:Rule
    val disableAnimationRule = DisableAnimationRule()

    @Test
    fun givenInitialState_shouldShowEmailAndPasswordEmpty(){
        onView(withId(R.id.email))
            .check(matches(withText("")))
        onView(withId(R.id.password))
            .check(matches(withText("")))
    }

    @Test
    fun givenEmailIsEmpty_whenLogin_shouldShowEmptyEmailError(){
        //arrange
        //act
        onView(withId(R.id.password)).perform(typeText("@!56Abuhf"))
        onView(withId(R.id.login)).perform(click())
        //assert
        onView(withText("E-mail field is Empty!")).check(matches(isDisplayed()))
    }

    @Test
    fun givenPasswordIsEmpty_whenLogin_shouldShowPasswordEmailError(){
        //arrange
        //act
        onView(withId(R.id.email)).perform(typeText("daivid.v.leal@concrete.com.br"))
        onView(withId(R.id.login)).perform(click())
        //assert
        onView(withText("Password field is Empty!")).check(matches(isDisplayed()))
    }

    @Test
    fun givenPasswordIsInvalid_whenLogin_shouldShowPasswordIsInvalidError(){
        loginAct {
            typeText("daivid.v.leal@concrete.com.br", R.id.email)
            typeText("@!5Ab", R.id.password)
            click(R.id.login)
        }

        loginAssert {
            checkMessageShown("Password is Invalid!")
        }
    }

    @Test
    fun givenValidEmailAndPassword_whenLogin_shouldGoToHomeActivity(){
        loginArrange {
            mockHomeActivity()
        }

        loginAct {
            typeText("daivid.v.leal@concrete.com.br", R.id.email)
            typeText("@!56Ab654", R.id.password)
            click(R.id.login)
        }

        loginAssert {
            checkGoTo(HomeActivity::class.java.name)
        }
    }


}