import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartRegistrationTest {

    public static void main(String[] args) {

        // Set the system property for the Chrome driver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        // Test case 1: Verify that the user is able to navigate to the registration page
        driver.get("https://www.flipkart.com/");
        WebElement loginLink = driver.findElement(By.xpath("//a[text()='Login']"));
        loginLink.click();
        WebElement signUpLink = driver.findElement(By.xpath("//a[text()='New to Flipkart? Create an account']"));
        signUpLink.click();
        WebElement registrationForm = driver.findElement(By.xpath("//span[text()='Sign Up']"));
        assert registrationForm.isDisplayed();

        // Test case 2: Verify that the user is able to enter valid registration information
        WebElement firstNameField = driver.findElement(By.xpath("//input[@name='firstName']"));
        firstNameField.sendKeys("John");
        WebElement lastNameField = driver.findElement(By.xpath("//input[@name='lastName']"));
        lastNameField.sendKeys("Doe");
        WebElement emailField = driver.findElement(By.xpath("//input[@name='email']"));
        emailField.sendKeys("johndoe@test.com");
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        passwordField.sendKeys("password123");
        WebElement signUpButton = driver.findElement(By.xpath("//button[text()='Sign Up']"));
        signUpButton.click();

        // Test case 3: Verify that the user is redirected to the home page after successful registration
        WebElement homePage = driver.findElement(By.xpath("//h1[text()='My Account']"));
        assert homePage.isDisplayed();

        // Close the browser
        driver.quit();
    }
}
