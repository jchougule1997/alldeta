package com.sn.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.sn.Commons.TestBase;

public class LoginPage extends TestBase {

	TestBase t = new TestBase();
	
	@FindBy(id = "username")
	WebElement uname;
	
	@FindBy(id = "usernameSubmitButton")
	WebElement NextBtn;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "submitButton")
	WebElement Loginbtn;
	
	@FindBy(id = "errorPlaceholder")
	WebElement Errormsg1;
	
	public LoginPage()
	{
		PageFactory.initElements(t.driver, this);
	}
	
	
	public HomePage LoginData(String un, String pass) throws InterruptedException
	{
		
		uname.sendKeys(un);
		System.out.println(un);
		NextBtn.click();
		Thread.sleep(3000);
		password.sendKeys(pass);
		System.out.println(pass);
		Loginbtn.click();
	
		Thread.sleep(15000);
		return new HomePage();
		
	}
	
	public String Invalidlogin(String un, String pass)
	{
		
			uname.sendKeys(un);
			//System.out.println(un);
			NextBtn.click();
			password.sendKeys(pass);
			//System.out.println(pass);
			Loginbtn.click();
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(Errormsg1));
			
			String errormsg1 = Errormsg1.getText(); 
			System.out.println("Error message is:" +errormsg1);
			String expectederrormsg = "?Your username or password is invalid. Please try again or reset your password. If on mobile, please reset from your desktop device.";
			
			Assert.assertEquals(errormsg1, expectederrormsg, "Testcase passed");
			return errormsg1;
		
	
		
	}
	
	
	/*
	 * public String LoginVerify() { return LoginVerify }
	 */
	
	public String verifyLogin()
	{
		return t.driver.getTitle();
		
	}

}
