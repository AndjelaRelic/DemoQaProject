package Tests;

import Pages.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookStoreTests extends LoginTest{

    public BookStorePage bookStorePage;
    public AddedBookPage addedBookPage;
    public SideBarPage sideBarPage;
    public ProfilePage profilePage;

    @BeforeMethod
    public void bookStorePageSetUp() throws InterruptedException {
        bookStorePage = new BookStorePage();
        addedBookPage = new AddedBookPage();
        sideBarPage = new SideBarPage();
        profilePage = new ProfilePage();
        driver.manage().deleteAllCookies();
        userCanLogInWithValidCredentials();
        waitForVisibility(profilePage.goToStoreButton);
        waitForClickability(profilePage.goToStoreButton);
        profilePage.clickOnGoToStoreButton();
    }

    @Test(priority = 10)
    public void userCanAddOneBookToColection() throws InterruptedException {
        waitForVisibility(bookStorePage.gitPocketGuideBook);
        bookStorePage.clickOnGitBook();
        addedBookPage.clickOnAddToCollectionButton();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        sideBarPage.clickOnSubmenuButton("Profile");
        waitForVisibility(profilePage.gitPocketGuideBookInCollection);
        Assert.assertTrue(profilePage.gitPocketGuideBookInCollection.isDisplayed());
        deleteAllBooks();
    }

    @Test(priority = 20)
    public void userCanAddTwoBooksToColection() throws InterruptedException {
        waitForVisibility(bookStorePage.gitPocketGuideBook);
        bookStorePage.clickOnGitBook();
        addedBookPage.clickOnAddToCollectionButton();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        addedBookPage.clickOnBackToStoreButton();
        bookStorePage.clickOnLearningJavaBook();
        addedBookPage.clickOnAddToCollectionButton();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        sideBarPage.clickOnSubmenuButton("Profile");
        waitForVisibility(bookStorePage.gitPocketGuideBook);
        Assert.assertTrue(profilePage.gitPocketGuideBookInCollection.isDisplayed());
        Assert.assertTrue(profilePage.learninJSBookInCollection.isDisplayed());
        deleteAllBooks();
    }

    @Test(priority = 30)
    public void userCanRemoveBookByClickingOnTrashCan() throws Exception {
        waitForVisibility(bookStorePage.gitPocketGuideBook);
        bookStorePage.clickOnGitBook();
        addedBookPage.clickOnAddToCollectionButton();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        sideBarPage.clickOnSubmenuButton("Profile");
        waitForVisibility(profilePage.gitPocketGuideBookInCollection);
        profilePage.clickOnTrashCan();
        profilePage.confirmDeletingBooks();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        Assert.assertFalse(elementIsPresent(profilePage.gitPocketGuideBookInCollection));
        deleteAllBooks();
    }

    public void deleteAllBooks(){
        scrollIntoView(profilePage.deleteAllBooks);
        profilePage.clickOnDeleteAllBooks();
        profilePage.confirmDeletingBooks();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

}
