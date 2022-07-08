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

	@FindBy(xpath = "//span[@class='dp-invalid-login-msg']")
	WebElement Errormsg1;

	@FindBy(xpath = "//input[@id='user_name']")
	WebElement username;

	@FindBy(xpath = "//input[@id='user_password']")
	WebElement password;

	@FindBy(xpath = "//button[@id='sysverb_login']")
	WebElement loginbtn;

	public LoginPage() {
		PageFactory.initElements(t.driver, this);
	}

	// Actions validate Title
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public HomePage LoginData(String un, String pass) throws InterruptedException {

		if (username.isDisplayed()) {

			System.out.println("UserName Field Displayed");

			username.sendKeys(un);

		} else {

			System.out.println("UserName Field Not Displayed");
		}
		System.out.println("UserName is  :" + un);

		System.out.println("Entered user name");

		System.out.println("-------------------------------------------------------------");

		System.out.println("Clicked On next Button");

		System.out.println("-------------------------------------------------------------");

		if (password.isEnabled()) {

			System.out.println("Password Field Enabled");

			password.sendKeys(pass);
		} else {

			System.out.println("Password Field Not Enabled");
		}
		System.out.println("Password is  :" + pass);

		System.out.println("Password Entered");

		System.out.println("-------------------------------------------------------------");

		if (loginbtn.isEnabled() && loginbtn.isDisplayed()) {

			System.out.println("LoginButton is Enabled and displayed ");

			loginbtn.click();

		} else {

			System.out.println("LoginButton is not Enabled not displayed");
		}

		System.out.println("Clicked On Login Button");

		System.out.println("-------------------------------------------------------------");

		String expectedUrl = driver.getCurrentUrl();

		System.out.println("entered home page & title is :" + expectedUrl);

		return new HomePage();
	}
}