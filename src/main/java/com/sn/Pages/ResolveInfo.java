package com.sn.Pages;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.sn.Commons.TestBase;

public class ResolveInfo extends TestBase {

	TestBase t = new TestBase();

	@FindBy(xpath = ("//span[normalize-space()='Resolution Information']"))
	WebElement ClickResInfo;

	@FindBy(id = ("incident.close_code"))
	WebElement IncidentClose;

	@FindBy(id = ("incident.close_notes"))
	WebElement ClickCloseNotes;

	@FindBy(xpath = ("//button[@id='resolve_incident']"))
	WebElement ResolveIncident;

	@FindBy(xpath = ("//input[@id='filter']"))
	WebElement typeResolve;

	@FindBy(xpath = "/html/body/div[1]/div[1]/span/div/div[1]/div/span/div/div/input")
	WebElement SearchButton;

	// @FindBy(id = "incident.number")
	// WebElement Incidentnumber;

	@FindBy(linkText = ("Inquiry / Help"))
	WebElement InquiryHelp;

	@FindBy(xpath = "//select[@id='incident.state']")
	WebElement stateChk;

	@FindBy(xpath = "//select[@id='incident.state']")
	WebElement stateText;

	@FindBy(id = "incident.number")
	WebElement Incidentnumber;

	@FindBy(how = How.XPATH, using = "//input[@id='sys_display.incident.caller_id']")
	WebElement caller;

	@FindBy(how = How.XPATH, using = "//select[@id='incident.state']")
	WebElement state;

	@FindBy(how = How.XPATH, using = "//select[@id='incident.hold_reason']")
	WebElement onholdReason;

	@FindBy(how = How.XPATH, using = "//input[@id='incident.short_description']")
	WebElement shortdsr;

	@FindBy(how = How.XPATH, using = "//textarea[@id='activity-stream-comments-textarea']")
	WebElement addncmmt;

	@FindBy(how = How.XPATH, using = "//button[@class='form_action_button header  action_context btn btn-default']")
	WebElement updatebtn;

	// Initializing the Page Objects

	public ResolveInfo() {
		PageFactory.initElements(t.driver, this);
	}

	// Action:-
	public String VerifyTitle() {

		return t.driver.getTitle();

	}

	public IncidentResolve ResolveIncident(String caller, String shortdiscription, String ResolveNotesData)
			throws InterruptedException {

		// copy the value of incident number
		String IncidentNo = Incidentnumber.getAttribute("value");

		System.out.println("New Incident Number" + IncidentNo);
		ClickResInfo.click();

		Select drpState = new Select(driver.findElement(By.name("incident.state")));

		drpState.selectByVisibleText("In Progress");

		System.out.println("Selected element: " + drpState);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,550)", "");

		WebElement listbox = driver.findElement(By.id("incident.close_code"));

		Select select = new Select(listbox);

		select.selectByIndex(3);

		// System.out.println("ListBosElement" +select);

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

		// click on search button for weather incident resolve or not
		SearchButton.sendKeys(IncidentNo);

		Actions act = new Actions(driver);

		act.sendKeys(Keys.ENTER).build().perform();

		InquiryHelp.click();

		Select select1 = new Select(stateText);

		WebElement option = select1.getFirstSelectedOption();

		String defaultItem = option.getText(); //

		String exptState = "Resolved";

		// Assert used for checking State is Resolved or not
		System.out.println("State is........." + defaultItem);

		Assert.assertEquals(defaultItem, exptState, "Test case failed");

		return new IncidentResolve();

	}

	public CanceledInfo onHold() {
		String IncidentNo = Incidentnumber.getAttribute("value");

		System.out.println("New Incident Number" + IncidentNo);

		Select sel = new Select(state);

		sel.selectByValue("3"); //

		System.out.println("Selected element: " + sel);

		Select sel1 = new Select(onholdReason); //

		sel1.selectByIndex(2);

		System.out.println("Selected element: " + sel1);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,550)", "");

		// addncmmt.sendKeys(Additiondiscr);

		updatebtn.click();

		// click on search button for weather incident resolve or not
		SearchButton.sendKeys(IncidentNo);

		Actions act = new Actions(driver);

		act.sendKeys(Keys.ENTER).build().perform();

		InquiryHelp.click();

		Select select2 = new Select(stateText);

		WebElement option = select2.getFirstSelectedOption();

		String defaultItem = option.getText(); //

		String exptState = "On Hold";

		// Assert used for checking State is Resolved or not
		System.out.println("State is........." + defaultItem);

		Assert.assertEquals(defaultItem, exptState, "Test case failed");

		return new CanceledInfo();

	}

}
