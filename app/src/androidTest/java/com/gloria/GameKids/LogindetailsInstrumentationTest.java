package com.gloria.GameKids;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.gloria.GameKids.ui.Register;

import org.junit.Rule;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class LogindetailsInstrumentationTest {
    @Rule
    public ActivityTestRule<Register> activityTestRule =
            new ActivityTestRule<>(Register.class);

    public void testLoginAttempt() {
        Espresso.onView(ViewMatchers.withId(R.id.textView)).perform(ViewActions.clearText()).perform(ViewActions.typeText("mwongeliglo15@gmail.com"));
        Espresso.onView(ViewMatchers.withId(R.id.textView2)).perform(ViewActions.clearText()).perform(ViewActions.typeText("invalidpassword"));

        Espresso.onView(ViewMatchers.withId(R.id.Games)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.Login))
                .check(ViewAssertions.matches(not(ViewMatchers.isDisplayed())));

    }

}
