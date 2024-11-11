package bestbuyproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.capstoneproject.Base.BestBuyTest;
import com.capstoneproject.utils.ScreenshotUtil;

public class SearchAndAddCart extends BestBuyTest {

    @Test
    public void searchAndAddToCart() {
        test = extent.createTest("Search and Add to Cart Test");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        
        driver.findElement(By.id("gh-search-input")).sendKeys("Laptop");
        driver.findElement(By.cssSelector(".header-search-button")).click();
        test.pass("Searched for Laptop");

        driver.findElement(By.cssSelector(".sku-title a")).click();
        driver.findElement(By.cssSelector(".add-to-cart-button")).click();
        test.pass("Added Laptop to cart");
        
        // Take a screenshot after clicking on the Cart icon
        ScreenshotUtil.takeScreenshot(driver, "cart_icon_clicked");
    }
}