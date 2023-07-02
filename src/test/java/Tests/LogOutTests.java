package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogOutTests extends LoginTest{

    @BeforeMethod
    public void logOutSetUp() throws InterruptedException {
        userCanLogInWithValidCredentials();
    }

    @Test(priority = 10)
    public void userCanLogOutFromProfilePage() throws Exception {
        profilePage.clickOnLogOut();
        Assert.assertEquals(driver.getCurrentUrl(), loginURL);
        Assert.assertFalse(elementIsPresent(profilePage.logOutButton));
    }
}
