package ecom.testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(id="login2")
	@CacheLookup
	WebElement btnLogin;

	public WebDriver getLdriver() {
		return ldriver;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public WebElement getTxtUsername() {
		return txtUsername;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}


	@FindBy(id="loginusername")
	@CacheLookup
	WebElement txtUsername;
	
	@FindBy(id="loginpassword")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(xpath="//button[@onClick='logIn()']")
	@CacheLookup
	WebElement btnSubmit;

	
/*	public void setbtnSubmit() {
		btnSubmit.click();
	}
	public void setbtnLogin() {
		btnLogin.click();
	}
	public void settxtUsername() {
		txtUsername.sendKeys("sekargnanas");
	}
	public void settxtPassword() {
		txtPassword.sendKeys("admin");
	}*/

}
