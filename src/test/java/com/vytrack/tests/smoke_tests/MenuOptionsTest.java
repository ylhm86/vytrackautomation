package com.vytrack.tests.smoke_tests;




import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;


public class MenuOptionsTest {


    /*

    1. Login to Vytrack as a driver

2. Navigate to FleetàVehicles, verify page title Car - Entities - System - Car - Entities - System, page name All Cars (updated)

3. Navigate to Customers à Accounts, verify page title Accounts - Customers, verify page name Accounts

4. Navigate to CustomersàContacts, verify page title Contacts - Customers, verify page name Contacts (updated)

5. Navigate to ActivitiesàCalendar Events, verify page title Calendar Events - Activities, page name Calendar Events


TEST CASE: Menu options, store manager

1. Login to Vytrack as a store manager

2. Navigate to Dashboards à Dashboard, verify page title Dashboard - Dashboards, verify page name Dashboard
3. Navigate to FleetàVehicles, verify page title All - Car - Entities - System - Car - Entities - System, page name All Cars (updated)
4. Navigate to CustomersàAccounts, verify page title All - Accounts – Customers, verify page name All Accounts(updated)
5. Navigate to CustomersàContacts, verify page title All - Contacts - Customers, verify page name All Contacts (updated)
6. Navigate to Sales à Opportunities, verify page title Open Opportunities - Opportunities - Sales, verify page name Open Opportunities
7. Navigate to ActivitiesàCalls verify page title All - Calls - Activities, page name All Calls (updated)
8. Navigate to ActivitiesàCalendar Events, verify page title Calendar Events - Activities, page name All Calendar Events (updated)
     */


    WebDriver driver;



    @BeforeClass
    public void beforeClass(){


        WebDriverManager.chromedriver().setup();


        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }

    @BeforeMethod
    public void setUp(){

        driver.get("http://qa2.vytrack.com/user/login");

        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("user168");

        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");

        WebElement login = driver.findElement(By.id("_submit"));
        login.click();
    }
    @Test
    public void Fleet(){

        // 2. Navigate to Fleet ==>> Vehicles,
        // verify page title Car - Entities - System - Car - Entities - System, page name All Cars (updated)

        String expectedTitle = "Entities - System - Car - Entities - System";
        String expectedPage ="All Cars";
        WebElement fleet = driver.findElement(By.xpath("dropdown-menu-wrapper dropdown-menu-wrapper__placeholder"));
        fleet.click();
        WebElement vehicles = driver.findElement(By.xpath("title title-level-1"));
        vehicles.click();


        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title Test Passed");
        }else{
            System.out.println("Title Test Failed");
        }

        String actualPage = driver.findElement(By.tagName("title")).getText();;
        if (actualPage.equals(expectedPage)) {
            System.out.println("Page Test Passed");
        }else{
            System.out.println("Page Test Failed");
        }

    }



    @Test
    public void CustomerAccounts(){



    }
    @Test
    public void CustomerContacts(){


    }
    @Test
    public void Activities(){


    }

    @Test
    public void MenuOption(){

    }
}
