package day11_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {


    @Test
    public void test01() {
        girisYap();

        //input olarak verilen satir sayisi ve sutun syisina sahip cell'deki text'i dinamik olarak yazdirin

        int satir = 3;
        int sutun = 3;

        WebElement arananCell = driver.findElement(By.xpath("//tbody//tr[" + satir + "]//td[" + sutun + "]"));
        System.out.println(arananCell.getText());


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
        System.out.println("tum body: " + tumBody.getText());
        System.out.println("***************************************************************");

        List<WebElement> satirSayisi = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("satir sayisi: " + satirSayisi.size());
        System.out.println("***************************************************************");

        for (WebElement each : satirSayisi) {
            System.out.println(each.getText());
        }
        System.out.println("***************************************************************");

        List<WebElement> dorduncuSatir = driver.findElements(By.xpath("//tbody//tr[4]//td"));
        for (WebElement each : dorduncuSatir) {
            System.out.println(each.getText());
        }
        System.out.println("***************************************************************");

        List<WebElement> basliklarinListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));
        int emailSutunNo = 0;
        for (int i = 0; i < basliklarinListesi.size(); i++) {
            if (basliklarinListesi.get(i).getText().equals("Email")) {
                emailSutunNo = i;
            }
        }

        List<WebElement> emailBasligi = driver.findElements(By.xpath("//tbody//tr//td[" + (emailSutunNo + 1) + "]"));
        for (WebElement each : emailBasligi) {
            System.out.println(each.getText());
        }

        System.out.println("***************************************************************");
    }
}