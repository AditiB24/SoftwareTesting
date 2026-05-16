package introduction;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AddProductToCart {

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
            System.out.println("Running: Script 2 - Add Product To Cart");
            // Step 1: Pre-requisite Login
            driver.get("https://www.saucedemo.com/");
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
            
            // Step 2: Add to Cart Action
            driver.findElement(By.cssSelector("button[data-test='add-to-cart-sauce-labs-backpack']")).click();
            driver.findElement(By.cssSelector("a[data-test='shopping-cart-link']")).click();
            
            if (driver.getCurrentUrl().contains("cart.html")) {
                System.out.println("Result: Product added to cart successfully!");
            }
        } catch (Exception e) {
            System.err.println("Script 2 Failed: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}