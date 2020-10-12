package com.gloria.gaming;

import android.content.Intent;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowActivity;

import static junit.framework.TestCase.assertTrue;

@RunWith(RobolectricTestRunner.class)

public class LoginActivityTest {
    private Login activity;

    @Before
    public void setup(){
        activity = Robolectric.setupActivity(Login.class);
    }

    @Test
    public void secondActivityStarted(){
        activity.findViewById(R.id.Signup).performClick();
        Intent expectedIntent = new Intent(activity, signup_details.class);
        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }
}
