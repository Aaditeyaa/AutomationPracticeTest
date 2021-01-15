    package pageObjects;

    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.FindBy;
    import org.openqa.selenium.support.PageFactory;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.Select;
    import org.openqa.selenium.support.ui.WebDriverWait;
    import org.testng.Assert;

    public class PersonalInformation {

        public WebDriver driver;

        @FindBy(xpath = "//h3[@class='page-subheading']")
        private WebElement persnalInfoLbl;

        @FindBy(xpath = "//label[@for='customer_firstname']")
        private WebElement firstNameLbl;

        @FindBy(id = "customer_firstname")
        private WebElement firstNameField;

        @FindBy(xpath = "//label[text()='Last name ']")
        private WebElement lastNameLbl;

        @FindBy(id = "customer_lastname")
        private WebElement lastNameField;

        @FindBy(xpath = "//label[text()='Email ']")
        private WebElement emailLbl;

        @FindBy(id = "email")
        private WebElement emailField;

        @FindBy(xpath = "//label[text()='Password ']")
        private WebElement passwordLbl;

        @FindBy (id = "passwd")
        private WebElement passwdField;

        @FindBy(xpath = "(//h3[@class='page-subheading'])[2]")
        private WebElement yourAddressLbl;

        @FindBy(xpath = "//p[@class='required form-group']//label")
        private WebElement firstNameLblInAddress;

        @FindBy(xpath = "//p[@class='required form-group']")
        private WebElement firstNamefieldInAddress;

        @FindBy(xpath = "//label[@for='lastname']")
        private WebElement lastNameLblInAddress;

        @FindBy(id = "lastname")
        private WebElement lastNamefieldInAddress;

        @FindBy(xpath = "//label[@for='company']")
        private WebElement companyLbl;

        @FindBy(id = "company")
        private WebElement companyField;

        @FindBy(xpath = "(//p[@class='required form-group']//label)[3]")
        private WebElement addressLbl;

        @FindBy(css = "input#address1")
        private WebElement addressField;

        @FindBy(xpath = "//p[@class='form-group is_customer_param']/following-sibling::p[1]")
        private WebElement cityField;

        @FindBy(xpath = "//label[@for='id_state']")
        private WebElement stateLbl;

        @FindBy(xpath = "//select[@id='id_state']")
        private WebElement stateField;

        @FindBy(css = "form#account-creation_form>div:nth-of-type(2)>p:nth-of-type(8)")
        private WebElement zipCodeField;

        @FindBy(xpath = "//label[@for='id_country']")
        private WebElement countryLbl;

        @FindBy(xpath = "//select[@id='id_country']")
        private WebElement countryField;

        @FindBy(css = "form#account-creation_form>div:nth-of-type(2)>p:nth-of-type(13)")
        private WebElement mobilePhoneField;

        @FindBy(id = "address_alias")
        private WebElement addressReference;

        //Constructor
        public PersonalInformation(WebDriver driver){
            this.driver = driver;
            PageFactory.initElements(driver, this);

        }

        //verify Personal Info Label
        public void verifyThePersnlInfoLbl(){

            Assert.assertTrue(persnalInfoLbl.isDisplayed());
        }


            //verifying the first name field
        public void verifyFirstName() throws InterruptedException {
            new WebDriverWait(driver,10)
                    .until(ExpectedConditions.visibilityOf(firstNameField));
            Assert.assertEquals(firstNameLbl.getText(),"First name *");
            Assert.assertTrue(firstNameField.isDisplayed());
        }

        // Verifying the Last name field
        public void verifyLastName(){
            Assert.assertEquals(lastNameLbl.getText(),"Last name *");
            Assert.assertTrue(lastNameField.isDisplayed());
        }


        // Verifying the Email field
        public void verifyEmail(){
            Assert.assertEquals(emailLbl.getText(),"Email *");
            Assert.assertTrue(emailField.isDisplayed());
        }


        // Verifying the password field
        public void verifyPassword(){
            Assert.assertEquals(passwordLbl.getText(),"Password *");
            Assert.assertTrue(passwdField.isDisplayed());
        }

        //Verifying all the fields included in the personal info section
        public void verifyYourPersonalInfoSection() throws InterruptedException {

            verifyThePersnlInfoLbl();
            verifyFirstName();
            verifyLastName();
            verifyEmail();
            verifyPassword();
        }

        public void verifyYorAdrsLbl(){

            Assert.assertEquals(yourAddressLbl.getText(),"YOUR ADDRESS");
        }

        //verifying the first name in Address section
        public void verifyFirstNameInAddress(){

            Assert.assertEquals(firstNameLblInAddress.getText(),"First name *");
            Assert.assertTrue(firstNamefieldInAddress.isDisplayed());
        }

        //verifying the last name in Address section
        public void verifyLastNamInAddress(){
            Assert.assertEquals(lastNameLblInAddress.getText(),"Last name *");
            Assert.assertTrue(lastNamefieldInAddress.isDisplayed());
        }

        //verify company field
        public void verifyCompany(){
            Assert.assertEquals(companyLbl.getText(),"Company");
            Assert.assertTrue(companyField.isDisplayed());
        }

        //verify address field
        public void verifyAddress(){
            Assert.assertEquals(addressLbl.getText(),"Address *");
            Assert.assertTrue(addressField.isDisplayed());
        }

        //verify city field
        public void verifyCity(){

            Assert.assertEquals(cityField.getText(),"City *");
        }


        //verifying the state dropdown field
        public void verifyStateField(){
            Assert.assertEquals(stateLbl.getText(),"State *");
            Select dropdown = new Select(stateField);
            dropdown.selectByIndex(2);
        }

        //Verifying the Zip code field
        public void verifyZipCodeField(){

            Assert.assertEquals(zipCodeField.getText(),"Zip/Postal Code *");
        }


        //verifying the country field
        public void verifyCountryField(){
            Assert.assertEquals(countryLbl.getText(),"Country *");
            Select dropdown = new Select(countryField);
            dropdown.selectByIndex(0);
        }

        //verifying the Mobile phone field
        public void verifyMobilePhoneField(){

            Assert.assertEquals(mobilePhoneField.getText(),"Mobile phone *");
        }


        //Verifying the Address reference filed
        public void verifyAddressReference(){
            Assert.assertEquals(addressReference.getText(),"Assign an address alias for future reference. *");
        }

        //This includes all the methods relating to the your address section
        public void verifyYourAddressSection(){
            verifyYorAdrsLbl();
            verifyFirstNameInAddress();
            verifyLastNamInAddress();
            verifyCompany();
            verifyAddress();
            verifyCity();
            verifyStateField();
            verifyCountryField();
            verifyMobilePhoneField();
            verifyAddressReference();

        }



    }
