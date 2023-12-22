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

public class Functionality {
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
    public void TestA() {
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @Test
    @DisplayName("Successfully login")
    public void TestB() throws InterruptedException {
        //click Sign in button
        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a")).click();

        //type correct credentials
        // type email
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("ivanov@gmail.com");
        //type Password
        driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("1234567tG@");
        //click Sign in button
        driver.findElement(By.xpath("//*[@id=\"send2\"]/span")).click();
    }
    @Test
    @DisplayName("Select item from category MEN")
         public void TestC() throws InterruptedException {


        //click MEN from category
        driver.findElement(By.xpath("//*[@id=\"ui-id-5\"]")).click();
        Thread.sleep(2000);
        //clicks Tops
        driver.findElement(By.xpath("//*[@id=\"narrow-by-list2\"]/dd/ol/li[1]/a")).click();
        //click Category
        driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[1]")).click();
        //click jackets
        driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li[1]/a")).click();
        //click Dropdown sort by :
        driver.findElement(By.xpath("//*[@id=\"sorter\"]")).click();
        Thread.sleep(2000);
        //click from dropdown sort by : price
        driver.findElement(By.xpath("//*[@id=\"sorter\"]/option[3]")).click();
        Thread.sleep(2000);
        //compare that the price is the lowest 42.00
        String LowestPrice = driver.findElement(By.xpath("//*[@id=\"product-price-270\"]/span")).getText();
        System.out.println(LowestPrice);

        //click arrow for up
        driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/div[3]/a")).click();
        Thread.sleep(2000);
        //compare that the price is the highest 99.00
        String highestprice = driver.findElement(By.xpath("//*[@id=\"product-price-334\"]/span")).getText();
        System.out.println(highestprice);
    }

    }










