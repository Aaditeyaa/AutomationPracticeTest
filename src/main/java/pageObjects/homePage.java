    package pageObjects;


    import org.openqa.selenium.By;
    import org.openqa.selenium.JavascriptExecutor;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.interactions.Actions;
    import org.openqa.selenium.support.FindBy;
    import org.openqa.selenium.support.PageFactory;
    import org.testng.Assert;

        public class homePage {

            public WebDriver driver ;

            @FindBy(xpath = "//img[@class='logo img-responsive']")
             WebElement logoName;

            @FindBy(className = "login")
             WebElement signInBtn;

            @FindBy(xpath = "//a[@class='sf-with-ul']")
            private WebElement womenBtn;

            @FindBy(xpath = "//ul[contains(@class,'sf-menu clearfix')]")
            private WebElement categoriesSection;

            @FindBy(xpath = "//div[contains(text(),'Categories')]")
            private WebElement categoriesExpand;

            @FindBy(linkText = "Printed Chiffon Dress")
            private WebElement dressName;

            @FindBy(className = "blockbestsellers")
            private WebElement bestSellersOption;

            @FindBy(css = "body.index.hide-left-column.hide-right-column.lang_en:nth-child(2) div.columns-container div.container div.row:nth-child(2) div.center_column.col-xs-12.col-sm-12 ul.nav.nav-tabs.clearfix > li.active:nth-child(2)")
            private WebElement bestSellersState;


            //Constructor
            public homePage(WebDriver driver) {
                // TODO Auto-generated constructor stub
                this.driver=driver;
                PageFactory.initElements(driver,this);

            }

            //verifying logo name
            public void verifyLogoName()  {
               Assert.assertTrue(logoName.isDisplayed());
            }


            //To click on Sign In Button
            public void clickOnSignInBtn(){
                signInBtn.click();
            }

            //Verifying thr Categories section
            public void verifyCategoriesSection(){
                Assert.assertTrue(categoriesSection.getText().contains("WOMEN"));
                Assert.assertTrue(categoriesSection.getText().contains("DRESSES"));
                Assert.assertTrue(categoriesSection.getText().contains("T-SHIRTS"));
            }

            //clicking on the Women Btn
            public void validateWomenBtn() throws InterruptedException {
                Thread.sleep(2000);
               /* boolean womenSection = driver.findElement(By.xpath("//a[@class='sf-with-ul']")).isDisplayed();

                if(womenSection = false){*/
                  //  categoriesExpand.click();
                    Thread.sleep(2000);
               // }
                womenBtn.click();
            }

            //Scrolling down and selecting the best sellers section
            public void scrollDownandClkBestSellers() throws InterruptedException {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,700)");
                Thread.sleep(2000);
                bestSellersOption.click();
                Thread.sleep(2000);
                Assert.assertTrue(bestSellersState.getAttribute("class").contains("active"));
            }

            //verifying the dress name
            public void verifyDressName() throws InterruptedException {
                Actions act = new Actions(driver);
               // act.moveToElement(dressName).build().perform();
                Assert.assertEquals(dressName.getText(),"Printed Chiffon Dress");
                Thread.sleep(1000);
            }

    }
