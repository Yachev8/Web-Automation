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

public class CreateAccountSuccessfully {
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
    @DisplayName("Create an Account")
    public void CreateAccount() {
        //click Create an Account button
        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a")).click();
        // type First Name
        driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys("Georg");
        //type Last Name
        driver.findElement(By.id("lastname")).sendKeys("Ivanov");
        //type Email
        driver.findElement(By.id("email_address")).sendKeys("ivanov@gmail.com");
        //type Password
        driver.findElement(By.id("password")).sendKeys("1234567tG@");
        //type confirm Password
        driver.findElement(By.id("password-confirmation")).sendKeys("1234567tG@");
        //click Create an Account button
        driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span")).click();
    }












}
