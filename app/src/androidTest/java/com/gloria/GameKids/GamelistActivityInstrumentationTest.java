package com.gloria.GameKids;


import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.runner.RunWith;

import android.view.View;

import org.junit.Test;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.core.IsNot.not;

@RunWith(AndroidJUnit4.class)
public class GamelistActivityInstrumentationTest {
    @Rule
    public ActivityTestRule<play_list> activityTestRule =
            new ActivityTestRule<>(play_list.class);

    @Test
    public void listItemClickDisplaysToastWithCorrectGame() {
        View activityDecorView = activityTestRule.getActivity().getWindow().getDecorView();
        String gameName = "shapes and colors";
        onData(anything())
                .inAdapterView(withId(R.id.listView))
                .atPosition(0)
                .perform(click());
        onView(withText(gameName)).inRoot(withDecorView(not(activityDecorView)))
                .check(matches(withText(gameName)));
    }


}



