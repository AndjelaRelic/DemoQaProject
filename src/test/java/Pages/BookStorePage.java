package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookStorePage extends BaseTest {

    public BookStorePage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "see-book-Git Pocket Guide")
    public WebElement gitPocketGuideBook;

    @FindBy(id = "see-book-Learning JavaScript Design Patterns")
    public WebElement learninJavaScriptBook;

    @FindBy(id = "see-book-Designing Evolvable Web APIs with ASP.NET")
    public WebElement designingEvolvableBook;

    @FindBy(id = "see-book-Speaking JavaScript")
    public WebElement speakingJavaScriptBook;

    @FindBy(id = "see-book-You Don't Know JS")
    public WebElement youDontKnowJSBook;

    @FindBy(id = "see-book-Programming JavaScript Applications")
    public WebElement programingJSBook;

    @FindBy(id = "see-book-Eloquent JavaScript, Second Edition")
    public WebElement eloquentJSBook;

    @FindBy(id = "see-book-Understanding ECMAScript 6")
    public WebElement understandingECMABook;

    @FindBy(id = "login")
    public WebElement loginButton;

    //------------------------------------

    public void clickOnLoginButton(){
        loginButton.click();
    }

    public void clickOnGitBook(){
        gitPocketGuideBook.click();

    }

    public void clickOnLearningJavaBook() {
        learninJavaScriptBook.click();
    }
}
