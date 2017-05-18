import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Julia.hermann93 on 2017.05.12..
 */
public class HomePageLoggedIn {
    WebDriver driver;
    Wait<WebDriver> wait;

    By toAccountLocator = By.className("c-ph-username");
    By toCourseNameLocator = By.xpath("//*[@id=\"rendered-content\"]/div/div/div[2]/div/div/div[2]/main/div[1]/ul/li/section/div[2]/div[2]/a/div[1]/h4");

    public HomePageLoggedIn(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public String getUsername() {
        WebElement accountButton = wait.until(ExpectedConditions.visibilityOfElementLocated(toAccountLocator));
        return accountButton.getText();
    }

    public void goToCatalog() {
        driver.findElement(By.className("c-catalog-button")).click();
    }

    public String selectCategory(String category) {
        driver.findElement(By.xpath("//*[@id=\"rendered-content\"]/div/div/div[2]/div[1]/div[1]/div/div/div[2]/div/a[1]/span[2]")).click();
        return category;
    }

    public String selectCourse(String courseName) {
        driver.findElement(By.xpath("//*[@id=\"history\"]/div/div[1]/div[2]/a/div[1]/div/div[2]/div[1]/h2")).click();
        return courseName;
    }

    public void enroll() {
        //Enroll now button
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"rendered-content\"]/div/div/div/div/div[2]/div[1]/div[2]/div/div/div[1]/div/div[1]/div/div/div/div/button/span")));
        driver.findElement(By.xpath("//*[@id=\"rendered-content\"]/div/div/div/div/div[2]/div[1]/div[2]/div/div/div[1]/div/div[1]/div/div/div/div/button/span")).click();

        //continue button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[7]/div/div[2]/div[1]/div[2]/div/div[2]/button")));
        driver.findElement(By.xpath("/html/body/div[7]/div/div[2]/div[1]/div[2]/div/div[2]/button")).click();

        //Start learning button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[7]/div/div[2]/div[1]/div[2]/div/div/div/div[2]/a/button")));
        driver.findElement(By.xpath("/html/body/div[7]/div/div[2]/div[1]/div[2]/div/div/div/div[2]/a/button")).click();
    }

    public void returnHome() {
        driver.findElement(By.className("c-logo")).click();
    }

    public String getCourseName() {
        WebElement courseTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(toCourseNameLocator));
        return courseTitle.getText();
    }

    public boolean isEnrolled() {
        driver.findElement(By.xpath("//*[@id=\"rendered-content\"]/div/div/div[2]/div/div/div[1]/div/div/div/div[1]/div[2]/div/li/a[1]")).click();
        WebElement title = driver.findElement(By.xpath("//*[@id=\"rendered-content\"]/div/div/div[2]/div/div/div[2]/main/div[1]/div/p"));
        return !title.getText().contains("don't");
    }
}