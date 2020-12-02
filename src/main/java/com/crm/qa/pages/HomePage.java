package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    //Page Factory or Object Repository
    @FindBy(xpath = "//span[contains(text(),'free crma')]")
    WebElement userNameLabel;

    @FindBy(xpath = "//span[contains(text(),'Contacts')]")
    WebElement contactsLink;

    @FindBy(xpath = "//a[@href=\"/contacts/new\"]/button")
    WebElement newContactLink;

    @FindBy(xpath = "//span[contains(text(),'Deals')]")
    WebElement dealsLink;

    @FindBy(xpath = "//span[contains(text(),'Calendar')]")
    WebElement calendarLink;

    //Initializing the Page Objects:
    public HomePage(){
        PageFactory.initElements(driver,this);
    }
    public String verifyHomePageTitle(){
        return driver.getTitle();
    }
    public boolean verifyCorrectUserName(){
        return userNameLabel.isDisplayed();
    }
    public ContactsPage clickOnContactsLink(){
        contactsLink.click();
        return new ContactsPage();
    }
    public DealsPage clickOnDealsLink(){
        dealsLink.click();
        return new DealsPage();
    }
    public CalendarPage clickOnCalendarLink(){
        calendarLink.click();
        return new CalendarPage();
    }
    public void clickOnNewContactLink(){
        //Actions action=new Actions(driver); it was on a frame in old FREECRM site
        contactsLink.click();
        newContactLink.click();
    }
}
