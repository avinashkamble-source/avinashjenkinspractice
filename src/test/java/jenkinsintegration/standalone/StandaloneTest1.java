package jenkinsintegration.standalone;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandaloneTest1 {
  @Test
  public void f() {
	  
	  Properties prop = new Properties();
	  try {
		  prop.load(StandaloneTest1.class.getClassLoader().getResourceAsStream("externalsystem.properties"));
		  System.out.println(" StandaloneTest1 Property file loaded successfully---->");
		  System.out.println(" StandaloneTest1 Property file key value---->" + prop.getProperty("browser"));
		  System.out.println(" StandaloneTest1 Property file key value---->" + prop.getProperty("profile"));
		  System.out.println(" StandaloneTest1 Property file key value---->" + prop.getProperty("os"));
		  
		  if(System.getProperty("browser").equalsIgnoreCase("chrome")) {
			  System.out.println("StandaloneTest1Browser is Chrome-----> + added CICD");
			  ChromeOptions options = new ChromeOptions();
			  WebDriverManager.chromedriver().setup();
			//  options.addArguments("--headless");
			  options.addArguments("--disable-popup-blocking");
			  
			  WebDriver driver = new ChromeDriver(options);
			  driver.get("https://rahulshettyacademy.com/seleniumPractise");
			  driver.quit();
			  
		  } else {
			  System.out.println("StandaloneTest1 Browser is Edge---> added CICD");
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
