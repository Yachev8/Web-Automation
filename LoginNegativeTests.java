package AutomationWeb1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginNegativeTests {

    static WebDriver driver;

    @BeforeAll
    public static void LoginPage() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("Start-Maximized");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

    }

    @AfterAll
    public static void Close() {
        driver.quit();
        driver.close();
    }

    @Test
    @DisplayName("Havigate to website")
    public void HavigateToSite() {
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @Test
    @DisplayName("Negative tests for login ")
    public void LoginNegative() {
        //click Sign in button
        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a")).click();

        //check for message for error if click Sign in, before to type email and password
        driver.findElement(By.xpath("//*[@id=\"send2\"]/span")).click();
        //message for error on email
        String email = driver.findElement(By.id("email-error")).getText();
        System.out.println(email);

        //message for error on password
         String password = driver.findElement(By.id("pass-error")).getText();
        System.out.println(password);


    }

}