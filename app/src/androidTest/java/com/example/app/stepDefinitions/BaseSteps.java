package com.example.app.stepDefinitions;

import android.support.test.rule.ActivityTestRule;

import com.example.app.MainActivity;
import com.example.app.util.ActivityFinisher;

import org.junit.Rule;

import cucumber.api.java.After;
import cucumber.api.java.Before;


public class BaseSteps {


    @Rule
    public static ActivityTestRule<?> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);


    @Before
    public void setUp() throws Exception {
        mActivityRule.launchActivity(null);
    }

    /**
     * All the clean up of application's data and state after each scenario must happen here
     */
    @After
    public void tearDown() throws Exception {
        ActivityFinisher.finishOpenActivities(); // Required for testing App with multiple activities
    }
}
