package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends TestBase {

    @FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[1]")
    WebElement contactsLabel;

    @FindBy(xpath = "//i[@class='edit icon']")
    WebElement newBtn;

    @FindBy(xpath ="//input[@name='first_name']")
    WebElement firstName;

    @FindBy(xpath="//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[1]/div[2]/div/div/input")  //input[@name='last_name']
    WebElement lastName;

    @FindBy(xpath = "//div[@name='company']//input[@class='search']")
    WebElement companyName;

    @FindBy(xpath="//i[@class='save icon']")
    WebElement saveBtn;

    public ContactsPage(){
        PageFactory.initElements(driver,this);
    }

    public boolean verifyContactsLabel(){
        return contactsLabel.isDisplayed();
    }
    public void selectContactsByName(String name){
        //the below click not working
        driver.findElement(By.xpath("//td[text()='"+name+"']//preceding-sibling::td//div//input[@name='id']")).click();
    }
    public void createNewContact(String ftName, String ltName,String comp) throws InterruptedException {
        //newBtn.click(); this was not loading page properly so I used the below url directly
        driver.get("https://ui.freecrm.com/contacts/new");

        firstName.sendKeys(ftName);
        lastName.sendKeys(ltName);
       // contactsLabel.sendKeys(comp);
        saveBtn.click();
    }

}
