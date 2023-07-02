package Tests;

import Base.BaseTest;
import Pages.HomepagePage;
import Pages.ModalDialogPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ModalDialogTests extends BaseTest {

    public ModalDialogPage modalDialogPage;
    public HomepagePage homepagePage;

    @BeforeMethod
    public void pageSetUp(){
    modalDialogPage = new ModalDialogPage();
    homepagePage = new HomepagePage();
    homepagePage.clickOnCards("Alerts, Frame & Windows");
    clickOnDropdownButton("Modal Dialogs");
    }

    @Test(priority = 10)
    public void userCanOpenSmallModal(){
        waitForVisibility(modalDialogPage.smallModalButton);
        modalDialogPage.clickOnSmallModalButton();
        Assert.assertTrue(modalDialogPage.smallModal.isDisplayed());
    }

    @Test(priority = 20)
    public void userCanCloseSmallModal() throws Exception {
        waitForVisibility(modalDialogPage.smallModalButton);
        modalDialogPage.clickOnSmallModalButton();
        modalDialogPage.clickOnCloseSmallModalButton();
        Thread.sleep(2000);
        Assert.assertFalse(elementIsPresent(modalDialogPage.closeSmallModalButton));
        Assert.assertFalse(elementIsPresent(modalDialogPage.smallModal));
    }

    @Test(priority = 30)
    public void userCanOpenLargeModal(){
        waitForVisibility(modalDialogPage.largeModalButton);
        modalDialogPage.clickOnLargeModalButton();
        Assert.assertTrue(modalDialogPage.largeModal.isDisplayed());
    }

    @Test(priority = 40)
    public void userCanCloseLargeModal() throws Exception {
        waitForVisibility(modalDialogPage.largeModalButton);
        modalDialogPage.clickOnLargeModalButton();
        modalDialogPage.clickOnCloseLargeModalButton();
        Thread.sleep(2000);
        Assert.assertFalse(elementIsPresent(modalDialogPage.closeLargeModalButton));
        Assert.assertFalse(elementIsPresent(modalDialogPage.largeModal));
    }
}
