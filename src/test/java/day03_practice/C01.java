package day03_practice;

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

    // https://demo.guru99.com/test/radio.html adresine gidin
// checkbox elementlerini locate edin
// checkbox1 ve checkbox3  secili degil ise secin
// checkbox1 ve checkbox3 elementlerinin secili oldugunu Test edin
// checkbox2 elementinin secili olmadıgını test edin

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        //  driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://demo.guru99.com/test/radio.html");
        Thread.sleep(1000);

        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='gdpr-consent-notice']"));
        driver.switchTo().frame(iframe);
        //Cerezleri kapatma
        driver.findElement(By.xpath("(//div[@class='action-wrapper'])[3]")).click();
        // Ana sayfaya geri dönme
        driver.switchTo().defaultContent();

        WebElement checkBox1 = driver.findElement(By.xpath("//*[@id='vfb-6-0']"));
        WebElement checkBox2 = driver.findElement(By.xpath("//*[@id='vfb-6-1']"));
        WebElement checkBox3 = driver.findElement(By.xpath("//*[@id='vfb-6-2']"));

        Thread.sleep(1000);
       // Select option = new  Select(checkBox1);
        if(!checkBox1.isSelected()){
            checkBox1.click();
        }

        if(!checkBox3.isSelected()){
            checkBox3.click();
        }

        Thread.sleep(1000);
        // checkbox1 ve checkbox3 elementlerinin secili oldugunu Test edin

        Assert.assertTrue(checkBox1.isSelected());

        Assert.assertTrue(checkBox3.isSelected());


        // checkbox2 elementinin secili olmadıgını test edin

        Assert.assertFalse(checkBox2.isSelected());


    }


}

