package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SelectablePage extends BaseTest {

    public SelectablePage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "demo-tab-list")
    public WebElement listContainer;
    @FindBy(id = "demo-tab-grid")
    public WebElement gridContainer;
    @FindBy(css = ".mt-2.list-group-item.list-group-item-action")
    public List<WebElement> listItems;
    @FindBy(xpath = "//*[starts-with(@class, 'list-group-item')]")
    public List<WebElement> gridItems;

    //------------------

    public void clickOnList(){
        listContainer.click();
    }
    public void clickOnGrid(){gridContainer.click();
    }

    public WebElement selectListItems(String name) {
        for (WebElement listItem : listItems) {
            if (listItem.getText().equals(name)) {
                scrollIntoView(listItem);
                listItem.click();
                return listItem;
            }
        }
        return null;
    }

    public WebElement selectGridItems(String name) {
        for (WebElement gridItem : gridItems) {
            if (gridItem.getText().equals(name)) {
                scrollIntoView(gridItem);
                gridItem.click();
                return gridItem;
            }
        }
        return null;
    }


}
