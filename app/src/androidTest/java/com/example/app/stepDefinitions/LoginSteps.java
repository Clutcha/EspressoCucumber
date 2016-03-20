package com.example.app.stepDefinitions;

import android.support.test.espresso.Espresso;
import com.example.app.pages.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class LoginSteps {

    public static final String TAG = LoginSteps.class.getSimpleName();

    private LoginPage mLoginPage;


    public LoginSteps() throws InterruptedException {
        mLoginPage = new LoginPage();
    }

    @Given("^I am on the Login Screen$")
    public void i_am_on_the_Login_Screen() throws InterruptedException {
        mLoginPage = new LoginPage();
        mLoginPage.waitForPageVisible();
    }

    @When("^I login with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_login_with_and(String user, String password) throws InterruptedException {
        mLoginPage.typeUser(user);
        Espresso.closeSoftKeyboard();
        mLoginPage.typePassword(password);
        Espresso.closeSoftKeyboard();
        mLoginPage.tapLoginBtn();
    }
}
