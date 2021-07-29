package ecom.testng.test;




import java.beans.beancontext.BeanContextServiceRevokedListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import ecom.testng.base.BaseElements;




public class NewTest extends BaseElements {
	

  @Test(enabled=false)
  public void TestCase_01() {
	BaseElements.browserLaunch();  
	BaseElements.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	boolean title = BaseElements.driver.getPageSource().contains("This is demo site");
	Assert.assertEquals(title, true);
	BaseElements.driver.findElement(By.linkText("MOBILE")).click();
	String title2 = BaseElements.driver.getTitle();
	Assert.assertEquals(title2, "Mobile");
	Select s = new Select(driver.findElement(By.xpath("(//*[@title='Sort By'])[1]")));
	s.selectByIndex(1);
	List<WebElement> list = driver.findElements(By.xpath("//*[@class='products-grid products-grid--max-4-col first last odd']//li//h2"));
/*	List<WebElement> list = driver.findElements(By.xpath("//*[@class='products-grid products-grid--max-4-col first last odd']//following::a"));
*/	ArrayList<String> obtainedlist = new ArrayList<String>();
	for (WebElement webElement : list) {
		String text = webElement.getText();
		obtainedlist.add(text);
	}
	ArrayList<String> sortedList = new ArrayList<String>();   
	for(String s1:obtainedlist){
	sortedList.add(s1);
	}
	Collections.sort(sortedList);
	Assert.assertTrue(sortedList.equals(obtainedlist));
  }
  
  @Test(enabled=false)
  public void TestCase_02() {
		BaseElements.browserLaunch();  
		BaseElements.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		BaseElements.driver.findElement(By.linkText("MOBILE")).click();
		
		List<WebElement> products = driver.findElements(By.xpath("//ul[@class='products-grid products-grid--max-4-col first last odd']//h2//a"));
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getText().equalsIgnoreCase("sony xperia")) {
			}
		}
		String listPrice = driver.findElement(By.id("product-price-1")).getText();
		driver.findElement(By.xpath("//*[@title='Sony Xperia']")).click();
		String productPrice = driver.findElement(By.id("product-price-1")).getText();
		System.out.println(productPrice);
    	Assert.assertEquals(productPrice, listPrice);
}
  
  @Test
  public void TestCase_03() throws InterruptedException {
	  BaseElements.browserLaunch();  
		BaseElements.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		BaseElements.driver.findElement(By.linkText("MOBILE")).click();
		List<WebElement> products = driver.findElements(By.xpath("//ul[@class='products-grid products-grid--max-4-col first last odd']//h2//a"));
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getText().equalsIgnoreCase("sony xperia")) {
				driver.findElement(By.xpath("//*[@class='button btn-cart']")).click();
			}
		}
		driver.navigate().refresh();
	    driver.findElement(By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[4]/input")).clear();	    
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div/div/form/table/tbody/tr/td[4]/input")));
		webElement.sendKeys("1000");
		driver.findElement(By.linkText("Update")).click();
		driver.findElement(By.linkText("Empty Cart")).click();
	  	driver.close();
}
 
}
