package day02_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02 {
    // https://www.amazon.com/ sayfasina gidin
// dropdown'dan "Baby" secenegini secin
// sectiginiz option'i yazdirin
// dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
// dropdown'daki optionların tamamını yazdırın

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
        option.selectByVisibleText("Baby");

        WebElement selectedOption = option.getFirstSelectedOption();
        System.out.println("Seçilen seçenek: " + selectedOption.getText());

        int totalOptions = option.getOptions().size();
        Assert.assertEquals(totalOptions,28);

        option.getOptions().stream().forEach(t-> System.out.println(t.getText()));



    }
}
