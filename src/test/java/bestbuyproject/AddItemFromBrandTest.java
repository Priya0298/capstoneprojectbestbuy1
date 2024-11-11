package bestbuyproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.capstoneproject.Base.BestBuyTest;
import com.capstoneproject.utils.ScreenshotUtil;

public class AddItemFromBrandTest extends BestBuyTest {

    @Test
    public void addItemFromBrand() {
        test = extent.createTest("Add Item From Brand Test");
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        
        WebElement clickMenuButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='c-button-unstyled hamburger-menu-button']")));
        clickMenuButton.click();
        test.pass("Clicked on Menu Button");
        
        WebElement brandsMenu  = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-id='node-82']")));
        brandsMenu.click();
        test.pass("Clicked on Brands menu");
        
        WebElement selectBrand = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Apple")));
        selectBrand.click();
        test.pass("Selected Apple brand");

        WebElement firstItem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"widget-9bc5db23-9f62-4ded-8b58-511aee4ea7b9\"]/div/div[2]/div[1]/div[1]/div/a")));
        firstItem.click();
        test.pass("Clicked on first item");

        WebElement clickfirstItem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"widget-c49b675f-f9aa-4d6b-9e6d-cca0fb66be41\"]/div/div[2]/div[1]/div[1]/div/a")));
        clickfirstItem.click();
        test.pass("Clicked on Clickfirst item");
        
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".add-to-cart-button")));
        addToCartButton.click();
        test.pass("Added item to cart");
        
     // Take a screenshot after clicking on the Cart icon
        ScreenshotUtil.takeScreenshot(driver, "cart_icon_clicked");

    }
}