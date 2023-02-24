// Import the necessary packages
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetPageTitle {
    public static void main(String[] args) {
        // Set the path of the ChromeDriver executable file
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the webpage
        driver.get("https://www.example.com");

        // Get the title of the webpage
        String title = driver.getTitle();

        // Print the title to the console
        System.out.println("The title of the webpage is: " + title);

        // Close the browser
        driver.quit();
    }
}
