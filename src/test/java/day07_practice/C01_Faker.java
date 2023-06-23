package day07_practice;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Faker extends TestBase {

    @Test
    public void test01() {

        // 'https://www.facebook.com' sayfasina gidiniz
        driver.get("https://www.facebook.com");
        wait(1);
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _al65 _4jy3 _4jy1 selected _51sy']")).click();
        wait(1);

        // yeni hesap olustur butonuna basin
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        wait(1);
        // isim kutusunu locate ediniz
        WebElement name = driver.findElement(By.xpath("//*[@class='inputtext _58mg _5dba _2ph-']"));


        // geriye kalan alanlari TAB ile dolasarak faker bilgilerle formu doldurun
        Faker faker = new Faker();
        Actions action = new Actions(driver);

        String email = faker.internet().emailAddress(); //ayni email i ikinci kez istedigi icin bu sekilde yaptik
        action.click(name).
                sendKeys(faker.name().firstName(), Keys.TAB).
                sendKeys(faker.name().lastName(), Keys.TAB).
                sendKeys(faker.internet().emailAddress(), Keys.TAB).
                sendKeys(email, Keys.TAB).
                sendKeys(faker.internet().password(), Keys.TAB, Keys.TAB).
                sendKeys("26", Keys.TAB).
                sendKeys("Mart", Keys.TAB).
                sendKeys("1997", Keys.TAB, Keys.TAB). //iki tab ile soru isareti kisimlari atliyoruz
                sendKeys(Keys.ARROW_RIGHT, Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB).
                sendKeys(Keys.ENTER)
        .perform();

    }
}
