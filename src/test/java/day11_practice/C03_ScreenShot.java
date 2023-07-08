package day11_practice;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C03_ScreenShot extends TestBase {

    @Test
    public void test01() throws IOException {


        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        wait(1);

// arama kutusuna Nutella yazip aratın
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);
        wait(1);

// ilk ürüne tıklayın
        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();

// tüm sayfanın fotografını cekin
        TakesScreenshot ts = (TakesScreenshot) driver;
        String date = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        File kayit = new File("Screenshot/screenshot"+date+".jpg");
        File geciciDosya = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciDosya,kayit);
    }
}
