package com.example.skill_edu

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    var mActivityRule: ActivityTestRule<MainActivity?>? = ActivityTestRule(MainActivity::class.java)

    @Test
    fun checkIfButtonDisabledWhenEditTextEmpty() {
        onView(withId(R.id.edit_text)).perform(typeText("HelloWorld!"))
        closeSoftKeyboard()
        onView(withId(R.id.button_next)).check(matches((isEnabled())))
        onView(withId(R.id.button_next)).perform(click())
    }
}