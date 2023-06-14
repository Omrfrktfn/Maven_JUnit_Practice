package day04_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.devtools.v109.input.model.DragDataItem;
import utilities.TestBase;

public class C03_WindowHandle extends TestBase {
    // 1- https://www.amazon.com sayfasina gidelim
    // 2- url'in 'amazon' icerdigini test edelim
    // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
    // 4- title'in 'Best Buy' icerdigini test edelim
    // 5- ilk sayfaya(amazon) donup sayfada java aratalım
    // 6- arama sonuclarının 'Java' icerdigini test edelim
    // 7- ikinci sayfaya(bestbuy) donelim
    // 8- logonun gorundugunu test edelim

    @Test
    public void test01() {

        driver.get("https://www.amazon.com");
        String amazonHandle = driver.getWindowHandle();

        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("amazon"));

        wait(1);
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String bestHandle = driver.getWindowHandle();

        String tittle = driver.getTitle();
        Assert.assertTrue(tittle.contains("Best Buy"));
        wait(1);

        driver.switchTo().window(amazonHandle);
        wait(1);

        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Java");
        searchBox.submit();

        wait(1);
        WebElement resultSearch = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(resultSearch.getText().contains("Java"));

        wait(1);
        driver.switchTo().window(bestHandle);

        wait(1);
        WebElement logo = driver.findElement(By.xpath("(//*[@src='https://www.bestbuy.com/~assets/bby/_intl/landing_page/images/maps/canada.svg'])[1]"));
        Assert.assertTrue(logo.isDisplayed());

    }
}
