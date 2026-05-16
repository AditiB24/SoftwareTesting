package introduction;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SuccessfulLogin {

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
            System.out.println("Running: Script 1 - Successful Login");
            driver.get("https://www.saucedemo.com/");
            
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
            
            if (driver.getCurrentUrl().contains("inventory.html")) {
                System.out.println("Result: Login Successful!");
            }
        } catch (Exception e) {
            System.err.println("Script 1 Failed: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}