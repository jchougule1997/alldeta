package com.sn.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sn.Commons.TestBase;

public class InProgress extends TestBase {
	TestBase t = new TestBase();

	@FindBy(linkText = ("Inquiry / Help"))
	WebElement LinkText;

	@FindBy(xpath = "//button[@id='sysverb_update']")
	WebElement Update;

	// Initializing the Page Objects
	public InProgress() {
		PageFactory.initElements(t.driver, this);
	}

	// Action:-
	public String VerifyTitle() {
		return t.driver.getTitle();

	}

	public OnHoldInfo InProgressState() throws InterruptedException {

		LinkText.click();

		Select drpState = new Select(driver.findElement(By.name("incident.state")));

		drpState.selectByVisibleText("In Progress");

		System.out.println("Selected element: " + drpState);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,550)", "");

		Update.click();

		return new OnHoldInfo();

	}

}
