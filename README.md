# SauceDemo QA Automation Assignment

This repository contains Selenium WebDriver automation scripts for the SauceDemo website. The code is written in Java and managed using Eclipse.

---

## Automated Scenarios

The original workflow has been split into 3 separate, independent scripts so they can be run individually:

1. **Successful Login (`SuccessfulLogin.java`)**
   * Opens the browser, logs into SauceDemo with valid credentials, and checks if the homepage (`inventory.html`) loads successfully.
2. **Add Product to Cart (`AddProductToCart.java`)**
   * Logs in automatically, adds the "Sauce Labs Backpack" to the shopping cart, and opens the cart page to verify the action.
3. **Successful Checkout (`SuccessfulCheckout.java`)**
   * Runs the complete end-to-end flow: logs in, adds the item to the cart, proceeds to checkout, fills out the information form (First Name, Last Name, Zip Code), and completes the order.

---

## Tech Stack & Setup Details

* **Language:** Java
* **Tool:** Selenium WebDriver 4
* **Browser:** Google Chrome (ChromeDriver)

*Note: All scripts include ChromeOptions configuration to disable Chrome's automatic password manager popups, ensuring the tests run cleanly without interruptions.*

---

## How to Set Up and Run the Project

### Prerequisites
* Java JDK (Version 11 or higher) installed.
* Google Chrome installed.
* Eclipse IDE.
* Selenium standalone jar files added to your project's Build Path.

### Step 1: Clone the Repo
Open your terminal or Git Bash and run:
```bash
git clone [https://github.com/AditiB24/SoftwareTesting.git](https://github.com/AditiB24/SoftwareTesting.git)
