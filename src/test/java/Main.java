import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by Julia.hermann93 on 2017.05.12..
 */
public class Main {
    WebDriver driver;
    Wait<WebDriver> wait;;
    HomePageNotLoggedIn mainPageWithoutLogin;
    LoginPopUp loginPopup;
    HomePageLoggedIn mainPage;

    @BeforeClass
    public static void setupClass() {
        ChromeDriverManager.getInstance().setup();
    }

    @Before
    public void init(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,15);
        mainPageWithoutLogin = new HomePageNotLoggedIn(driver);
        loginPopup = mainPageWithoutLogin.openLoginPopup();
        mainPage = loginPopup.login("kovel@lgxscreen.com","tesztjelszo");

    }

    @After
    public void close(){
        if (driver != null) {
            driver.quit();
        }
    }

    //Sometimes login fails because another element at the navbar appears and that messes up my xpath.
    @Test
    public void testLogin(){
        assertTrue("InCorrect username after logged in.",mainPage.getUsername().equals("Teszt"));
    }

    @Test
    public void testCourseEnrollment(){
        /*
        if (mainPage.isEnrolled()){
            System.out.println("Already enrolled to course in scope of test, please un-enroll first.");
            return;
        }
        */
        mainPage.goToCatalog();
        String category = mainPage.selectCategory("Arts and Humanities");
        String courseName = mainPage.selectCourse("Buddhism and Modern Psychology");
        mainPage.enroll();
        mainPage.returnHome();

        assertTrue("InCorrect course name after enrolling in.",mainPage.getCourseName().equals(courseName));
    }


}
