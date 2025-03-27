package jenkinsintegration.standalone;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandaloneTest {
	@Test
	public void f() {
		Properties prop = new Properties();
		try {
			// Load the properties file
			prop.load(StandaloneTest.class.getClassLoader().getResourceAsStream("externalsystem.properties"));
			System.out.println("Property file loaded successfully---->");
			System.out.println("Property file key value----> " + prop.getProperty("browser"));
			System.out.println("Property file key value----> " + prop.getProperty("profile"));
			System.out.println("Property file key value----> " + prop.getProperty("os"));

			// Determine the browser type from System property or fallback to Chrome
			String browser = System.getProperty("browser") != null ? System.getProperty("browser"):prop.getProperty("browser");
					//: (prop.getProperty("browser") != null ? prop.getProperty("browser") : "chrome");

			if (browser.equalsIgnoreCase("chrome")) {
				System.out.println("Browser is Chrome-----> + added CICD");
				ChromeOptions options = new ChromeOptions();
				WebDriverManager.chromedriver().setup();
				options.addArguments("--disable-popup-blocking");

				WebDriver driver = new ChromeDriver(options);
				driver.get("https://rahulshettyacademy.com/seleniumPractise");
				driver.manage().window().maximize();
				Thread.sleep(3000); // Sleep for 3 seconds
				driver.quit();

			} else if (browser.equalsIgnoreCase("edge")) {
				System.out.println("Browser is Edge---> added CICD");
				EdgeOptions options = new EdgeOptions();
				WebDriverManager.edgedriver().setup();
				options.addArguments("--disable-popup-blocking");

				WebDriver driver = new EdgeDriver(options);
				driver.get("https://rahulshettyacademy.com/seleniumPractise");
				driver.manage().window().maximize();
				Thread.sleep(3000); // Sleep for 3 seconds
				driver.quit();
			} else {
				System.out.println("Unsupported browser: " + browser);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}