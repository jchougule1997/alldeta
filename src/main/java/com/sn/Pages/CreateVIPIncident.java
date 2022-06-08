package com.sn.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sn.Commons.TestBase;


public class CreateVIPIncident extends TestBase{
	
	@FindBy(xpath="//div[@data-id='4fed4395c0a8016400fcf06c27b1e6c6']")
	WebElement incidents;
	
	@FindBy(xpath="//a[contains(text(), 'Inquiry / Help')]")
	WebElement InquiryHelp;
	
	@FindBy(id = "sysverb_new")
	WebElement CreateNewIncident;
	
	@FindBy(id = "sys_display.incident.caller_id")
	WebElement caller;
	
	@FindBy(id= "incident.impact")
	WebElement impact;
	
	@FindBy(id= "incident.urgency")
	WebElement urgency;
	
	@FindBy(id= "incident.state")
	WebElement state;
	
	@FindBy(id= "incident.priority")
	WebElement priority;

	@FindBy(id = "incident.short_description")
	WebElement ShortDescription;

	@FindBy(id = "sysverb_insert_bottom")
	WebElement Submit;
	
	@FindBy(xpath="//input[@class='form-control']")
	WebElement Searchnumber;
	
	@FindBy(id = "incident.number")
	WebElement Incidentnumber;
	
	@FindBy(xpath="//input[@id='sys_display.incident.caller_id']")
	WebElement VipCaller;
	
	@FindBy(xpath="//option[contains(text(), '1 - Critical')]")
	WebElement criticaloption;
	
	@FindBy(xpath=("//span[normalize-space()='Resolution Information']"))
	WebElement ClickResInfo;
	
	@FindBy(id=("incident.close_code"))
	WebElement IncidentClose;
	
	@FindBy(id=("incident.close_notes"))
	WebElement ClickCloseNotes;
	
	@FindBy(xpath=("//button[@id='resolve_incident']"))
	WebElement ResolveIncident;
	
	

	
	TestBase t = new TestBase();
	HomePage hp=new HomePage();
	
	public CreateVIPIncident() {
		PageFactory.initElements(t.driver, this);

	}
	public String verifyIncidentPage()
	{
		return t.driver.getTitle();
	}
	
	public void ClickonNewButton() throws InterruptedException
	{
		driver.switchTo().frame("gsft_main");
		System.out.println("Click on new button");
		CreateNewIncident.click();
		
	}
	
	
	public void VIPIncident(String Caller, String Shortdescription) throws InterruptedException {
		String IncidentNo = Incidentnumber.getAttribute("value");
		System.out.println(IncidentNo);
		caller.clear();
		
        System.out.println("Entering Caller name : " + Caller);
		caller.sendKeys(Caller);
		/*
		 * WebDriverWait wait= new WebDriverWait(driver, 30);
		 * wait.until(ExpectedConditions.visibilityOfAllElements(caller));
		 */
		Thread.sleep(3000);

		//t.getText(caller);
		ShortDescription.clear();
		System.out.println("Entering shortDescription : " + Shortdescription);
		ShortDescription.sendKeys(Shortdescription);
		t.dropdown(state, 1);
		t.dropdown(impact, 0);
		t.dropdown(urgency, 0);
		

		String Style=caller.getAttribute("style");
		System.out.println("Caller display in " + Style  );
		String expected="color: red;";
		String actual=Style;

		if(actual.equals(expected)) { 
			 // System.out.println("Caller display in " + Style  );
			  System.out.println("Caller is VIP"); 
			  } else {
		  System.out.println("Caller  is not VIP"); }
		 

		
	   //Priority should be select automatically critical once impact and urgency done high
		String expectedoption="1 - Critical";
		String actualOption=criticaloption.getText();
		//System.out.println(actualOption);
		if(expectedoption.equals(actualOption)) {
		System.out.println(actualOption + ": Priority automatically set critical" );
		}
		else {
			System.out.println("Priority is not set critical");
		}
		//Submit incident
		System.out.println("Submit incident");
	    Submit.click();
		
	    //search incident in search box which is created		

		Searchnumber.sendKeys(IncidentNo);
		Searchnumber.sendKeys(Keys.ENTER);
		
		//checking created incident is actually created or not
		
		String expectedIncidentno=IncidentNo;
		String actualIncidentno=driver.findElement(By.xpath("/html/body/div[1]/div[1]/span/div/div[5]/table/tbody/tr/td/div/table/tbody/tr/td[4]")).getText();
		System.out.println(actualIncidentno+ " : This number of incident is successfully created");
	    if(expectedIncidentno.equals(actualIncidentno)) {
	    	System.out.println("Incident is Successfully Created....");
	    }
	    else{
	    	System.out.println("Incident is not Created....");
	    }
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * public void resolveIncident(String ResolveNotesData) { InquiryHelp.click();
	 * t.dropdown(state, 3); JavascriptExecutor js = (JavascriptExecutor) driver;
	 * //js.executeScript("window.scrollBy(0,550)", "");
	 * js.executeScript("arguments[0].scrollIntoView();", ClickResInfo);
	 * ClickResInfo.click(); t.dropdown(IncidentClose, 7); ClickCloseNotes.clear();
	 * ClickCloseNotes.sendKeys(ResolveNotesData); ResolveIncident.click();
	 * ///return new IncidentResolve(); }
	 */
	//String expected=Style;
	//String actual=driver.findElement(By.xpath("//input[@style='color: red;']")).getText();
	/*
	 * if(expected.equals(actual)) { System.out.println("Caller is VIP"); } else {
	 * System.out.println("Caller not is VIP"); }
	 */



}
