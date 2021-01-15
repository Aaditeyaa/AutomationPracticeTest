package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {

    public WebDriver driver;

    @FindBy(id = "email_create")
    private WebElement emailCreate;

    @FindBy (xpath = "//span[text()[normalize-space()='Create an account']]")
    private WebElement crteAccBtn;

    @FindBy(className = "page-heading")
    private WebElement authenticationLbl;

    @FindBy(xpath = "//div[@class='alert alert-danger']//li[1]")
    private WebElement alertMsgExstingUser;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //Entering Email Address
    public void enterEmailAddress(String email){
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.visibilityOf(emailCreate));
        emailCreate.sendKeys(email);
    }

    //Clicking on Create account button
    public void clickOnCreateAcctBtn(){
        crteAccBtn.click();
    }

    public void visibilityAuthnticationLbl(){
        new WebDriverWait(driver,50)
        .until(ExpectedConditions.visibilityOfElementLocated(By.className("page-heading")));
    }

    public void verifyExstngUsrAlertMsg() throws InterruptedException {

        new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOf(alertMsgExstingUser));
        Assert.assertEquals(alertMsgExstingUser.getText(),"An account using this email address has already been registered. Please enter a valid password or request a new one.");
    }



}
