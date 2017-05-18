import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Julia.hermann93 on 2017.05.12..
 */
public class LoginPopUp {
    WebDriver driver;
    Wait<WebDriver> wait;

    By usernameInputLocator = By.xpath("//*[@id=\"rendered-content\"]/div/div/div[1]/div[3]/div[2]/div/div[3]/div/div/div/form/div[1]/div[1]/input");
    By passwordInputLocator = By.xpath("//*[@id=\"rendered-content\"]/div/div/div[1]/div[3]/div[2]/div/div[3]/div/div/div/form/div[1]/div[2]/input");

    public LoginPopUp(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
    }

    public HomePageLoggedIn login(String username, String password) {
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInputLocator));
        WebElement passwordInput = driver.findElement(passwordInputLocator);

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);

        usernameInput.submit();

        return new HomePageLoggedIn(driver);
    }
}
