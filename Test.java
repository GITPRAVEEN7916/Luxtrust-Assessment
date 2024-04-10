import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationPageTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Set up Selenium WebDriver
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");
        driver = new ChromeDriver();
        driver.get("url_of_registration_page");
    }

    @Test(priority = 1)
    public void tc44_testValidRegistration() {
        // Enter valid registration data
        driver.findElement(By.id("name")).sendKeys("Palli Praveen");
        driver.findElement(By.id("phoneNumber")).sendKeys("+352661110066");
        driver.findElement(By.id("email")).sendKeys("praveen.eee29@gmail.com");
        driver.findElement(By.id("userID")).sendKeys("praveen.eee29");
        driver.findElement(By.xpath("password")).sendKeys("praveen123");

        // Submit registration form
        driver.findElement(By.xpath("//div/button[@type='submit']")).click();

        // Handle JavaScript popup for the 
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		Assert.assertEquals(alertText, "Form Submitted successfully");

		// Click OK button
		alert.accept();
		import org.openqa.selenium.Alert;

		// Verify if the fields are cleared
		Assert.assertEquals(driver.findElement(By.id("name")).getText(), "");
		Assert.assertEquals(driver.findElement(By.id("phoneNumber")).getText(), "");
		Assert.assertEquals(driver.findElement(By.id("email")).getText(), "");
		Assert.assertEquals(driver.findElement(By.id("userID")).getText(), "");
		Assert.assertEquals(driver.findElement(By.id("password")).getText(), "");
    }
	
	
	@Test(priority = 2)
	public void tc39_testClearButton_Ok() {
		// Enter data into the registration form fields
        driver.findElement(By.id("name")).sendKeys("Palli Praveen");
        driver.findElement(By.id("phoneNumber")).sendKeys("+352661110066");
        driver.findElement(By.id("email")).sendKeys("praveen.eee29@gmail.com");
        driver.findElement(By.id("userID")).sendKeys("praveen.eee29");
        driver.findElement(By.xpath("password")).sendKeys("praveen123");

		// Click the clear button
		driver.findElement(By.id("clearBtn")).click();

		// Handle JavaScript popup
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		Assert.assertEquals(alertText, "Are you sure you want to clear the Form");

		// Accept the popup
		alert.accept();
		
		// Verify if the fields are cleared
		Assert.assertEquals(driver.findElement(By.id("name")).getText(), "");
		Assert.assertEquals(driver.findElement(By.id("phoneNumber")).getText(), "");
		Assert.assertEquals(driver.findElement(By.id("email")).getText(), "");
		Assert.assertEquals(driver.findElement(By.id("userID")).getText(), "");
		Assert.assertEquals(driver.findElement(By.id("password")).getText(), "");
	}
	
    @Test(priority = 3)
    public void tc38_testClearButton_Cancel() {
        // Enter data into the registration form fields
        driver.findElement(By.id("name")).sendKeys("Palli Praveen");
        driver.findElement(By.id("phoneNumber")).sendKeys("+352661110066");
        driver.findElement(By.id("email")).sendKeys("praveen.eee29@gmail.com");
        driver.findElement(By.id("userID")).sendKeys("praveen.eee29");
        driver.findElement(By.xpath("password")).sendKeys("praveen123");

		// Click the clear button
		driver.findElement(By.id("clearBtn")).click();

		// Handle JavaScript popup
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		Assert.assertEquals(alertText, "Are you sure you want to clear the Form");

		// Accept the popup
		alert.dismiss();

		// Verify if the fields are not cleared (since "Cancel" was clicked)
		Assert.assertEquals(driver.findElement(By.id("name")).getAttribute("value"), "Palli Praveen");
		Assert.assertEquals(driver.findElement(By.id("phone")).getAttribute("value"), "+352661110066");
		Assert.assertEquals(driver.findElement(By.id("email")).getAttribute("value"), "praveen.eee29@gmail.com");
		Assert.assertEquals(driver.findElement(By.id("userID")).getAttribute("value"), "praveen.eee29");
		Assert.assertEquals(driver.findElement(By.id("password")).getAttribute("value"), "praveen123");
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
