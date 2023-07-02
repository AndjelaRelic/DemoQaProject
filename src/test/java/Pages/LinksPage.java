package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinksPage extends BaseTest {

    public LinksPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "simpleLink")
    WebElement homeLink;

    @FindBy (id ="dynamicLink")
    WebElement homeBNKp9Link;

    @FindBy (id = "created")
    WebElement createdLink;

    @FindBy (id = "no-content")
    WebElement noContentLink;

    @FindBy(id = "linkResponse")
    public WebElement responseMessage;
    //--------------------------------

    public void clickOnHomeLink(){
        homeLink.click();
    }

    public void clickOnHomeBNKp9Link(){
        homeBNKp9Link.click();
    }

    public void clickOnCreatedLink(){
        createdLink.click();
    }

    public void clickOnNoContentLink(){
        noContentLink.click();
    }



}
