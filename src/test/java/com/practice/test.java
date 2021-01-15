package com.practice;


import com.listener.AllureListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.*;
import org.testng.*;
import org.testng.annotations.*;
import pageObjects.LoginPage;
import pageObjects.MyStore;
import pageObjects.PersonalInformation;
import pageObjects.homePage;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


@Listeners(AllureListener.class)
public class test  {
    static WebDriver driver;
    homePage HOME_PAGE;
    LoginPage LOGIN_PAGE;
    PersonalInformation PERSONAL_INFORMATION ;
    MyStore MY_STORE;
    private URL pathFile = test.class.getResource("/files/");




    @Parameters(value = "browser")
    @BeforeMethod
    public void setup(String browser, ITestContext iTestContext) throws InterruptedException {

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        if (browser.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        if(browser.equalsIgnoreCase("mobile")){
           Map<String,String> mobileEmulation = new HashMap<>();

           mobileEmulation.put("deviceName","Moto G4");

           ChromeOptions chromeOptions = new ChromeOptions();
           chromeOptions.setExperimentalOption("mobileEmulation",mobileEmulation);
           WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);
        }

        this.setDriverToContext(iTestContext,driver);
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
        HOME_PAGE = new homePage(driver);
        LOGIN_PAGE = new LoginPage(driver);
        PERSONAL_INFORMATION = new PersonalInformation(driver);
        MY_STORE = new MyStore(driver);
        }


       @Test(priority = 0)
       @Description("Validating the fields in the Login Page")
       public void validateTestLoginPage() throws InterruptedException {

           HOME_PAGE.verifyLogoName();
           HOME_PAGE.clickOnSignInBtn();
           LOGIN_PAGE.enterEmailAddress("jhansi@test.com");
           LOGIN_PAGE.clickOnCreateAcctBtn();
           PERSONAL_INFORMATION.verifyYourPersonalInfoSection();
           PERSONAL_INFORMATION.verifyYourAddressSection();

       }


     /*  @Test(priority = 1)
       @Description("Validating the already registered email address")
       public void validateUserId() throws InterruptedException {
           HOME_PAGE.verifyLogoName();
           HOME_PAGE.clickOnSignInBtn();
           LOGIN_PAGE.visibilityAuthnticationLbl();
           LOGIN_PAGE.enterEmailAddress("aditya@test.com");
           LOGIN_PAGE.clickOnCreateAcctBtn();
           LOGIN_PAGE.verifyExstngUsrAlertMsg();
       }

        @Test(priority = 2)
        @Description("validating the number items after selecting the 'dresses' checkbox")
        public void validateCheckboxFunctionality() throws InterruptedException {
        HOME_PAGE.verifyLogoName();
        HOME_PAGE.verifyCategoriesSection();
        HOME_PAGE.validateWomenBtn();
        MY_STORE.chkboxVisibility();
        MY_STORE.chkDressBtn();
        MY_STORE.verifyNumberOfItems();

        }

        @Test(priority = 3)
        @Description("Validating the add to cart and removal from cart functionality")
        public void validateAddToCartFunctionality() throws InterruptedException {
        HOME_PAGE.verifyLogoName();
        HOME_PAGE.validateWomenBtn();
        MY_STORE.chkboxVisibility();
        MY_STORE.itemClick();
        MY_STORE.addToCartClk();
        MY_STORE.removeItem();
        MY_STORE.verifyRemovalOfItem();
        }

        @Test(priority = 4)
        @Description("Verifying the Chiffon dress in Best Sellers Section")
        public void verifyDressInBestSellers() throws InterruptedException {
        HOME_PAGE.verifyLogoName();
        HOME_PAGE.scrollDownandClkBestSellers();
        HOME_PAGE.verifyDressName();

        }*/


        public static void setDriverToContext(ITestContext iTestContext, WebDriver driver){
        iTestContext.setAttribute("WebDriver", driver);
        }

        public static WebDriver getDriverFromContext(ITestContext iTestContext){
        return(WebDriver)  iTestContext.getAttribute("WebDriver");
        }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }


    }


