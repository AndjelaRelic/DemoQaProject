package Tests;

import Base.BaseTest;
import Pages.HomepagePage;
import Pages.LoginPage;
import Pages.ProfilePage;
import Pages.SideBarPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    public HomepagePage homepagePage;
    public LoginPage loginPage;
    public SideBarPage sideBarPage;
    public ProfilePage profilePage;
    public String loginURL;


    @BeforeMethod
    public void pageSetUp() {
        homepagePage = new HomepagePage();
        loginPage = new LoginPage();
        sideBarPage = new SideBarPage();
        profilePage = new ProfilePage();
        loginURL = excelReader.getStringData("URL", 1, 1);
    }

    @Test(priority = 10)

    public void userCanLogInWithValidCredentials() throws InterruptedException {
        driver.manage().deleteAllCookies();
        homepagePage.clickOnCards("Book Store Application");
        Thread.sleep(2000);
        clickOnDropdownButton("Login");
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1, 1);
        loginPage.insertUsername(validUsername);
        loginPage.insertPassword(validPassword);
        loginPage.clickOnLoginButton();
        waitForVisibility(profilePage.usernameFormLabel);
        Assert.assertTrue(profilePage.usernameFormLabel.isDisplayed());
        Assert.assertEquals(profilePage.usernameFormLabel.getText(), validUsername);
        Assert.assertNotEquals(driver.getCurrentUrl(), loginURL);

    }

    @Test(priority = 20)

    public void userCannotLogInWithInvalidUsername() throws InterruptedException {
        driver.manage().deleteAllCookies();
        String validPassword = excelReader.getStringData("Login", 1, 1);
        homepagePage.clickOnCards("Book Store Application");
        Thread.sleep(2000);
        clickOnDropdownButton("Login");
        for (int i = 1; i < excelReader.getLastRow("Login"); i++) {
            Thread.sleep(2000);
            loginPage.insertUsername(excelReader.getStringData("Login", i, 2));
            loginPage.insertPassword(validPassword);
            loginPage.clickOnLoginButton();
            waitForVisibility(loginPage.messageInvalid);
            Assert.assertTrue(loginPage.messageInvalid.isDisplayed());
            Assert.assertEquals(loginPage.messageInvalid.getText(),"Invalid username or password!");
            Assert.assertEquals(driver.getCurrentUrl(), loginURL);
        }

    }

    @Test(priority = 30)

    public void userCannotLogInWithInvalidPassword() throws InterruptedException {
        driver.manage().deleteAllCookies();
        String validUsername = excelReader.getStringData("Login", 1, 0);
        homepagePage.clickOnCards("Book Store Application");
        Thread.sleep(2000);
        clickOnDropdownButton("Login");
        for (int i = 1; i < excelReader.getLastRow("Login"); i++) {
            Thread.sleep(2000);
            loginPage.insertUsername(validUsername);
            loginPage.insertPassword(excelReader.getStringData("Login", i, 3));
            loginPage.clickOnLoginButton();
            waitForVisibility(loginPage.messageInvalid);
            Assert.assertTrue(loginPage.messageInvalid.isDisplayed());
            Assert.assertEquals(loginPage.messageInvalid.getText(),"Invalid username or password!");
            Assert.assertEquals(driver.getCurrentUrl(), loginURL);
        }
    }

    @Test(priority = 40)

    public void userCanLogInWithValidCredentialsByClickingOnLogInButton() throws InterruptedException {
        driver.manage().deleteAllCookies();
        homepagePage.clickOnCards("Book Store Application");
        Thread.sleep(2000);
        loginPage.clickOnLoginButton();
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1, 1);
        loginPage.insertUsername(validUsername);
        loginPage.insertPassword(validPassword);
        loginPage.clickOnLoginButton();
        waitForVisibility(profilePage.usernameFormLabel);
        Assert.assertTrue(profilePage.usernameFormLabel.isDisplayed());
        Assert.assertEquals(profilePage.usernameFormLabel.getText(), validUsername);
        Assert.assertNotEquals(driver.getCurrentUrl(), loginURL);

    }



    @AfterMethod
    public void tearDown(){
//        driver.manage().deleteAllCookies();
//        driver.navigate().refresh();
    }
}
