package day01_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04 {

    // https://www.amazon.com/ adresine gidin
// arama motorunda nutella yazip aratınız
// sayfada karsınıza cıkan tum urunlere tıklayın ve title'ını yazdırın

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
        driver.get("https://www.amazon.com/");

        WebElement searchbox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchbox.sendKeys("nutella");
        searchbox.submit();
/*
        List<WebElement> link = driver.findElements(By.xpath("//img[@class='s-image']"));
        for (int i = 0; i < link.size(); i++) {
            link = driver.findElements(By.xpath("//img[@class='s-image']"));
            link.get(i).click();
            System.out.println("page tittle" + driver.getTitle());
            Thread.sleep(1000);
            driver.navigate().back();
        }

 */
        for (int i = 0; i < 2; i++) {
            List<WebElement> link = driver.findElements(By.xpath("//img[@class='s-image']"));
            link.get(i).click();
            System.out.println((i+1) + ". urun tittle" + driver.getTitle());
            Thread.sleep(1000);
            driver.navigate().back();
        }
        
    }
}
