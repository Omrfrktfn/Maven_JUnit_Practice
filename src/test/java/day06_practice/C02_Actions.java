package day06_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C02_Actions extends TestBase {

    @Test
    public void test01() {

        // https://demoqa.com/droppable adresine gidiniz
        driver.get("https://demoqa.com/droppable");
        wait(1);

        // 'Drag me' butonunu tutup 'Drop here' kutusunun ustune birakiniz

        Actions action = new Actions(driver);
        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        action.dragAndDrop(drag, drop).perform();

        // 'Drop here' yazisi yerine 'Dropped!' oldugunu test ediniz
        WebElement yazi = driver.findElement(By.xpath("//p[text()='Dropped!']"));
        Assert.assertTrue(yazi.isDisplayed());
    }
}
