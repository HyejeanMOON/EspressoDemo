package com.hyejeanmoon.espressodemo;

import androidx.test.espresso.Espresso;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;


@RunWith(AndroidJUnit4.class)
public class MainActivityUITest {

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkMainActivity() {

        Espresso.onView(withId(R.id.editText)).perform(typeText("hello"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.btnSend)).perform(click());
        Espresso.onView(withId(R.id.textViewInSecond)).check(matches(withText("hello")));

        String[] arrays = rule.getActivity().getResources().getStringArray(R.array.spinner);
        for (int i = 0; i < arrays.length; i++) {
            Espresso.onView(withId(R.id.spinner)).perform(click());
            Espresso.onData(is(arrays[i])).perform(click());
            Espresso.onView(withId(R.id.textViewInSecondTwo)).check(matches(withText(containsString(arrays[i]))));
        }
    }

}

