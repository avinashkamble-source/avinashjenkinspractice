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
		  prop.load(StandaloneTest.class.getClassLoader().getResourceAsStream("externalsystem.properties"));
		  System.out.println("Property file loaded successfully---->");
		  System.out.println("Property file key value---->" + prop.getProperty("browser"));
		  System.out.println("Property file key value---->" + prop.getProperty("profile"));
		  System.out.println("Property file key value---->" + prop.getProperty("os"));
		  
		  if(System.getProperty("browser").equalsIgnoreCase("chrome")) {
			  System.out.println("Browser is Chrome----->");
			  ChromeOptions options = new ChromeOptions();
			  WebDriverManager.chromedriver().setup();
			//  options.addArguments("--headless");
			  options.addArguments("--disable-popup-blocking");
			  
			  WebDriver driver = new ChromeDriver(options);
			  driver.get("https://rahulshettyacademy.com/seleniumPractise");
			  driver.quit();
			  
		  } else {
			  System.out.println("Browser is Edge--->");
			  EdgeOptions options = new EdgeOptions();
			  WebDriverManager.edgedriver().setup();
			 // options.addArguments("--headless");
			  options.addArguments("--disable-popup-blocking");
			  
			  WebDriver driver = new EdgeDriver(options);
			  driver.get("https://rahulshettyacademy.com/seleniumPractise");
			  driver.manage().window().maximize();
			  driver.quit();
		  }
	  } catch (Exception e) {
		  e.printStackTrace();
	  }
  }
}
