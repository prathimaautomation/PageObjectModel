package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;

    public HomePageTest(){
        super();
    }
    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage=new LoginPage();
        homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority=1)
    public void verifyHomePageTitleTest(){
        String homePageTitle=homePage.verifyHomePageTitle();
        Assert.assertEquals(homePageTitle,"Cogmento CRM", "Home page title not matched");
    }
    @Test(priority = 2)
    public void verifyUserNameTest(){
        Assert.assertTrue(homePage.verifyCorrectUserName());
    }
    @Test(priority = 3)
    public void verifyContactsLinkTest(){
        contactsPage=homePage.clickOnContactsLink();
        Assert.assertTrue(contactsPage.verifyContactsLabel());
    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
