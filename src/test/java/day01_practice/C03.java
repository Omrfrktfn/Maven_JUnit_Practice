package day01_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03 {

    // https://www.bestbuy.com/ sayfasına gidin
// sayfa Title'ini alın "Best" içerdigini test edin
// BestBuy logosunun görüntülendigini test edin
// Canada logosunun görüntülendigini test edin

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
         driver.close();
    }

    @Test
    public void test01() {
        driver.get("https://www.bestbuy.com/");

        System.out.println("page tiitle : " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Best"));

        WebElement logo = driver.findElement(By.xpath("//*[@src='https://www.bestbuy.com/~assets/bby/_com/header-footer/images/bby_logo-a7e90594729ed2e119331378def6c97e.png']"));
        Assert.assertTrue(logo.isDisplayed());


        WebElement canadaLogo = driver.findElement(By.xpath(" //*[@src='https://www.bestbuy.com/~assets/bby/_intl/landing_page/images/maps/canada.svg']"));
        Assert.assertTrue(canadaLogo.isDisplayed());
    }
}
