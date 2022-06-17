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
	
	@FindBy(xpath="//span[contains(text(), 'The following mandatory fields are not filled in: Short description')]")
	WebElement Short_Description_ErrorMsg;
	
	@FindBy(xpath="//span[contains(text(), 'The following mandatory fields are not filled in: Caller')]")
	WebElement caller_ErrorMsg;

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
	 

	
	@FindBy(xpath="/html/body/div[1]/div[1]/span/div/div[5]/table/tbody/tr/td/div/table/tbody/tr/td[4]")
	WebElement incident_No_AfterCreated;



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
		//System.out.println(IncidentNo);
		boolean Caller_Text_Field=caller.isDisplayed();
		System.out.println("is caller_text isdisplayed  :" + Caller_Text_Field);
		caller.clear();
        System.out.println("Entering Caller name : " + Caller);
		caller.sendKeys(Caller);
		
		System.out.println("=================================================================");
		/*
		 * WebDriverWait wait= new WebDriverWait(driver, 30);
		 * wait.until(ExpectedConditions.visibilityOfAllElements(caller));
		 */
		Thread.sleep(3000);
		boolean ShortDescription_Text_Field=ShortDescription.isDisplayed();
		System.out.println("is ShortDescription_Text_Field isdisplayed  :" + ShortDescription_Text_Field);
		ShortDescription.clear();
		String short_decp=ShortDescription.getText();
		System.out.println("Entering shortDescription : " + Shortdescription);
		ShortDescription.sendKeys(Shortdescription);
		
		
		System.out.println("==============================================================");
		boolean State_Text_Field=state.isDisplayed();
		System.out.println("is state_Text_Field isdisplayed  :" + State_Text_Field);
        t.dropdown(state, 1);
        System.out.println("Selecting state in progess");
        System.out.println("================================================================");
        
        boolean Impact_Text_Field=impact.isDisplayed();
        System.out.println("is impact_Text_Field isdisplayed  :" + Impact_Text_Field);
		t.dropdown(impact, 0);
		System.out.println("selecting impact high");
        System.out.println("================================================================");
        
        boolean Urgency_Text_Field=urgency.isDisplayed();
        System.out.println("is urgency_Text_Field isdisplayed  :" + Urgency_Text_Field);
		System.out.println("selecting urgency high");
		t.dropdown(urgency, 0);
        System.out.println("================================================================");
		
        
		//Priority should be select automatically critical once impact and urgency done high

		boolean Priority_Option=priority.isDisplayed();
		System.out.println("is Priority_Option is displayed :" + Priority_Option);
		
		System.out.println("Checking priority is automatically set critical or not......");
		String expectedoption="1 - Critical";
		String actualOption=criticaloption.getText();
		//System.out.println(actualOption);
				if(actualOption.equals(expectedoption)) {
					System.out.println("Priority automatically set critical" );
				}
				else {
					System.out.println("Priority is not set critical");
				}
		System.out.println("====================================================================");		
		
		

		//caller should be display in red colour

		String color=caller.getAttribute("style");
		
		System.out.println("Caller display in " + color  );

		String actual=color; 
		 
		if(actual.equalsIgnoreCase("color: red;")) { 
			System.out.println("Caller is VIP"); 
		} else {
			System.out.println("Caller is not VIP"); 
		}
        System.out.println("================================================================");
       
		boolean submit_Button=Submit.isEnabled();
		System.out.println("is submit_Botton isenabled :" + submit_Button);
		Submit.click();
		System.out.println("After Submit button click incident will be submited.....");
		System.out.println("===============================================================");
		System.out.println("Submit incident");



		//search incident in search box which is created		
        System.out.println("Search for incident which is created........");
		Searchnumber.sendKeys(IncidentNo);
		Searchnumber.sendKeys(Keys.ENTER);
		

		//checking created incident is actually created or not

		String expectedIncidentno=IncidentNo;
		String actualIncidentno=incident_No_AfterCreated.getText();
		System.out.println(actualIncidentno+ " : This number of incident is successfully created");
		if(expectedIncidentno.equals(actualIncidentno)) {
			System.out.println("Incident is Successfully Created....");
		}
		else{
			System.out.println("Incident is not Created....");
		}



	}

}
