package com.example.skill_edu

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.any
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    val activitiScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    private fun clickItemWithId(id: Int): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return any(View::class.java)
            }

            override fun getDescription(): String {
                return "Click on a child view with specified id."
            }

            override fun perform(uiController: UiController?, view: View?) {
                val v = view?.findViewById(id) as View
                v.performClick()
            }

        }
    }

    @Test
    fun test() {
//        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition<MyAdapter.MyViewHolder>(19, scrollTo()))

        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition<MyAdapter.MyViewHolder>(19, clickItemWithId(R.id.check_box)))
        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition<MyAdapter.MyViewHolder>(15, clickItemWithId(R.id.check_box)))
        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition<MyAdapter.MyViewHolder>(16, clickItemWithId(R.id.check_box)))

    }
}