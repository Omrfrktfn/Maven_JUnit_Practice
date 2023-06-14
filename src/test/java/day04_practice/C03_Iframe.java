package day04_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C03_Iframe extends TestBase {
    // https://html.com/tags/iframe sayfasına gidiniz
// Videoyu görecek kadar asagiya ininiz
// Videoyu izlemek icin Play tusuna basiniz
// Videoyu calistirdiginizi test ediniz
// 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz


    @Test
    public void test01() {
        driver.get("https://html.com/tags/iframe");

        Actions actions = new Actions(driver);//sayfayi asagiya kaydirabilmemiz icin
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        wait(1);

        WebElement iframe = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();
        wait(3);
        WebElement stopButton = driver.findElement(By.xpath("//*[@class='ytp-play-button ytp-button']"));
        Assert.assertFalse(stopButton.isDisplayed());
        stopButton.click();
        driver.switchTo().parentFrame();

        WebElement sonYazi = driver.findElement(By.xpath("//*[@id='Powerful_but_easy_to_misuse']"));
        Assert.assertTrue(sonYazi.isDisplayed());

    }
}
