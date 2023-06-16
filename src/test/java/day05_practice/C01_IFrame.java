package day05_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C01_IFrame extends TestBase {

    @Test
    public void test01() {
        // https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/ sayfasına gidiniz
        driver.get("https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/");
        wait(1);

        // Videoyu görecek kadar asagiya ininiz //sayfayi asagiya kaydirabilmemiz icin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        wait(1);

        // Videoyu izlemek icin Play tusuna basiniz
        WebElement iframe = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();
        wait(5);

        // videoyu durdurunuz
        driver.findElement(By.xpath("//*[@class='ytp-play-button ytp-button']")).click();
        wait(2);


        // videoyu tam ekran yapınız
        driver.findElement(By.xpath("//*[@class='ytp-fullscreen-button ytp-button']")).click();
        wait(1);


        // videoyu calıstırınız
        driver.findElement(By.xpath("//*[@class='ytp-play-button ytp-button']")).click();
        wait(3);


        // videoyu kucultunuz
        driver.findElement(By.xpath("//*[@class='ytp-fullscreen-button ytp-button']")).click();
        wait(3);


        // videoyu durdurunuz
        driver.findElement(By.xpath("//*[@class='ytp-play-button ytp-button']")).click();
        wait(2);


        // Videoyu calistirdiginizi test ediniz
        WebElement simge = driver.findElement(By.xpath("//*[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(simge.isDisplayed());

        // 'jQuery Flexy Plugin Demos' yazısının gorunur oldugunu test ediniz
        driver.switchTo().defaultContent();

        WebElement text = driver.findElement(By.xpath("//h1"));
        Assert.assertTrue(text.isDisplayed());

    }
}
