package day08_practice;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_ScreenShot extends TestBase {

    @Test
    public void test01() throws IOException {
        // https://www.teknosa.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        wait(1);

        // arama cubuguna oppo yazip enter'a basınız
        driver.findElement(By.xpath("//*[@class='nav-input nav-progressive-attribute']")).
                sendKeys("oppo", Keys.ENTER);
        wait(1);

        // sonuc yazısını yazdiriniz
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@class='sg-col-inner']"));
        System.out.println("Sonuc Yazisi " + sonucYazisi.getText());

        // ilk urunun fotografını cekin

        WebElement ilkUrun = driver.findElement(By.xpath("(//*[@class='a-section aok-relative s-image-fixed-height'])[1]"));
        //TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ilkUrun.getScreenshotAs(OutputType.FILE), new File("Screenshot/screenshot.png"));


    }
}
