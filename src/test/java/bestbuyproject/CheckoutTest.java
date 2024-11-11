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

public class CheckoutTest extends BestBuyTest {

    @Test
    public void checkout() {
        test = extent.createTest("Checkout Test");
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        // Assuming the item is already added to the cart
        WebElement cartIcon = wait.until(ExpectedConditions.elementToBeClickable(By.className("cart-link")));
        cartIcon.click();
        test.pass("Clicked on cart icon");
        
        WebElement continueButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='checkout-buttons']//a[@class='btn btn-secondary btn-block btn-lg']")));
        continueButton.click();
        test.pass("Clicked on Continue button");
        
        
        WebElement searchBar = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("gh-search-input")));
        searchBar.sendKeys("Laptop");
        searchBar.submit();
        test.pass("Clicke on SearchBar in Laptop");
        
        WebElement firstProduct = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".sku-item")));
        firstProduct.click();
        test.pass("Add The First Item in Cart");
        
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='column-right']//button[@data-button-state='ADD_TO_CART'])[2]")));
        addToCartButton.click();
        test.pass("Item Add in Cart Sucessfully");
        
        WebElement goToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='c-button c-button-secondary c-button-md c-button-block ']")));
        goToCartButton.click();
        test.pass("Sucessfully go to the cart");
        
        WebElement clickCheckoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//section[@class='fluid-large-view__sidebar']//button[@type='button'])[1]")));
        clickCheckoutButton.click();
        test.pass("Check one's Again the Cart");
        

        WebElement clickGuestButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='cia-secondary-content-v2']//button[@type='button']")));
        clickGuestButton.click();
        test.pass("Click Guest Button");
        
  

        // Fill out the checkout form
        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("John");
        driver.findElement(By.id("lastName")).sendKeys("Cena");
        driver.findElement(By.id("street")).sendKeys("51 1/2 17th Ave SW");
        driver.findElement(By.id("city")).sendKeys("Cedar Rapids");
        driver.findElement(By.id("state")).sendKeys("IA");
        driver.findElement(By.id("zipcode")).sendKeys("52404");
        test.pass("Filled out checkout form");
        
        WebElement clickapplyButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-track='Shipping: Save shipping address']")));
	    clickapplyButton.click();
	    test.pass("Click the Shipping Address Button");
	    
	    // Fill the Email and PhoneNumber for Address Field
	    driver.findElement(By.id("user.emailAddress")).sendKeys("johncena45@gmail.com");
	    driver.findElement(By.id("user.phone")).sendKeys("2015543555");
	    ScreenshotUtil.takeScreenshot(driver, "contact_info_entered");
	    
	    WebElement clickcheckBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='c-checkbox-brand']//input[@id='text-updates']")));
	    clickcheckBox.click();
	    test.pass("Click the CheckBox");
	    
	    WebElement clickcontinueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='button--continue']//button[@class='btn btn-lg btn-block btn-secondary']")));
	    clickcontinueButton.click();
        test.pass("Click the Ones Again Countinue Button");
     // Take a screenshot after clicking on the Cart icon
        ScreenshotUtil.takeScreenshot(driver, "continue_button_clicked");
        
        
  
        
       // WebElement placeOrderButton = driver.findElement(By.cssSelector(".place-order-button"));
        //placeOrderButton.click();
       // test.pass("Clicked on place order button");
    }
}
