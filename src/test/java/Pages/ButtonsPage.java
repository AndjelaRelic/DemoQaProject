package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ButtonsPage extends BaseTest {
    public ButtonsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "doubleClickBtn")
    public WebElement doubleClickButton;

    @FindBy(id = "rightClickBtn")
    public WebElement rightClickButton;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/button")
    public WebElement clickButton;

    @FindBy(id = "doubleClickMessage")
    public WebElement doubleClickMessage;

    @FindBy(id = "rightClickMessage")
    public WebElement rightClickMessage;

    @FindBy(id = "dynamicClickMessage")
    public WebElement dynamicClickMessage;

    //------------------------------------------------

    public void doubleClickOnButton() {
        doubleClick(doubleClickButton);
    }

    public void rightClickOnButton() {
        rightClick(rightClickButton);
    }

    public void clickOnClickButton() {
        clickButton.click();
    }
}

