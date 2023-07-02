package Tests;

import Base.BaseTest;
import Pages.AlertsPage;
import Pages.HomepagePage;
import Pages.SideBarPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTests extends BaseTest {

    public HomepagePage homepagePage;
    public SideBarPage sideBarPage;
    public AlertsPage alertsPage;

    @BeforeMethod
    public void pageSetUp(){
        homepagePage = new HomepagePage();
        sideBarPage = new SideBarPage();
        alertsPage = new AlertsPage();
        driver.get(homeURL);
        homepagePage.clickOnCards("Alerts, Frame & Windows");
        clickOnDropdownButton("Alerts");
    }

    @Test (priority = 10)
    public void alertButtonOpensAlert() throws Exception {
        alertsPage.clickOnAlertButton();
        Assert.assertTrue(alertIsPresent());
        Assert.assertEquals(driver.switchTo().alert().getText(), "You clicked a button");
    }

    @Test (priority = 20)
    public void timeAllertButtonOpensAlert() throws Exception {
        alertsPage.clickOnTimerAlertButton();
        wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue(alertIsPresent());
        Assert.assertEquals(driver.switchTo().alert().getText(), "This alert appeared after 5 seconds");
    }

    @Test (priority = 30)
    public void confirmAllertButtonOpensAlert() throws Exception {
        alertsPage.clickOnConfirmButton();
        Assert.assertTrue(alertIsPresent());
        Assert.assertEquals(driver.switchTo().alert().getText(), "Do you confirm action?");
    }

    @Test (priority = 40)
    public void promptAllertButtonOpensAlert() throws Exception {
        alertsPage.clickOnPromptButton();
        Assert.assertTrue(alertIsPresent());
        Assert.assertEquals(driver.switchTo().alert().getText(), "Please enter your name");
    }
}
