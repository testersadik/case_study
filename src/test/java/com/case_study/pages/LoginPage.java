package com.case_study.pages;

import com.case_study.utilities.ConfigurationReader;
import com.case_study.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(name="email")
    public WebElement userName;

    @FindBy(xpath = "//*[@id='form']/div/div/div[1]/div[1]/form/p")
    public WebElement errorMessage;



    public void login() {
        userName.sendKeys(ConfigurationReader.get("username")+Keys.TAB+
                ConfigurationReader.get("password")+ Keys.ENTER);
    }
    public void loginAs(String username , String password) {
        userName.sendKeys(username+Keys.TAB+
                password+ Keys.ENTER);
    }



}
