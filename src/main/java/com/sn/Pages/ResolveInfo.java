package com.sn.Pages;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

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

	@FindBy(linkText = ("Inquiry / Help"))
	WebElement InquiryHelp;

	@FindBy(how = How.XPATH, using = "//a[@class='linked formlink']")
	WebElement inquiryno;

	@FindBy(xpath = "//select[@id='incident.state']")
	WebElement stateChk;

	@FindBy(xpath = "//select[@id='incident.state']")
	WebElement stateText;

	@FindBy(xpath = "(//select[@class='form-control'])[2]")
	WebElement stateresolve;

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

	@FindBy(how = How.XPATH, using = "//span[text()='Notes']")
	WebElement notes;
	@FindBy(how = How.XPATH, using = "//textarea[@id='activity-stream-comments-textarea']")
	WebElement addncmmt;

	@FindBy(how = How.XPATH, using = "//span[text()='Resolution Information']")
	WebElement resolvedrp;

	@FindBy(how = How.XPATH, using = "//select[@id='incident.close_code']")
	WebElement resolvData;

	@FindBy(how = How.XPATH, using = "//button[@Id='sysverb_insert']")
	WebElement subbtn;

	@FindBy(how = How.XPATH, using = "//button[@class='form_action_button header  action_context btn btn-default']")
	WebElement updatebtn;

	@FindBy(how = How.XPATH, using = "//button[@id='sysverb_update']")
	WebElement updatebutton;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[5]/div[1]/div[1]/nav[1]/div[1]/div[2]/form[1]/div[1]/div[1]/input[1]")
	WebElement filter;

	@FindBy(id = "filter")
	WebElement TypeIncident;

	@FindBy(how = How.XPATH, using = "(//div[@class='input-group-transparent'])[2]")
	WebElement filterbar;

	@FindBy(how = How.XPATH, using = "//td[text()='No records to display']")
	WebElement norecordmsg;

	@FindBy(xpath = "//span[@class=\"outputmsg_text\"]")
	WebElement resolveNoteMsg;

	@FindBy(how = How.XPATH, using = "(//div[text()='All'])[2]")
	WebElement all;

	@FindBy(how = How.XPATH, using = "//input[@id='574bc64f1b4c9110c527ed74604bcb28_text']")
	WebElement searchbtn;

	@FindBy(how = How.XPATH, using = "//button[@id='user_info_dropdown']//span[@class='caret']")
	WebElement changeuserbtn;

	@FindBy(how = How.XPATH, using = "//a[text()='Impersonate User']")
	WebElement impersonateuser;

	@FindBy(xpath = "//a[text()='End Impersonation']")
	WebElement serviceuser;

	@FindBy(how = How.XPATH, using = "(//a[@class='list-group-item ng-binding ng-scope'])[2]")
	WebElement user;

	@FindBy(how = How.XPATH, using = "//div[text()='Incidents']")
	WebElement selfserviceincident;

	@FindBy(how = How.XPATH, using = "//a[@class='linked formlink']")
	WebElement incidentlink;

	@FindBy(how = How.XPATH, using = "//button[@id='sysverb_update']")
	WebElement update;

	@FindBy(xpath = "(//button[@class='form_action_button header  action_context btn btn-default'])[2]")
	WebElement closebtn;
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

		Select drpState = new Select(stateText);

		drpState.selectByVisibleText("In Progress");

		System.out.println("Selected element: " + drpState);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,550)", "");

		WebElement listbox = driver.findElement(By.id("incident.close_code"));

		Select select = new Select(listbox);

		select.selectByIndex(3);

		IncidentClose.click();

		System.out.println("Click  On IncidentCloseCode Option");

		System.out.println("-------------------------------------------------------------");

		ClickCloseNotes.clear();

		System.out.println("Click  On Resolve Notesn");

		System.out.println("-------------------------------------------------------------");

		if (ResolveNotesData.isBlank() || shortdiscription.isBlank() || caller.isBlank()) {

			ResolveIncident.click();

			String errmsg = resolveNoteMsg.getText();

			System.out.println("Error massage is      :" + errmsg);

			System.out.println(
					"********Mandotory input of ResolveNotesData is not availble in Excel File Name is TestData3 and sheet name is ResolveNotes *******");

			Assert.assertEquals(false, true);

			driver.quit();
		} else {
			ClickCloseNotes.sendKeys(ResolveNotesData);
			System.out.println("Resolve Info is entered");
		}

		update.click();

		System.out.println("Passed input in ResolveNotes field from EXEL");

