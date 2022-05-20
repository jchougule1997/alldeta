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

public class HomePage extends TestBase
{
	TestBase t = new TestBase();
	//ExcelUtilities ex = new ExcelUtilities();

	@FindBy(id = "filter")
	WebElement TypeIncident;

	@FindBy(xpath = "//a[@id='4fed4395c0a8016400fcf06c27b1e6c6']//div[@class='sn-widget-list-title'][normalize-space()='Incidents']")
	WebElement ClickSearch;

	public HomePage()
	{
		PageFactory.initElements(t.driver, this);
	}

	public String VerifyTitle()
	{
		return t.driver.getTitle();

	}


	public IncidentCreate SearchIncident() throws InterruptedException 
	{
		System.out.println("-------------------------------------------------------------");
		Thread.sleep(10000);
		String drpdwn = "document.querySelector(\"body > dps-app\").shadowRoot.querySelector(\"div > header > dps-navigation-header\").shadowRoot.querySelector(\"header > div > div.dps-navigation-header-utility > ul > li:nth-child(2) > dps-login\").shadowRoot.querySelector(\"div > button\")"+ ".click()";
		((JavascriptExecutor)driver).executeScript(drpdwn);


		//Clicking on start build
		//Shadow-root element


		Thread.sleep(10000);

		String StartBuild = "document.querySelector(\"body > dps-app\").shadowRoot.querySelector(\"div > header > dps-navigation-header\").shadowRoot.querySelector(\"header > dps-navigation-header-dropdown > dps-navigation-login-management\").shadowRoot.querySelector(\"dps-navigation-header-dropdown-content > dps-navigation-section:nth-child(1) > dps-navigation-instance-management\").shadowRoot.querySelector(\"div > div:nth-child(2) > dps-content-stack:nth-child(5) > dps-button\").shadowRoot.querySelector(\"button\")" + ".click()";
		((JavascriptExecutor)driver).executeScript(StartBuild);
		System.out.println("Clicked on start build Button");
		System.out.println("-------------------------------------------------------------");


		//Switch to new tab
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		System.out.println(tabs2);

		//input[@id='filter']

		//Thread.sleep(5000);
		//Enter incident for search
		// TypeIncident.sendKeys(FilterNavigator);
		boolean typeIncident_Field =TypeIncident.isEnabled();
		System.out.println("Is TypeIncident_Field Enabled  :"+ typeIncident_Field);

		TypeIncident.sendKeys("Incident");
		//Thread.sleep(3000);

		System.out.println("Entered Incident in Typenavigator_Field ");
		System.out.println("-------------------------------------------------------------");

		boolean clickSearch_Button =ClickSearch.isEnabled();
		System.out.println("Is clickSearch_Button Enabled  :"+  clickSearch_Button);
		ClickSearch.click();
		System.out.println("Clicked on Incident");
		//Thread.sleep(5000);

		System.out.println("-------------------------------------------------------------");
		/*ClickSearch.click();
		System.out.println("Clicked on Incident");
		Thread.sleep(5000);*/

		return new IncidentCreate();
	}





}
