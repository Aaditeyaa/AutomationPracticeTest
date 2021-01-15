package pageObjects;


    import org.openqa.selenium.JavascriptExecutor;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.interactions.Actions;
    import org.openqa.selenium.support.FindBy;
    import org.openqa.selenium.support.How;
    import org.openqa.selenium.support.PageFactory;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;
    import org.testng.Assert;

    public class MyStore {

        public WebDriver driver;

        @FindBy(xpath = "//div[@class='checker']//span")
        private WebElement topsChkbox;

        @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/span[1]")
        private WebElement drssChkbox;

        @FindBy(xpath = "//div[@class='product-count']")
        private WebElement productCount;

        @FindBy(how = How.LINK_TEXT, using="Faded Short Sleeve T-shirts")
        private WebElement itemView;

        @FindBy(xpath = "//span[contains(text(),'Add to cart')]")
        private WebElement addToCartBtn;

        @FindBy(xpath = "//header/div[3]/div[1]/div[1]/div[4]/div[1]/div[1]/span[1]")
        private WebElement crossBtn;

        @FindBy(xpath = "//div[@class='shopping_cart']//a")
        private WebElement cartBtn;

        @FindBy(xpath = "//span[@class='remove_link']//a[1]")
        private WebElement xBtn;

        @FindBy(className = "ajax_cart_no_product")
        private WebElement noProduct;


        //Constructor
        public MyStore(WebDriver driver){
            this.driver=driver;
            PageFactory.initElements(driver,this);
        }

        // verifying both the checkboxes
        public void chkboxVisibility() throws InterruptedException {
            new WebDriverWait(driver,10)
                    .until(ExpectedConditions.visibilityOf(topsChkbox));
            Assert.assertTrue(topsChkbox.isDisplayed());
            Assert.assertTrue(drssChkbox.isDisplayed());
        }

        //Checking dress button
        public void chkDressBtn() throws InterruptedException {
            drssChkbox.click();
            Thread.sleep(1000);
            Assert.assertTrue(drssChkbox.getAttribute("class").contains("checked"));
        }

        //verifying the number of items after selecting the dresses checkbox
        public void verifyNumberOfItems() throws InterruptedException {
            Thread.sleep(5000);
            JavascriptExecutor  js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,700)");
           Assert.assertFalse(!productCount.getText().contains("Showing 1 - 5 of 5 items"));
        }


        //Clicking on an Item
        public void itemClick(){
            itemView.click();
        }

        //Adding to the Cart
        public void addToCartClk() throws InterruptedException {
            new WebDriverWait(driver,10)
                    .until(ExpectedConditions.visibilityOf(addToCartBtn));
            addToCartBtn.click();
            new WebDriverWait(driver,10)
                    .until(ExpectedConditions.visibilityOf(crossBtn));
            crossBtn.click();
        }


        //Removing the items
        public void removeItem() throws InterruptedException {
            Actions act = new Actions(driver);
            act.moveToElement(cartBtn).build().perform();
            new WebDriverWait(driver,10)
                    .until(ExpectedConditions.visibilityOf(xBtn));
            xBtn.click();

        }

        //Verifying the removal in the cart section
        public void verifyRemovalOfItem() throws InterruptedException {
            new WebDriverWait(driver,10)
                    .until(ExpectedConditions.visibilityOf(noProduct));
            Assert.assertEquals(noProduct.getText(),"(empty)");
        }

    }
