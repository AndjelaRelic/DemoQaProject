package Pages;

import Base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class HomepagePage extends BaseTest {

    public HomepagePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".card.mt-4.top-card")
    public List<WebElement> cards;

    //-----------------------------------------

    public void clickOnCards(String text) {
        for (WebElement card : cards) {
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("window.scrollBy(0,350)", "");
            if (card.getText().equals(text)) {
                card.click();
                break;
            }
        }
    }
}
