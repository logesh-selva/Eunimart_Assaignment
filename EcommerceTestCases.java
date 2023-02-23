import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EcommerceTestCases {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // set the webdriver path
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");

        // create a new ChromeDriver instance
        driver = new ChromeDriver();

        // maximize the window
        driver.manage().window().maximize();

        // navigate to the Ecommerce website
        driver.get("https://www.example.com");
    }

    @AfterMethod
    public void tearDown() {
        // close the browser
        driver.quit();
    }

    @Test
    public void verifyHomePageTitle() {
        // get the page title
        String pageTitle = driver.getTitle();

        // verify that the page title contains the expected text
        Assert.assertTrue(pageTitle.contains("Ecommerce Website"));
    }

    @Test
    public void verifySearchFunctionality() {
        // enter a search term in the search bar
        WebElement searchBox = driver.findElement(By.id("search-box"));
        searchBox.sendKeys("product name");

        // click the search button
        WebElement searchButton = driver.findElement(By.id("search-button"));
        searchButton.click();

        // verify that the search results page is displayed
        WebElement searchResultsTitle = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(searchResultsTitle.getText(), "Search Results for 'product name'");
    }

    @Test
    public void verifyProductDetailsPage() {
        // navigate to a product details page
        WebElement productLink = driver.findElement(By.linkText("Product Name"));
        productLink.click();

        // verify that the product details are displayed
        WebElement productName = driver.findElement(By.tagName("h1"));
        WebElement productPrice = driver.findElement(By.className("price"));
        Assert.assertEquals(productName.getText(), "Product Name");
        Assert.assertEquals(productPrice.getText(), "$99.99");
    }

    @Test
    public void verifyAddToCartFunctionality() {
        // navigate to a product details page
        WebElement productLink = driver.findElement(By.linkText("Product Name"));
        productLink.click();

        // add the product to the cart
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart"));
        addToCartButton.click();

        // verify that the product is added to the cart
        WebElement cartLink = driver.findElement(By.linkText("Cart"));
        cartLink.click();
        WebElement cartTotal = driver.findElement(By.className("total"));
        Assert.assertEquals(cartTotal.getText(), "$99.99");
    }
}
