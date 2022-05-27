package com.case_study.pages;

import com.case_study.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    public DashboardPage(){
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(id="search_product")
    public WebElement searchBox;
    @FindBy(id="submit_search")
    public WebElement search_product;
    @FindBy(xpath="/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a")
    public WebElement add_to_cart;
    @FindBy(xpath="//*[@id='cartModal']/div/div/div[3]/button")
    public WebElement continue_shopping;
    @FindBy(xpath="//*[@id='do_action']/div[1]/div/div/a")
    public WebElement proceed_to_checkout;
    @FindBy(partialLinkText="Green Side Placket Detail T-Shirt")
    public WebElement green_side;
    @FindBy(partialLinkText="Fancy Green Top")
    public WebElement fancy_green;
    @FindBy(partialLinkText="Place Order")
    public WebElement place_order;
    @FindBy(name="name_on_card")
    public WebElement name_on_card;
    @FindBy(name="card_number")
    public WebElement card_number;
    @FindBy(name="cvc")
    public WebElement cvc;
    @FindBy(name="expiry_month")
    public WebElement expiry_month;
    @FindBy(name="expiry_year")
    public WebElement expiry_year;
    @FindBy(id="submit")
    public WebElement pay_and_confirm_order;
    @FindBy(xpath="//*[@id='form']/div/div/div/p")
    public WebElement order_placed;
}
