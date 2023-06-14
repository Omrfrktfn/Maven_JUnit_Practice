package day04_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C01_DropDown extends TestBase {
    // https://www.amazon.com/ sayfasina gidin
// dropdown'dan "Books" secenegini secin
// arama cubuguna "Java" aratın
// arama sonuclarinin Java icerdigini test edin
    @Test
    public void test01() {
        driver.get("https://www.amazon.com/");
        wait(1);

        WebElement ddm = driver.findElement(By.xpath("//*[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));
        Select option = new Select(ddm);
        option.selectByVisibleText("Books");

        wait(1);
        WebElement searchBox = driver.findElement(By.xpath("//*[@class='nav-input nav-progressive-attribute']"));
        searchBox.sendKeys("Java");
        searchBox.submit();

        wait(1);
        WebElement resultSearch = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(resultSearch.getText().contains("Java"));

    }
}
