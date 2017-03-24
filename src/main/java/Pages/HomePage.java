package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by dmitry on 3/22/17.
 */
public class HomePage {
    WebDriver driver;

    String computerName = "1st computer";
    String newComputerName = "1st New computer";

    By AddANewComputerButton = By.id("add");
    By AlertMessage = By.cssSelector("#main > div.alert-message.warning");
    By SearchBox = By.id("searchbox");
    By FilterByNameButton = By.id("searchsubmit");
    By ComputerNameLink = By.linkText(computerName);
    By NewComputerNameLink = By.linkText(newComputerName);

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void addANewComputerButtonClick(){
        driver.findElement(AddANewComputerButton).click();
    }
    public String getAlertMessage(){
        return driver.findElement(AlertMessage).getText();
    }
    public void searchForComputer(){
        driver.findElement(SearchBox).clear();
        driver.findElement(SearchBox).sendKeys(computerName);
    }
    public void searchForNewComputer(){
        driver.findElement(SearchBox).clear();
        driver.findElement(SearchBox).sendKeys(newComputerName);
    }
    public void filterByNameButtonClick(){
        driver.findElement(FilterByNameButton).click();
    }
    public void computerNameLinkClick(){
        driver.findElement(ComputerNameLink).click();
    }
    public void newComputerNameLinkClick(){
        driver.findElement(NewComputerNameLink).click();
    }

}
