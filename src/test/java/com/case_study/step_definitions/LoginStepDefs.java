package com.case_study.step_definitions;

import com.case_study.utilities.ConfigurationReader;
import com.case_study.utilities.Driver;
import com.case_study.utilities.Pages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {
    Pages page = new Pages();
    @Given("The	user should be in the login page")
    public void the_user_should_be_in_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("The user enters a valid credentials")
    public void the_user_enters_a_valid_credentials() {
        page.loginPage().login();
    }

    @Then("Verify that the user is successfully logged in")
    public void Verify_that_the_user_is_successfully_logged_in() {
        Assert.assertEquals("Automation Exercise",Driver.get().getTitle());
    }

    @When("The user enters a following invalid {string} and {string}")
    public void the_user_enters_a_following_invalid_and(String username, String password) {
         page.loginPage().loginAs(username,password);

    }

    @Then("Error message should be displayed")
    public void error_message_should_be_displayed() {
        try {
            Assert.assertEquals("Your email or password is incorrect!",page.loginPage().errorMessage.getText());
        }
        catch (Exception e) {
            Assert.assertTrue(Boolean.FALSE);
            System.out.println("Error message is not displayed.");
        }
    }

}
