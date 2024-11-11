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

public class AddItemFromDepartmentTest extends BestBuyTest {

    @Test
    public void addItemFromDepartment() {
        test = extent.createTest("Add Item From Department Test");
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        
        WebElement clickMenuButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='c-button-unstyled hamburger-menu-button']")));
        clickMenuButton.click();
        test.pass("Clicked on Menu Button");

        WebElement departmentsMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-id='node-407']")));
        departmentsMenu.click();
        test.pass("Clicked on Departments menu");
        
        WebElement subMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-id='node-295']")));
		 subMenu.click();
		 test.pass("Clicked on SubMenu Laptop&Destops");

        WebElement selectDepartment = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Laptops")));
        selectDepartment.click();
        test.pass("Selected Laptops department");
        
        WebElement firstItem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"widget-310ac125-9416-47bf-b89d-9525647e372c\"]/div/div[2]/div[1]/div[1]/div/a")));
        firstItem.click();
        test.pass("Clicked on first item");

        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".add-to-cart-button")));
        addToCartButton.click();
        test.pass("Added item to cart");
        
        // Take a screenshot after clicking on the Cart icon
        ScreenshotUtil.takeScreenshot(driver, "cart_icon_clicked");
    }
}