package com.case_study.step_definitions;

import com.case_study.pages.DashboardPage;
import com.case_study.utilities.BrowserUtils;
import com.case_study.utilities.Driver;
import com.case_study.utilities.Pages;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.openqa.selenium.By;

public class DashboardStepDefs {
    Pages page = new Pages();
    @When("Navigate to Products page and search for {string}")
    public void navigate_to_Products_page_and_search_for(String productName) throws InterruptedException {
        Driver.get().get("https://automationexercise.com/products");
        page.dashboardPage().searchBox.sendKeys(productName);
        page.dashboardPage().search_product.click();
        BrowserUtils.waitFor(1);
    }

    @Then("Verify that the prices is RS {int}")
    public void verify_that_the_prices_is_RS(@NotNull Integer price) throws InterruptedException {
        String page_source = Driver.get().getPageSource();
        Assert.assertTrue(page_source.contains(price.toString()));
        BrowserUtils.waitFor(1);
    }

    @When("Add the {string} to the basket")
    public void add_the_to_the_basket(String productName) throws InterruptedException {
        BrowserUtils.clickWithJS(page.dashboardPage().add_to_cart);
        page.dashboardPage().continue_shopping.click();
        BrowserUtils.waitFor(1);
    }

    @When("Search and Add the {string} to the basket")
    public void search_and_Add_the_to_the_basket(String productName) throws InterruptedException {
        Driver.get().get("https://automationexercise.com/products");
        page.dashboardPage().searchBox.sendKeys(productName);
        page.dashboardPage().search_product.click();
        BrowserUtils.clickWithJS(Driver.get().findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a")));
        BrowserUtils.waitFor(1);
    }

    @When("Process to basket and to checkout")
    public void process_to_basket_and_to_checkout() throws InterruptedException {
        Driver.get().get("https://automationexercise.com/view_cart");
        page.dashboardPage().proceed_to_checkout.click();
        BrowserUtils.waitFor(1);
    }

    @Then("Verify that the Green Side Placket Detail T-shirt is in checkout \\(Assert)")
    public void verify_that_the_Green_Side_Placket_Detail_T_shirt_is_in_checkout_Assert() {
        try {
            page.dashboardPage().green_side.isDisplayed();
        }
        catch (Exception e) {
            Assert.assertTrue(Boolean.FALSE);
            System.out.println("Green Side Placket Detail T-shirt is not in checkout.");
        }
    }

    @Then("Verify that the Fancy Green Top is in checkout \\(Assert)")
    public void verify_that_the_Fancy_Green_Top_is_in_checkout_Assert() {
        try {
            page.dashboardPage().fancy_green.isDisplayed();
        }
        catch (Exception e) {
            Assert.assertTrue(Boolean.FALSE);
            System.out.println(" the Fancy Green Top is not in checkout.");
        }
    }

    @When("Select Place Order and enter in the following banking information: Name on card: {string} , Card Number: {int}, Cvc: {int}, Expiration: {int}, Year: {int}")
    public void select_Place_Order_and_enter_in_the_following_banking_information_Name_on_card_Card_Number_Cvc_Expiration_Year(String name, Integer cardNumber, Integer cvc, Integer month, Integer year) {
        page.dashboardPage().place_order.click();
        page.dashboardPage().name_on_card.sendKeys(name);
        page.dashboardPage().card_number.sendKeys(cardNumber.toString());
        page.dashboardPage().cvc.sendKeys(cvc.toString());
        page.dashboardPage().expiry_month.sendKeys(month.toString());
        page.dashboardPage().expiry_year.sendKeys(year.toString());
    }

    @When("Pay and confirm order")
    public void pay_and_confirm_order() {
        page.dashboardPage().pay_and_confirm_order.click();
    }
    @Then("Verify that the order has been placed \\(Assert)")
    public void verify_that_the_order_has_been_placed_Assert() {
        Assert.assertEquals("Congratulations! Your order has been confirmed!",
                page.dashboardPage().order_placed.getText());
    }
}
