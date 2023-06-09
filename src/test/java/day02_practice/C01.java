package day02_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01 {

    // https://www.amazon.com/ sayfasina gidin
    // dropdown'dan "Books" secenegini secin
    // arama cubuguna "Java" aratın
    // arama sonuclarinin Java icerdigini test edin

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
        Thread.sleep(2000);

        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select option = new Select(ddm);
        option.selectByVisibleText("Books");

        Thread.sleep(2000);
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Java" + Keys.ENTER);

        Thread.sleep(2000);
        WebElement sonuc = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        Assert.assertTrue(sonuc.getText().contains("Java"));

    }
}
