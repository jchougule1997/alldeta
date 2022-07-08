package com.sn.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.sn.Commons.TestBase;

import junit.framework.Assert;

public class IncidentCreate extends TestBase {

	@FindBy(id = "sysverb_new")
	WebElement CreateNewIncident;

	@FindBy(id = "sys_display.incident.caller_id")
	WebElement caller;

	@FindBy(id = "incident.category")
	WebElement Category;

	@FindBy(id = "incident.subcategory")
	WebElement SubCategory;

	@FindBy(id = "sys_display.incident.business_service")
	WebElement Service;

	@FindBy(id = "sys_display.incident.service_offering")
	WebElement ServiceOffering;

	@FindBy(id = "sys_display.incident.cmdb_ci")
	WebElement ConfigurationItem;

	@FindBy(id = "incident.short_description")
	WebElement ShortDescription;

	@FindBy(id = "sysverb_insert_bottom")
	WebElement Submit;

	@FindBy(xpath = "//*[@id=\"list_nav_incident\"]/div/div[1]/h1/a")
	WebElement IncidentCreate;

	@FindBy(id = "incident.number")
	WebElement Incidentnumber;

	@FindBy(linkText = "Inquiry / Help")
	WebElement Incidentlink;

	@FindBy(xpath = "//*[@id=\"section-bf1d96e3c0a801640190725e63f8ac80.header\"]/nav/div/div[1]/button[2]")
	WebElement IncidentOptions;

	@FindBy(xpath = "//*[@id=\"context_1\"]/div[8]")
	WebElement CreateChildIncident;

	@FindBy(xpath = "//*[@id=\"tabs2_list\"]/span[4]/span/span[2]")
	WebElement Childincidenttab;

	@FindBy(xpath = "/html/body/div[1]/div[1]/span/div/div[1]/div/span/div/div/input")
	WebElement Searchnumber;

	@FindBy(xpath = "//span[@class=\"outputmsg_text\"]")
	WebElement resolveNoteMsg;

	@FindBy(how = How.XPATH, using = "//input[@id='incident.short_description']")
	WebElement shortdiscr1;

	public IncidentCreate() {
		PageFactory.initElements(driver, this);
	}

	public String verifyIncidentPage() {
		return IncidentCreate.getText();
	}

	public void ClickonNewButton() throws InterruptedException {
		driver.switchTo().frame("gsft_main");
		CreateNewIncident.click();

	}

	public void CreateNewIncident(String Caller, String Shortdescription) throws InterruptedException {
		String IncidentNo = Incidentnumber.getAttribute("value");

		System.out.println(IncidentNo);

		caller.clear();

		Thread.sleep(1000);
		// WebDriverWait wait = new WebDriverWait(driver, 10);//explicit wait are used
		// wait.until(ExpectedConditions.visibilityOf(caller));
		caller.sendKeys(Caller);
		// kept blank one of the mandatory field
		if (Shortdescription.isBlank() || Caller.isBlank()) {

			Submit.click();

			String errmsg = resolveNoteMsg.getText();

			System.out.println("Error massage is      :" + errmsg);

			System.out.println(
					"********Mandotory input of Shortdescription is not availble in Excel File Name is TestData1 and sheet name is ChildIncidentData *******");
			Assert.assertEquals(false, true);

			driver.quit();
		} else {
			ShortDescription.sendKeys(Shortdescription);

			System.out.println("Shortdescription Info is entered");

		}

		Submit.click();

		System.out.println("Incident Created successfully");

	}

	public void ClickonChildIncident() throws InterruptedException {

		System.out.println("Create child incident Test");

		Incidentlink.click();

		System.out.println("Incident link clicked");

		Thread.sleep(3000);
		// WebDriverWait wait = new WebDriverWait(driver, 10);//explicit wait are used
		// wait.until(ExpectedConditions.visibilityOf(IncidentOptions));
		IncidentOptions.click();

		System.out.println("Clicked on incident more options");

		CreateChildIncident.click();

		System.out.println("Clicked on Create child incident");

	}

	public void CreatechildIncident(String Caller, String childshortdescr) throws InterruptedException {

		String ChildIncidentnum = Incidentnumber.getAttribute("value");

		System.out.println("The child incident is:" + ChildIncidentnum);

		caller.clear();

		caller.sendKeys(Caller);

		Submit.click();

		System.out.println("Child incident created successfully");

		Childincidenttab.click();

	}

}
