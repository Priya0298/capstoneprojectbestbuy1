package bestbuyproject;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.capstoneproject.Base.BestBuyTest;
import com.capstoneproject.utils.ScreenshotUtil;

public class SignUpAndLogin extends basepage.BestBuyTest {

    @Test
    public void signUpAndLogin() {
        ExtentTest test = extent.createTest("Sign Up and Login Test");
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            WebElement clickAccountMenu = wait.until(ExpectedConditions.elementToBeClickable(By.id("account-menu-account-button")));
            clickAccountMenu.click();
            test.pass("Clicked on account menu");

            WebElement creatAccountField = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Create Account")));
            creatAccountField.click();
            test.pass("Clicked on create account link");

            // Fill out sign-up form
            driver.findElement(By.id("firstName")).sendKeys("John");
            driver.findElement(By.id("lastName")).sendKeys("Cena");
            driver.findElement(By.id("email")).sendKeys("johncena45@gmail.com");
            driver.findElement(By.id("fld-p1")).sendKeys("#YouCanSeeMe@");
            driver.findElement(By.id("reenterPassword")).sendKeys("#YouCanSeeMe@");
            driver.findElement(By.id("phone")).sendKeys("2015543555");
            driver.findElement(By.id("is-recovery-phone")).click();
            driver.findElement(By.xpath("/html/body/div[1]/div/section/main/div[2]/div/div/div[1]//form/div[8]/button")).click();
            test.pass("Filled out sign-up form");

            // Log out and log in with the new account
            driver.findElement(By.xpath("/html/body/div[1]/div/header/div/a[2]")).click();
            WebElement clickAccountMenuField = wait.until(ExpectedConditions.elementToBeClickable(By.id("account-menu-account-button")));
            clickAccountMenuField.click();
            WebElement signInField = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign In")));
            signInField.click();

            driver.findElement(By.id("fld-e")).sendKeys("johncena45@gmail.com");
            driver.findElement(By.id("fld-p1")).sendKeys("#YouCanSeeMe@");
            driver.findElement(By.xpath("/html/body/div[1]//form/div[3]/button")).click();
            test.pass("Logged in with the new account");

        } catch (Exception e) {
            test.fail("Test failed: " + e.getMessage());
        }
        // Take a screenshot after clicking on the Cart icon
        ScreenshotUtil.takeScreenshot(driver, "log_icon_clicked");
    }
    
}