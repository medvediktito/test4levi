package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by dmitry on 3/22/17.
 */
public class EditComputerPage {
    WebDriver driver;

    String newComputerName = "1st New computer";

    By ComputerNameTextField = By.id("name");
    By IntroducedDate = By.id("introduced");
    By DiscontinuedDate = By.id("discontinued");
    By CompanyDropdown = By.id("company");
    By SaveThisComputerButton = By.cssSelector("#main > form:nth-child(2) > div > input");
    By CancelButton = By.cssSelector("#main > form:nth-child(2) > div > a");
    By DeleteThisComputerButton = By.cssSelector("#main > form.topRight > input");

    public EditComputerPage(WebDriver driver){
        this.driver = driver;
    }

    public String getComputerName(){
        return driver.findElement(ComputerNameTextField).getAttribute("value");
    }
    public void saveThisComputerButtonClick(){
        driver.findElement(SaveThisComputerButton).click();
    }
    public void setNewComputerName(){
        driver.findElement(ComputerNameTextField).clear();
        driver.findElement(ComputerNameTextField).sendKeys(newComputerName);
    }
    public void deteteThisComputerButtonClick(){
        driver.findElement(DeleteThisComputerButton).click();
    }

}
