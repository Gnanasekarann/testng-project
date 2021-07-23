package ecom.testng.base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseElements {
	
	public static WebDriver driver;
	
	  @BeforeClass
	public static WebDriver browserLaunch() {
		System.setProperty("webdriver.gecko.driver", "D:\\Users\\gnanas\\eclipse-workspace\\ecom.testng\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://live.demoguru99.com/index.php/");
		return driver;
	}
	
	  @AfterClass
	  public void teardown() {
		  System.out.println("Finished");
	}

}
	
	
