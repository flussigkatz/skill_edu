package com.example.skill_edu

import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.any
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    val activitiScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    private fun inputDataInEditText(id: Int) : ViewAction {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return  allOf(isDisplayed(), isAssignableFrom(View::class.java), withId(R.id.edit_text))
            }

            override fun getDescription(): String {
                return "Input text in child view EditText with specified id."
            }

            override fun perform(uiController: UiController?, view: View?) {
            }
            }

        }

    @Test
    fun test() {
        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition<MyAdapter.MyViewHolder>(0, typeText("000")))
        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition<MyAdapter.MyViewHolder>(1, typeText("111")))
        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition<MyAdapter.MyViewHolder>(3, typeText("333")))


    }
}