//The below Scripting  is for the impersanate user
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
//
		driver.switchTo().window(tabs2.get(0));

		changeuserbtn.click();

		impersonateuser.click();

		user.click();

		Actions action = new Actions(driver);

		action.moveToElement(filter).build().perform();

		filter.clear();

		Thread.sleep(3000);

		filter.sendKeys("Incident");

		selfserviceincident.click();

		driver.switchTo().frame(0);

		SearchButton.sendKeys(IncidentNo);

		Actions act = new Actions(driver);

		act.sendKeys(Keys.ENTER).build().perform();

		inquiryno.click();

		System.out.println("Clicked On Resolve Button");

		System.out.println("-------------------------------------------------------------");

		ResolveIncident.click();

		inquiryno.click();

		closebtn.click();

		System.out.println("resolve test case is run");

		driver.switchTo().window(tabs2.get(0));

		changeuserbtn.click();

		serviceuser.click();

//To check whether the incident is close or not
		act.moveToElement(filter).build().perform();

		filter.clear();

		filter.sendKeys("All");

		all.click();

		driver.switchTo().frame(0);

		SearchButton.sendKeys(IncidentNo);

		action.sendKeys(Keys.ENTER).build().perform();

		return new IncidentResolve();

	}

	public CanceledInfo onHold() {
		String IncidentNo = Incidentnumber.getAttribute("value");

		System.out.println("Incident Number is " + IncidentNo);

		Select sel = new Select(stateText);

		sel.selectByValue("3"); //

		System.out.println("Selected element : " + sel);

		Select sel1 = new Select(onholdReason); //

		sel1.selectByIndex(2);

		System.out.println("Selected element: " + sel1);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,550)", "");

		updatebtn.click();

		// select on state button for weather state is selected or not
		SearchButton.sendKeys(IncidentNo);

		Actions act = new Actions(driver);

		act.sendKeys(Keys.ENTER).build().perform();

		InquiryHelp.click();

		Select select2 = new Select(stateText);

		WebElement option = select2.getFirstSelectedOption();

		String defaultItem = option.getText();

		String exptState = "On Hold";

		// Assert used for checking State is Resolved or not
		System.out.println("State is.........     " + defaultItem);

		Assert.assertEquals(defaultItem, exptState, "Test case failed");
		return new CanceledInfo();

	}

	public void cancelData() {
		String IncidentNo = Incidentnumber.getAttribute("value");

		System.out.println("Incident Number is " + IncidentNo);

		Select sel = new Select(stateText);

		sel.selectByVisibleText("Canceled");

		System.out.println("Selected element: " + sel);

		updatebutton.click();

		// click on search button for weather state is selected or not

		SearchButton.sendKeys(IncidentNo);

		Actions act = new Actions(driver);

		act.sendKeys(Keys.ENTER).build().perform();

		String msg = norecordmsg.getText();

		String expected = "No records to display";

		Assert.assertEquals(msg, expected, "test case is failed");

		System.out.println("after completing the cancelstate operation this msg will be display    :" + msg); // done

		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().window(tabs2.get(1));
		// System.out.println(tabs2);

		act.moveToElement(filter).build().perform();

		filter.clear();

		filter.sendKeys("All");

		all.click();

		driver.switchTo().frame(0);

		SearchButton.sendKeys(IncidentNo);

		Actions action = new Actions(driver);

		action.sendKeys(Keys.ENTER).build().perform();

	}

	public void close() {
		String IncidentNo = Incidentnumber.getAttribute("value");

		System.out.println("Incident Number is " + IncidentNo);

		Select sel = new Select(stateText);

		sel.selectByValue("7");

		System.out.println("Selected element: " + sel);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,550)", "");

		resolvedrp.click();

		Select sel1 = new Select(resolvData);

		sel1.selectByValue("Closed/Resolved by Caller");

		updatebutton.click();

		// click on search button for weather state is selected or not

		SearchButton.sendKeys(IncidentNo);

		Actions act = new Actions(driver);

		act.sendKeys(Keys.ENTER).build().perform();

		String msg = norecordmsg.getText();

		String expected = "No records to display";

		Assert.assertEquals(msg, expected, " Test Case is Failed ");

		System.out.println("after completing the closestate operation this msg will be display    :" + msg);

		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		System.out.println(tabs2);

		act.moveToElement(filter).build().perform();

		filter.clear();

		filter.sendKeys("All");

		all.click();

		driver.switchTo().frame(0);

		SearchButton.sendKeys(IncidentNo);

		Actions action = new Actions(driver);

		action.sendKeys(Keys.ENTER).build().perform();

	}

}
