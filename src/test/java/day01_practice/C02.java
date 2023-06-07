package day01_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02 {
    // https://www.sahibinden.com/ sayfasina gidin
    // Title ve Url'ini alın ve yazdırın
    // Title'in "Online" kelimesini içerip içermedigini test edin
    // Url'in "sahibinden" kelimesini içerip içermedigini test edin
    // https://www.amazon.com/ sayfasına gidin
    // Title'ini alın ve yazdırın
    // Title'in "more" kelimesini içerip içermedigini test edin
    // sahibinden.com'a geri dönün
    // sayfayı yenileyin
    // amazon.com'a tekrar gelin


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
    public void test01() throws InterruptedException {
        driver.get("https://www.techproeducation.com/");

        String pageTittle = driver.getTitle();
        System.out.println("techpro page tittle :" + pageTittle);

        String pageURL = driver.getCurrentUrl();
        System.out.println("techpro page URL :" + pageURL);

        Assert.assertTrue(pageTittle.contains("Techpro"));
        Assert.assertTrue(pageURL.contains("techproeducation"));

        Thread.sleep(1000);

        driver.get("https://www.amazon.com/");
        System.out.println("amazon page tittle : " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("more"));

        Thread.sleep(1000);

        driver.navigate().back();
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        driver.navigate().forward();


    }
}
