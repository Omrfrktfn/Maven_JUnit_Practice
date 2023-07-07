package day10_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {

    @Test
    public void test01() {

        // girisYap methodu olusturun
        girisYap();
        // https://www.hotelmycamp.com adresine gidi
        // Log in butonuna tıklayın
        // Username: manager
        // Password: Manager1!

        // sutun sayısını yazdırın
        // tum body'i yazdirin
        // body'de bulunan satır sayısını yazdırın
        // body'de bulunan satırları yazdırın
        // 4.satırdaki elementleri yazdırın


    }

    public void girisYap() {
        driver.get("https://www.hotelmycamp.com");
        wait(1);

        driver.findElement(By.xpath("//*[@id='details-button']")).click();
        wait(1);

        driver.findElement(By.xpath("//*[@id='proceed-link']")).click();
        wait(1);

        driver.findElement(By.xpath("//*[text()='Log in']")).click();
        wait(1);

        driver.findElement(By.xpath("//*[@id='UserName']")).sendKeys("manager");
        wait(1);

        driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("Manager1!");
        wait(1);

        driver.findElement(By.xpath("//*[@id='btnSubmit']")).click();
        wait(1);

        List<WebElement> sutunBasliklari = driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("sutun sayisi: " + sutunBasliklari.size());
        System.out.println("***************************************************************");

        WebElement tumBody = driver.findElement(By.xpath("//tbody"));
        System.out.println("tum body: "+tumBody.getText());
        System.out.println("***************************************************************");

        List<WebElement> satirSayisi = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("satir sayisi: " + satirSayisi.size());
        System.out.println("***************************************************************");

        for (WebElement each:satirSayisi) {
            System.out.println(each.getText());
        }
        System.out.println("***************************************************************");

        List<WebElement> dorduncuSatir = driver.findElements(By.xpath("//tbody//tr[4]//td"));
        for (WebElement each:dorduncuSatir) {
            System.out.println(each.getText());
        }
        System.out.println("***************************************************************");



    }
}
