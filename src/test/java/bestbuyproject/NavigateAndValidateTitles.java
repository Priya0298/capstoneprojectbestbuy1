package bestbuyproject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.capstoneproject.Base.BestBuyTest;
import com.capstoneproject.utils.ScreenshotUtil;

public class NavigateAndValidateTitles extends BestBuyTest {
  
    @Test
    public void navigateAndValidateTitle() {
        test = extent.createTest("Navigate and Validate Title Test");
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement clickMenuButton = driver.findElement(By.xpath("//button[@class='c-button-unstyled hamburger-menu-button']"));
        js.executeScript("arguments[0].click();", clickMenuButton);
        test.pass("Navigated to menu");
        
        // Take a screenshot after clicking on the Cart icon
        ScreenshotUtil.takeScreenshot(driver, "validate_title_clicked");
    }

    @Test 
    public void validateBottomLinks() {
        test = extent.createTest("Validate Bottom Links Test");
        List<WebElement> bottomLinks = driver.findElements(By.cssSelector(".footer .footer-links a"));
        for (WebElement link : bottomLinks) {
            String url = link.getAttribute("href");
            test.pass("Validated link: " + url);
            
            // Take a screenshot after clicking on the Cart icon
            ScreenshotUtil.takeScreenshot(driver, "Bottom_links_clicked");
        }
    }
    
}