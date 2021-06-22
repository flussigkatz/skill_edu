package com.example.skill_edu

import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.allOf
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
                return  allOf(withId(id))
            }

            override fun getDescription(): String {
                return "Input text in child view EditText with specified id."
            }

            override fun perform(uiController: UiController?, view: View?) {
//                onView(withId(id)).perform(typeText("000"))
//                typeText("444")

            }
            }

        }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }

    private fun viewById(viewAction: ViewAction) : ViewAction {
        scrollTo()
        return typeText("000")
    }

    @Test
    fun test() {
//        onView(allOf(withId(R.id.edit_text2), childAtPosition(withId(R.id.recycler_view), 1)))
//            .perform(RecyclerViewActions.actionOnItemAtPosition<MyAdapter.MyViewHolder>(1, inputDataInEditText(R.id.edit_text1)))
        onView( allOf(childAtPosition( childAtPosition( withId(R.id.recycler_view),0),2))).perform( typeText("222"))
//        onView(allOf(withId(R.id.edit_text2), childAtPosition(withId(R.id.recycler_view), 0))).perform(RecyclerViewActions.actionOnItemAtPosition<MyAdapter.MyViewHolder>(0, inputDataInEditText(R.id.edit_text1)))
//        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition<MyAdapter.MyViewHolder>(0, inputDataInEditText(R.id.edit_text)))
//        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition<MyAdapter.MyViewHolder>(0, inputDataInEditText(R.id.edit_text)))
//        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition<MyAdapter.MyViewHolder>(1, typeText("111")))
//        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition<MyAdapter.MyViewHolder>(0, inputDataInEditText(R.id.edit_text1)))
//        onView(allOf(withId(R.id.edit_text2), childAtPosition(withId(R.id.recycler_view), 0))).perform(typeText("666"))
//        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition<MyAdapter.MyViewHolder>(1, childAtPosition(1)))
//        onView(allOf(withId(R.id.edit_text), childAtPosition( childAtPosition( withId(R.id.recycler_view),0), 2), isDisplayed())).perform(typeText("321"), closeSoftKeyboard())
//        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.actionOnItem<MyAdapter.MyViewHolder>(withId(R.id.edit_text), typeText("111")))
    }


}