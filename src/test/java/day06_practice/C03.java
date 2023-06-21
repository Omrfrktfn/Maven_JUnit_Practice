package day06_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;
import java.util.Set;

public class C03 extends TestBase {

    @Test
    public void test01() {

        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");
        wait(1);
        String sayfa1Handle = driver.getWindowHandle();
        System.out.println("SAYFA1HANDLE: " + sayfa1Handle);


        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        Actions acition = new Actions(driver);
        WebElement target = driver.findElement(By.xpath("//*[@id='icp-nav-flyout']"));
        acition.moveToElement(target).perform();
        wait(1);

        // Change country/region butonuna basiniz
        driver.findElement(By.xpath("(//*[text()='Change country/region.'])[1]")).click();
        wait(1);

        // United States dropdown'undan 'Turkey (Türkiye)' seciniz
        WebElement ddm = driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        Select option = new Select(ddm);
        option.selectByVisibleText("Turkey (Türkiye)");
        wait(1);

        driver.findElement(By.xpath("//span[text()='Changing country/region website']")).click();
        //sayfada otomotk kapanmadi icin acila ddm bu sekilde kapatma islemi yaptik
        wait(1);

        // Go to website butonuna tiklayiniz
       driver.findElement(By.xpath("//*[@class='a-button-input']")).click();

        Set<String> windowHandleSeti = driver.getWindowHandles();
        System.out.println("Tüm Handle Degerler : " + windowHandleSeti);

        String sayfa2Handle = "";

        for (String w : windowHandleSeti) {
            if (!w.equals(sayfa1Handle)) {
                sayfa2Handle = w;
            }
        }
        System.out.println("SAYFA2HANDLE : " + sayfa2Handle);
        driver.switchTo().window(sayfa2Handle);
        wait(1);

        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
        String ikinciSayfa= driver.getTitle();
        System.out.println("ikinci sayfa tittle :"+ikinciSayfa);
        Assert.assertTrue(ikinciSayfa.contains("Elektronik"));
    }
}
