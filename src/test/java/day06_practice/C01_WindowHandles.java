package day06_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C01_WindowHandles extends TestBase {

    @Test
    public void test01() {
        // 'https://www.n11.com' adresine gidin
        driver.get("https://www.ebay.pl/");
        String ilkSayfaTittle = driver.getTitle();
        System.out.println("ilk sayfa tittle : " + ilkSayfaTittle);
        String sayfa1Handle = driver.getWindowHandle();
        System.out.println("ilk sayfa handle degeri : " + sayfa1Handle);
        wait(1);

        // arama motoruna 'Oppo' yazıp aratın
        WebElement searchBox = driver.findElement(By.xpath("//*[@class='gh-tb ui-autocomplete-input']"));
        searchBox.sendKeys("Oppo");
        searchBox.submit();
        wait(1);

        // ilk ürüne tıklayın
        driver.findElement(By.xpath("(//*[@class='s-item__title'])[2]")).click();

        Set<String> pencereler = driver.getWindowHandles();
        System.out.println(pencereler);

        String sayfa2handle = "";

        for (String w : pencereler) {
            if (!w.equals(sayfa1Handle)) {
                sayfa2handle = w;
            }
        }

        System.out.println("ikinci sayfa handle degeri :" + sayfa2handle);
        driver.switchTo().window(sayfa2handle);

        // ikinci sayfa tittle'in OPPO icerdgini test edin.
        String ikinciSayfaTittle = driver.getTitle();
        System.out.println("ikinci sayfa tittle : " + ikinciSayfaTittle);
        Assert.assertTrue(ikinciSayfaTittle.contains("OPPO"));
        wait(1);


        // ilk sayfaya donun ve Title'ını yazdırın
        driver.switchTo().window(sayfa1Handle);
        System.out.println("ilk sayfa tittle : "+driver.getTitle());
    }
}
