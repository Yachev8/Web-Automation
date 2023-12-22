package AutomationWeb1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NegativeTestsForCreateAccount {



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
        @DisplayName("Negative test scenarios for create an account")
        public void NegativeScenarios() throws InterruptedException {
            //click Create an Account button
            driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a")).click();

            // script to scroll to down
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,350)", "");

            // all field are blank and click button create an account button and verify for error messages
            driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button")).click();
            Thread.sleep(4000);

            // check message for error if forgot to type First name
            String firstname = driver.findElement(By.id("firstname-error")).getText();
            System.out.println(firstname);

            //check message for error if forgot to type Last name
            String lastname = driver.findElement(By.xpath("//*[@id=\"lastname-error\"]")).getText();
            System.out.println(lastname);

            // check message for error if forgot to type Email
            String email = driver.findElement(By.xpath("//*[@id=\"email_address-error\"]")).getText();
            System.out.println(email);

            // check message for error if forgot to type Password
            String password = driver.findElement(By.id("password-strength-meter")).getText();
            System.out.println(password);

            // check message for error if forgot to type all specific sumbols for password
            driver.findElement(By.id("password")).sendKeys("1234567");
            Thread.sleep(2000);
            String specificSumbols = driver.findElement(By.xpath("//*[@id=\"password-error\"]")).getText();
            System.out.println(specificSumbols);

            //check message for error if forgot to type confirm password
            String confirmPass = driver.findElement(By.id("password-confirmation-error")).getText();
            System.out.println(confirmPass);

        }
}
