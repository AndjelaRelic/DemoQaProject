package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccordianWidgetPage extends BaseTest {

    public AccordianWidgetPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy (className = "card-header")
    public List<WebElement> headings;

    @FindBy(css = ".collapse.show")
    public WebElement collapsedText;

    //--------------------------------------

    public void clickOnHeading(String name) {
        for (WebElement heading : headings) {
            if (heading.getText().equals(name)) {
                scrollIntoView(heading);
                heading.click();
                break;
            }
        }
    }
}
