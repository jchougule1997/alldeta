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

	public HomePage LoginData(String un, String pass) throws InterruptedException {

		username.sendKeys(un);

		System.out.println(un);

		password.sendKeys(pass);

		System.out.println(pass);

		loginbtn.click();

		return new HomePage();

	}

	public String verifyLogin() {

		return t.driver.getTitle();

	}

}
