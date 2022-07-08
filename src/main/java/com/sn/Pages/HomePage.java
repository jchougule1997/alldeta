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

	@FindBy(xpath = "//a[@id='4fed4395c0a8016400fcf06c27b1e6c6']//div[@class='sn-widget-list-title'][normalize-space()='Incidents']")
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

		boolean typeIncident_Field = TypeIncident.isEnabled();

		System.out.println("Is TypeIncident_Field Enabled  :" + typeIncident_Field);

		TypeIncident.sendKeys("Incident");

		System.out.println("Entered Incident in Typenavigator_Field ");

		System.out.println("-------------------------------------------------------------");

		boolean clickSearch_Button = ClickSearch.isEnabled();

		System.out.println("Is clickSearch_Button Enabled  :" + clickSearch_Button);

		ClickSearch.click();

		System.out.println("Clicked on Incident");

		System.out.println("-------------------------------------------------------------");

		return new IncidentCreate();
	}

}
