package com.example.app.pages;


import com.example.app.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class LoginPage extends BasePage {

    public void waitForPageVisible() throws InterruptedException {
        waitForView(R.id.username, 10000);
    }

    public void typeUser(String user) {
        onView(withId(R.id.username)).perform(typeText(user));
    }

    public void typePassword(String password) {
        onView(withId(R.id.password)).perform(typeText(password));
    }

    public void tapLoginBtn() {
        onView(withId(R.id.login)).perform(click());
    }
}
