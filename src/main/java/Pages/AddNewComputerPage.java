package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by dmitry on 3/22/17.
 */
public class AddNewComputerPage {
    WebDriver driver;

    String computerName = "1st computer";
    String introducedDate = "2017-03-21";

    By ComputerNameTextField = By.id("name");
    By IntroducedDate = By.id("introduced");
    By DiscontinuedDate = By.id("discontinued");
    By CompanyDropdown = By.id("company");
    By CreateThisComputerButton = By.cssSelector("#main > form > div > input");
    By CancelButton = By.cssSelector("#main > form > div > a");

    public AddNewComputerPage(WebDriver driver){
        this.driver = driver;
    }

    public void typeComputerName(){
        driver.findElement(ComputerNameTextField).sendKeys(computerName);
    }
    public void createThisComputerButtonClick(){
        driver.findElement(CreateThisComputerButton).click();
    }

}
