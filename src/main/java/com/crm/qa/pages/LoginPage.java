package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    //Page Factory - OR
    @FindBy(name="email")
    WebElement username;

    @FindBy(name="password")
    WebElement password;

    @FindBy(xpath = "//a[@href='https://ui.freecrm.com']//span[text()='Log In']")
    WebElement signInBtn;

    @FindBy(xpath = "//*[@id=\"ui\"]/div/div/form/div/div[3]")
    WebElement loginBtn;

    @FindBy(xpath = "//a[@title='register on freecrm.com']")
    WebElement signUpBtn;

    @FindBy(xpath="//a[@title='free crm home']")
    WebElement crmLogo;

    //Initializing the page objects
    public LoginPage(){
        PageFactory.initElements(driver, this );
    }

    //Actions:
    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    public boolean validateCRMimage(){
        return crmLogo.isDisplayed();
    }

    public HomePage login(String un, String pwd){
        signInBtn.click();
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn.click();
        return new HomePage();
    }


}
