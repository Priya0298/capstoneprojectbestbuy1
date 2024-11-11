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

public class InvalidLoginTest extends BestBuyTest {

    @Test
    public void invalidLogin() {
        test = extent.createTest("Invalid Login Test");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Test Case 1: Both E-mail Id and Password Mismatch
        executeLoginTest(wait, "johncena45@gmail.com", "Password123", "//div[contains(text(), 'Sorry, something went wrong. Please try again.')]", "Both E-mail Id and Password Mismatch");
        ScreenshotUtil.takeScreenshot(driver, "login_icon_clicked");
        
        // Test Case 2: E-mail Id Mismatch
        executeLoginTest(wait, "cenajohn@example.com", "#YouCanSeeMe@", "//a[text()='Oops! The email or password did not match our records. Please try again.']", "E-mail Id Mismatch");

        // Test Case 3: Password Mismatch
        executeLoginTest(wait, "johncena45@gmail.com", "#YouCanSeeMe@", "//a[text()='Oops! The email or password did not match our records. Please try again.']", "Password Mismatch");
       
        // Take a screenshot after clicking on the Cart icon
       
    }
    

    private void executeLoginTest(WebDriverWait wait, String email, String password, String errorXpath, String testCase) {
        test = extent.createTest(testCase);
        navigateToSignInPage(wait);
        driver.findElement(By.id("fld-e")).sendKeys(email);
        driver.findElement(By.id("fld-p1")).sendKeys(password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        test.pass("Entered credentials and clicked login");

        WebElement errorMessage = driver.findElement(By.xpath(errorXpath));
        if (errorMessage.isDisplayed()) {
            test.pass("Error message displayed as expected: " + errorMessage.getText());
        } else {
            test.fail("Error message not displayed");
        }
    }

    private void navigateToSignInPage(WebDriverWait wait) {
        WebElement clickAccountMenuField = wait.until(ExpectedConditions.elementToBeClickable(By.id("account-menu-account-button")));
        clickAccountMenuField.click();
        WebElement signInField = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign In")));
        signInField.click();
        test.pass("Navigated to Sign In page");
    }
    
}