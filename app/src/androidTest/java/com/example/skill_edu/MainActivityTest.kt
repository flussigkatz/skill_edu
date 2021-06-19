package com.example.skill_edu

import android.view.View
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
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    val activitiScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    private fun clickItemWithId(id: Int): ViewAction {
        //Создаем анонимный класс, реализующий интерфейс ViewAction
        return object : ViewAction {
            //Здесь мы можем установить какие-либо ограничения для проверки с помощью Matcher
            //например, чтобы View был виден на экране
            override fun getConstraints(): Matcher<View>? {
                return any(View::class.java)
            }
            //В этом методе мы возвращаем описание действия, оно должно быть лаконичным
            override fun getDescription(): String {
                return "Click on a child view with specified id."
            }
            //В этом методе совершаем действие над View
            override fun perform(uiController: UiController, view: View) {
                val v = view.findViewById<View>(id) as View
                v.performClick()
            }
        }
    }



    private fun inputDataInEditText(id: Int) : ViewAction {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return  allOf(isDisplayed(), isAssignableFrom(View::class.java))
            }

            override fun getDescription(): String {
                return "Input text in child view EditText with specified id."
            }

            override fun perform(uiController: UiController?, view: View?) {
                val v = view?.findViewById(id) as View
                onView(withId(id)).perform(typeText("Hello World!"))
            }

        }
    }

    @Test
    fun test() {
        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition<MyAdapter.MyViewHolder>(1, clickItemWithId(R.id.check_box)))
        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition<MyAdapter.MyViewHolder>(19, clickItemWithId(R.id.check_box)))
        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition<MyAdapter.MyViewHolder>(0, clickItemWithId(R.id.check_box)))
        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition<MyAdapter.MyViewHolder>(0, inputDataInEditText(R.id.edit_text)))


    }
}