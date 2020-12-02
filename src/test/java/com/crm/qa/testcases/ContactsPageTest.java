/*
*author: Prathima Ramagiri
*
 */
package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactsPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;
    String sheetName="contacts";

    public ContactsPageTest(){
        super();
    }
    @BeforeMethod
    public void setUp(){
        initialization();
        contactsPage=new ContactsPage();
        loginPage=new LoginPage();
        homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        contactsPage=homePage.clickOnContactsLink();
    }
    @Test(priority = 1)
    public void  verifyContactsPageLabelTest(){
        Assert.assertTrue(contactsPage.verifyContactsLabel(),"Contact label is missing on the page");

    }
    @Test(priority = 2)
    public void selectSingleContactsTest(){
        contactsPage.selectContactsByName("Tom Peter");
    }
    @Test(priority = 3)
    public void selectMultipleContactsTest(){
        contactsPage.selectContactsByName("Tom Peter");
        contactsPage.selectContactsByName("Mukta Sharma");
    }
    @DataProvider
    public Object[][] getCRMTestData(){
        Object data[][]=TestUtil.getTestData(sheetName);
        return data;

    }
    @Test(priority = 4, dataProvider = "getCRMTestData")
    public void validateCreateNewContact(String title, String firstName, String lastName, String company) throws InterruptedException {
        homePage.clickOnContactsLink();

       // contactsPage.createNewContact("Tom","Peter", "Google");
        contactsPage.createNewContact(firstName, lastName, company);

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
