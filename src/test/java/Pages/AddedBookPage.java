package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddedBookPage extends BaseTest {

    public AddedBookPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".text-right.fullButton")
    public WebElement addToCollectionButton;

    @FindBy(css = ".text-left.fullButton")
    public WebElement backToStoreButton;

    @FindBy(css = ".text-right.col-md-4 col-sm-12")
    WebElement logOutButton;


    //------------------------------------


    public void clickOnAddToCollectionButton() {
        addToCollectionButton.click();
    }

    public void clickOnBackToStoreButton(){
        backToStoreButton.click();
    }

    public void clickOnLogOutButton(){
        logOutButton.click();
    }
}
