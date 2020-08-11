package br.concrete.bootcamp_concrete_julho_2020

import android.app.Activity
import android.app.Instrumentation
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId

fun LoginActivityTest.mockHomeActivity(func: LoginArrange.() -> Unit): LoginAct {
    LoginArrange().apply {
        func()
    }
    return LoginAct()
}

class LoginArrange{

    fun mockGoToHomeActivity(){
        Intents.intending(hasComponent(HomeActivity::class.java.name))
            .respondWith(Instrumentation.ActivityResult(Activity.RESULT_CANCELED, null))
    }

}

class LoginAct {

    infix fun act(func: LoginAct.() -> Unit): LoginAssert{
        return LoginAssert().apply {
            func()
        }
    }

    fun typeText(text: String, id: Int) {
        Espresso.onView(ViewMatchers.withId(id))
            .perform(ViewActions.typeText(text))
    }

    fun click(id: Int) {
        Espresso.onView(withId(id)).perform(ViewActions.click())
    }

}

class LoginAssert {

    infix fun assert(func: LoginAssert.() -> Unit){
        func()
    }

    fun checkMessageShown(message: String) {
        Espresso.onView(ViewMatchers.withText(message))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    fun checkGoTo(activityName: String) {
        Intents.intended(hasComponent(activityName))
    }

}