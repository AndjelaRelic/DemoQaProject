package Pages;

import Base.BaseTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProfilePage extends BaseTest {

    public ProfilePage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "submit")
    public List<WebElement> buttons;

    @FindBy (id = "userName-value")
    public WebElement usernameFormLabel;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[3]/button")
    public WebElement logOutButton;
    @FindBy(css = ".text-left.button")
    public WebElement goToStoreButton;
    @FindBy(id = "delete-record-undefined")
    public WebElement trashCanIcon;
    @FindBy(css= ".text-right.button.di")
    public WebElement deleteAllBooks;
    @FindBy(id = "closeSmallModal-ok")
    public WebElement confirmDeletingBooks;
    @FindBy(id = "see-book-Git Pocket Guide")
    public WebElement gitPocketGuideBookInCollection;

    @FindBy(id = "see-book-Learning JavaScript Design Patterns")
    public WebElement learninJSBookInCollection;

    @FindBy(id = "see-book-Designing Evolvable Web APIs with ASP.NET")
    public WebElement designingEvolvableBookInCollection;

    @FindBy(id = "see-book-Speaking JavaScript")
    public WebElement speakingJavaScriptBookInCollection;

    @FindBy(id = "see-book-You Don't Know JS")
    public WebElement youDontKnowJSBookInCollection;

    @FindBy(id = "see-book-Programming JavaScript Applications")
    public WebElement programingJSBookInCollection;

    @FindBy(id = "see-book-Eloquent JavaScript, Second Edition")
    public WebElement eloquentJSBookInCollection;

    @FindBy(id = "see-book-Understanding ECMAScript 6")
    public WebElement understandingECMABookInCollection;


    //--------------------------------------

    public void clickOnDeleteAllBooks(){
        deleteAllBooks.click();
    }

    public void confirmDeletingBooks() {
        confirmDeletingBooks.click();
    }
    public void clickOnLogOut() {
        logOutButton.click();
    }
    public void clickOnGoToStoreButton() {
        goToStoreButton.click();
    }

    public void clickOnTrashCan(){
        trashCanIcon.click();
    }
//    public void deleteAllBooks(){
//        scrollIntoView(deleteAllBooks);
//        clickOnDeleteAllBooks();
//        confirmDeleteAllBooks();
//        wait.until(ExpectedConditions.alertIsPresent());
//        driver.switchTo().alert().accept();
//    }
}
