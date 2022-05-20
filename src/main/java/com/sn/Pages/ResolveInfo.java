package com.sn.Pages;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.sn.Commons.TestBase;

public class ResolveInfo extends TestBase
{

	TestBase t = new TestBase();
	
	
	
	@FindBy(xpath=("//span[normalize-space()='Resolution Information']"))
	WebElement ClickResInfo;
	
	@FindBy(id=("incident.close_code"))
	WebElement IncidentClose;
	
	@FindBy(id=("incident.close_notes"))
	WebElement ClickCloseNotes;
	
	@FindBy(xpath=("//button[@id='resolve_incident']"))
	WebElement ResolveIncident;
	
	@FindBy(xpath=("//input[@id='filter']"))
	WebElement typeResolve; 
	
	@FindBy(xpath = "/html/body/div[1]/div[1]/span/div/div[1]/div/span/div/div/input")
	WebElement SearchButton;
	
	@FindBy(id = "incident.number")
	WebElement Incidentnumber;
	
	@FindBy(linkText=("Inquiry / Help"))
	WebElement InquiryHelp;
	
	@FindBy(xpath="//select[@id='incident.state']")
	WebElement stateChk;
	
	@FindBy(xpath = "//select[@id='incident.state']")
	WebElement stateText;
	//select[@id='incident.state']
	//Initializing the Page Objects
	public ResolveInfo()
	{
		PageFactory.initElements(t.driver, this);
	}
	
	//Action:-
	public String VerifyTitle()
	{
	return t.driver.getTitle();
	
	}
	
	public  IncidentResolve ResolveIncident(String caller,String shortdiscription,String ResolveNotesData) throws InterruptedException 
	{
		//sysverb.click();
		//Thread.sleep(1000);
		
	    //driver.switchTo().frame(0);
	    //driver.findElement(By.linkText("INC0000003")).click();
		//Thread.sleep(1000);
		//Sort.click();
		//LinkText.click();
		
		
		String IncidentNo = Incidentnumber.getAttribute("value");
		System.out.println("New Incident Number" +IncidentNo);
		ClickResInfo.click();
		
		Select drpState = new Select(driver.findElement(By.name("incident.state")));
		drpState.selectByVisibleText("In Progress");
		System.out.println("Selected element: " + drpState);
		

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,550)", "");
		
		WebElement listbox=driver.findElement(By.id("incident.close_code"));
		Select select=new Select(listbox);
		select.selectByIndex(3);
		//System.out.println("ListBosElement" +select);
		
		IncidentClose.click();
		System.out.println("Click  On IncidentCloseCode Option");
		System.out.println("-------------------------------------------------------------");
		ClickCloseNotes.clear();
		System.out.println("Click  On Resolve Notesn");
		System.out.println("-------------------------------------------------------------");
		ClickCloseNotes.sendKeys(ResolveNotesData);
		System.out.println("Passed input in ResolveNotes field from EXEL");
		System.out.println("Clicked On Resolve Button");
		System.out.println("-------------------------------------------------------------");
		ResolveIncident.click();
		
		//click on search button for weather incident resolve or not
		SearchButton.sendKeys(IncidentNo);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		InquiryHelp.click();
		Select select1 = new Select(stateText);
		WebElement option = select1. getFirstSelectedOption();
		String defaultItem = option. getText();
		String exptState="Resolved";
		//Assert used for checking State is Resolved or not
		System.out.println("State is........."+defaultItem );
		Assert.assertEquals(defaultItem ,exptState, "Test case failed");
		//String state=stateChk.getAttribute("title");
		
		//String state=stateChk.getText();
		//System.out.println("State is........... :" +state);
		//typeResolve.clear();
		//typeResolve.sendKeys("Resolved");
		//searchResolve.click();
		return new IncidentResolve();
		
	}
	
}









/*package com.sn.Pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sn.Commons.TestBase;


public class ResolveInfo extends TestBase
{

	TestBase t = new TestBase();
	
	//@FindBy(id=("sysverb_insert"))
	//WebElement sysverb;
	
	//@FindBy(xpath=("//table[@id='incident_table']//th[@name='number']//a[@role='button']"))
	//WebElement Sort;
	//@FindBy(id = "c0a432031b138110c527ed74604bcbcd_text")
	//WebElement SearchButton; 
	
	//@FindBy(linkText=("Inquiry / Help"))
	//WebElement InquiryHelp;
	
	//@FindBy(id = "incident.number")
	//WebElement Incidentnumber;
	
	//@FindBy(linkText=("Inquiry / Help"))
	//WebElement LinkText;
	@FindBy(linkText=("Inquiry / Help"))
	WebElement LinkText;
	
	@FindBy(xpath=("//span[normalize-space()='Resolution Information']"))
	WebElement ClickResInfo;
	
	@FindBy(id=("incident.close_code"))
	WebElement IncidentClose;
	
	@FindBy(id=("incident.close_notes"))
	WebElement ClickCloseNotes;
	
	@FindBy(xpath=("//button[@id='resolve_incident']"))
	WebElement ResolveIncident;
	
	//@FindBy(id = "incident.number")
	//WebElement Incidentnumber;
	
	//Initializing the Page Objects
	public ResolveInfo()
	{
		PageFactory.initElements(t.driver, this);
	}
	
	//Action:-
	public String VerifyTitle()
	{
	return t.driver.getTitle();
	
	}
	
	public  IncidentResolve ResolveIncident(String caller,String shortdiscription,String ResolveNotesData) throws InterruptedException 
	{
		//sysverb.click();
		//Thread.sleep(1000);
		
	    //driver.switchTo().frame(0);
	    //driver.findElement(By.linkText("INC0000003")).click();
		
		//Sort.click();
		//String IncidentNo = Incidentnumber.getAttribute("value");
		//System.out.println(IncidentNo);
		//Switch to new tab
//		String parantwindow =driver.getWindowHandle();
//		System.out.println("paraent windowID is  "+ parantwindow);
//		Set<String>handles=driver.getWindowHandles();
//		System.out.println(handles);
//		Iterator<String>it01=handles.iterator();
//		it01.next();
//		//it01.next();
//		String wn3= it01.next();
//		driver.switchTo().window(wn3);
//		driver.switchTo().frame(0);
		//SearchButton.sendKeys(IncidentNo);
		//SearchButton.click();


		//Actions act = new Actions(driver);
		//act.sendKeys(Keys.ENTER).build().perform();

	    //Thread.sleep(5000);
		
		
		 //String IncidentNo = Incidentnumber.getAttribute("value");
		
		//LinkText.click();
		//Thread.sleep(1000);
		LinkText.click();
		ClickResInfo.click();
		
		Select drpState = new Select(driver.findElement(By.name("incident.state")));
		drpState.selectByVisibleText("In Progress");
		System.out.println("Selected element: " + drpState);
		

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,550)", "");
		
		WebElement listbox=driver.findElement(By.id("incident.close_code"));
		Select select=new Select(listbox);
		select.selectByIndex(3);
		//System.out.println("ListBosElement" +select);
		
		IncidentClose.click();
		System.out.println("Click  On IncidentCloseCode Option");
		System.out.println("-------------------------------------------------------------");
		ClickCloseNotes.clear();
		System.out.println("Click  On Resolve Notesn");
		System.out.println("-------------------------------------------------------------");
		ClickCloseNotes.sendKeys(ResolveNotesData);
		System.out.println("Passed input in ResolveNotes field from EXEL");
		System.out.println("Clicked On Resolve Button");
		System.out.println("-------------------------------------------------------------");
		ResolveIncident.click();
		
		return new IncidentResolve();
		
	}
	
	
}*/