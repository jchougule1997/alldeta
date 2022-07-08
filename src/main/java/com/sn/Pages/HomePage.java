package com.sn.Pages;

import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sn.Commons.TestBase;
import com.sn.utilities.ExcelUtilities;

public class HomePage extends TestBase {
	TestBase t = new TestBase();

	@FindBy(id = "filter")
	WebElement TypeIncident;

	@FindBy(xpath = "//*[@id=\"087800c1c0a80164004e32c8a64a97c9\"]/div/div")
	WebElement ClickSearch;

	public HomePage() {
		PageFactory.initElements(t.driver, this);
	}

	public String VerifyTitle() {
		return t.driver.getTitle();

	}

	public IncidentCreate SearchIncident() throws InterruptedException {

		// Switch to new tab
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(0));
		System.out.println(tabs2);

		TypeIncident.sendKeys("Incident");
		ClickSearch.click();
		System.out.println("Clicked on Incident");
		if (ClickSearch.isDisplayed()) {
			System.out.println("Testcase passed and clicked on incident");
		} else {
			System.out.println("Not able to click on incident. Test case failed.");
		}

		return new IncidentCreate();
	}

}
