import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Julia.hermann93 on 2017.05.12..
 */
public class HomePageNotLoggedIn {
    WebDriver driver;
    Wait<WebDriver> wait;



    public HomePageNotLoggedIn(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,5);
    }

    public LoginPopUp openLoginPopup(){
        driver.get("https://www.coursera.org/");

        driver.findElement(By.linkText("Log In")).click();


        return new LoginPopUp(driver);
    }
}
