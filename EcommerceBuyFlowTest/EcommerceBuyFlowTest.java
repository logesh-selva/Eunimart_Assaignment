import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EcommerceBuyFlowTest {

    public static void main(String[] args) {

        // Set the system property for the Chrome driver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        // Test case 1: Verify that the user is able to search for a product
        driver.get("http://www.example.com");
        WebElement searchBox = driver.findElement(By.id("search-box"));
        searchBox.sendKeys("product name");
        WebElement searchButton = driver.findElement(By.id("search-button"));
        searchButton.click();
        WebElement productLink = driver.findElement(By.xpath("//a[contains(text(),'Product Name')]"));
        productLink.click();

        // Test case 2: Verify that the user is able to navigate to the product details page
        WebElement productDetails = driver.findElement(By.className("product-details"));
        assert productDetails.isDisplayed();

        // Test case 3: Verify that the user is able to add a product to the cart
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart"));
        addToCartButton.click();
        WebElement cartIcon = driver.findElement(By.className("cart-icon"));
        assert cartIcon.getText().equals("1");

        // Test case 4: Verify that the user is able to view the cart and modify the product quantity
        cartIcon.click();
        WebElement cartPage = driver.findElement(By.className("cart-page"));
        assert cartPage.isDisplayed();
        WebElement quantityField = driver.findElement(By.id("quantity"));
        quantityField.clear();
        quantityField.sendKeys("2");
        WebElement updateCartButton = driver.findElement(By.id("update-cart"));
        updateCartButton.click();
        WebElement subtotalPrice = driver.findElement(By.id("subtotal-price"));
        assert subtotalPrice.getText().equals("$200.00");

        // Test case 5: Verify that the user is able to proceed to checkout
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
        WebElement checkoutPage = driver.findElement(By.className("checkout-page"));
        assert checkoutPage.isDisplayed();

        // Test case 6: Verify that the user is able to enter shipping and billing information
        WebElement firstNameField = driver.findElement(By.id("first-name"));
        firstNameField.sendKeys("John");
        WebElement lastNameField = driver.findElement(By.id("last-name"));
        lastNameField.sendKeys("Doe");
        WebElement addressField = driver.findElement(By.id("address"));
        addressField.sendKeys("123 Main St");
        WebElement cityField = driver.findElement(By.id("city"));
        cityField.sendKeys("Anytown");
        WebElement stateField = driver.findElement(By.id("state"));
        stateField.sendKeys("CA");
        WebElement zipCodeField = driver.findElement(By.id("zip-code"));
        zipCodeField.sendKeys("12345");
        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();
        WebElement paymentPage = driver.findElement(By.className("payment-page"));
        assert paymentPage.isDisplayed();

        // Test case 7: Verify that the user is able to select a payment method and complete the purchase
        WebElement creditCardButton = driver.findElement(By.id("credit-card"));
        creditCardButton.click();
        WebElement cardNumberField = driver.findElement(By.id("card-number"));
        cardNumberField.sendKeys("1234567890123456");
        WebElement expirationDateField = driver.findElement(By.id("expiration-date"));
        expirationDateField.sendKeys("12/22");
        WebElement security
