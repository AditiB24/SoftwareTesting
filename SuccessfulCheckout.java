package introduction;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SuccessfulCheckout {

    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.password_manager_leak_detection", false);
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        try {
            System.out.println("Running: Script 3 - Successful Checkout");
            // Step 1: Login
            driver.get("https://www.saucedemo.com/");
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
            
            // Step 2: Add to Cart
            driver.findElement(By.cssSelector("button[data-test='add-to-cart-sauce-labs-backpack']")).click();
            driver.findElement(By.cssSelector("a[data-test='shopping-cart-link']")).click();
            
            // Step 3: Checkout Flow
            driver.findElement(By.cssSelector("#checkout")).click();
            driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Aditi");
            driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("B");
            driver.findElement(By.xpath("//input[@placeholder='Zip/Postal Code']")).sendKeys("404");
            driver.findElement(By.id("continue")).click();
            driver.findElement(By.id("finish")).click();
            
            if (driver.getCurrentUrl().contains("checkout-complete.html")) {
                System.out.println("Result: Order checked out successfully!");
            }
        } catch (Exception e) {
            System.err.println("Script 3 Failed: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}