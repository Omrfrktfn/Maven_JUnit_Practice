package day04_practice;

import com.google.j2objc.annotations.Weak;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Allert extends TestBase {

    //http://demo.guru99.com/test/delete_customer.php adresine gidin
//customer id kısmına 53920 yazın
//submit butonuna tıklayın
//cıkan alert mesajını yazdırın
//alerti kabul edin
//cıkan 2. alert mesajını yazdırın
//cıkan 2. alerti kabul edin
    @Test
    public void test01() {
        driver.get("http://demo.guru99.com/test/delete_customer.php");
        wait(1);
        WebElement iframe = driver.findElement(By.xpath("//*[@id='gdpr-consent-notice']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//*[@class='mat-focus-indicator solo-button mat-button mat-button-base mat-raised-button']")).click();
        driver.switchTo().parentFrame();

        wait(1);
        WebElement customerId = driver.findElement(By.xpath("//input[@name='cusid']"));
        customerId.sendKeys("53920");

        wait(1);
        //submit butonuna tıklayın
        WebElement submit = driver.findElement(By.xpath("//input[@value='Submit']"));
        submit.click();

        //cıkan alert mesajını yazdırın
        String alertYazisi = driver.switchTo().alert().getText();
        System.out.println("ALERT YAZISI " + alertYazisi);
        wait(1);

        //alerti kabul edin
        driver.switchTo().alert().accept();
        wait(1);

        //cıkan 2. alert mesajını yazdırın
        String ikinciAlert = driver.switchTo().alert().getText();
        System.out.println("Ikinci Alert = " + ikinciAlert);

        wait(1);
        //cıkan 2. alerti kabul edin
        driver.switchTo().alert().accept();


    }
}
