package org.sairaa.mvpapplicationtest;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sairaa.mvpapplicationtest.notes.NotesActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class ButtonClickResponseTest {
    @Rule
    public ActivityTestRule<NotesActivity> notesActivityActivityTestRule =
            new ActivityTestRule<>(NotesActivity.class);

    @Test
    public void testAddButton(){
        //find the view
        //perform operation
        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.text_view)).check(matches(withText("hello")));

    }
}
