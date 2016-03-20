package com.example.app.pages;

import android.support.test.espresso.ViewInteraction;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


public class BasePage {

    public static ViewInteraction waitForView(int viewId, int timeout) {
        // Calculate timeout
        final int interval = 500;
        int retries = 1;

        if (timeout > interval) {
            retries = (int) Math.ceil(timeout / interval);
        }

        while (retries > 0) {
            try {
                Thread.sleep(interval);
                return onView(withId(viewId)).check(matches(isDisplayed()));

            } catch (Exception e) {
                System.out.println("waiting for view");
                retries--;
            }
        }

        return null;
    }

    public static ViewInteraction waitForView(int viewId, Matcher matcher, int timeout) {
        // Calculate timeout
        final int interval = 500;
        int retries = 1;

        if (timeout > interval) {
            retries = (int) Math.ceil(timeout / interval);
        }

        while (retries > 0) {
            try {
                Thread.sleep(interval);
                return onView(withId(viewId)).check(matches(matcher));

            } catch (Exception e) {
                System.out.println("waiting for view");
                retries--;
            }
        }

        return null;
    }

    public <T extends BasePage> T is(Class<T> type) {
        if (type.isInstance(this)) {
            return type.cast(this);
        } else {
            throw new InvalidPageException("Invalid page type. Expected: " + type.getSimpleName() + ", but got: " + this.getClass().getSimpleName());
        }
    }

    public static class InvalidPageException extends RuntimeException {

        public InvalidPageException(final String message) {
            super(message);
        }
    }
}
