package TestCases;

import Pages.AddNewComputerPage;
import Pages.EditComputerPage;
import Pages.HomePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by dmitry on 3/22/17.
 */
public class CRUD {

    WebDriver driver;

    @Before
    public void connect(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
        driver = new ChromeDriver();
    }
    @After
    public void close(){
        driver.close();
    }

    @Test
    public void verifyConnectionToCDBWebPage(){
        driver.get("http://computer-database.herokuapp.com/computers");
        Assert.assertEquals("Computers database", driver.getTitle());
    }

    @Test
    public void addNewComputerTest(){
        driver.get("http://computer-database.herokuapp.com/computers");
        HomePage homePage = new HomePage(driver);
        homePage.addANewComputerButtonClick();
        AddNewComputerPage addNewComputerPage = new AddNewComputerPage(driver);
        addNewComputerPage.typeComputerName();
        addNewComputerPage.createThisComputerButtonClick();
        Assert.assertEquals("Done! Computer 1st computer has been created", homePage.getAlertMessage());
    }

    @Test
    public void viewComputerInfoTest(){
        driver.get("http://computer-database.herokuapp.com/computers");
        HomePage homePage = new HomePage(driver);
        homePage.searchForComputer();
        homePage.filterByNameButtonClick();
        homePage.computerNameLinkClick();
        EditComputerPage editComputerPage = new EditComputerPage(driver);
        Assert.assertEquals("1st computer" ,editComputerPage.getComputerName());
    }

    @Test
    public void editComputerInfoTest(){
        driver.get("http://computer-database.herokuapp.com/computers");
        HomePage homePage = new HomePage(driver);
        homePage.searchForComputer();
        homePage.filterByNameButtonClick();
        homePage.computerNameLinkClick();
        EditComputerPage editComputerPage = new EditComputerPage(driver);
        editComputerPage.setNewComputerName();
        editComputerPage.saveThisComputerButtonClick();
        Assert.assertEquals("Done! Computer 1st New computer has been updated" ,homePage.getAlertMessage());
    }

    @Test
    public void deleteComputerInfoTest() {
        driver.get("http://computer-database.herokuapp.com/computers");
        HomePage homePage = new HomePage(driver);
        homePage.searchForNewComputer();
        homePage.filterByNameButtonClick();
        homePage.newComputerNameLinkClick();
        EditComputerPage editComputerPage = new EditComputerPage(driver);
        editComputerPage.deteteThisComputerButtonClick();
        Assert.assertEquals("Done! Computer has been deleted", homePage.getAlertMessage());
    }
}
