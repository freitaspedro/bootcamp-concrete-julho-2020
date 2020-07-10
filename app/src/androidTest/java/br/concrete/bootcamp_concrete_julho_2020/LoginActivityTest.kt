package br.concrete.bootcamp_concrete_julho_2020

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @get:Rule
    val loginActivityTest = ActivityTestRule(LoginActivity::class.java)

    @Test
    fun givenInitialState_shouldShowEmailAndPasswordEmpty(){
        Espresso.onView(ViewMatchers.withId(R.id.email))
            .check(matches(ViewMatchers.withText("")))
        Espresso.onView(ViewMatchers.withId(R.id.password))
            .check(matches(ViewMatchers.withText("")))
    }


}