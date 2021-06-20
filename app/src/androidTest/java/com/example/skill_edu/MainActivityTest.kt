package com.example.skill_edu


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        val materialCheckBox = onView(
            allOf(withId(R.id.check_box), withText("Item 1"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.recycler_view),
                        0),
                    2),
                isDisplayed()))
        materialCheckBox.perform(click())

        val materialCheckBox2 = onView(
            allOf(withId(R.id.check_box), withText("Item 3"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.recycler_view),
                        2),
                    2),
                isDisplayed()))
        materialCheckBox2.perform(click())

        val appCompatEditText = onView(
            allOf(withId(R.id.edit_text),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.recycler_view),
                        0),
                    1),
                isDisplayed()))
        appCompatEditText.perform(replaceText("123"), closeSoftKeyboard())

        val appCompatEditText2 = onView(
            allOf(withId(R.id.edit_text),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.recycler_view),
                        1),
                    1),
                isDisplayed()))
        appCompatEditText2.perform(typeText("321"), closeSoftKeyboard())
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
}
