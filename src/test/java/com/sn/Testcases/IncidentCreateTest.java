package com.sn.Testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sn.Commons.TestBase;
import com.sn.Pages.HomePage;
import com.sn.Pages.IncidentCreate;
import com.sn.Pages.LoginPage;
import com.sn.Pages.ResolveInfo;
import com.sn.utilities.TestUtil;

public class IncidentCreateTest extends TestBase 
{

	LoginPage loginpage;
	HomePage homepage;
	IncidentCreate incidentcreate;
	ResolveInfo resolveinfo;
	//SearchIncident searchincident;
	static String wbsheet="IncidentData";

	@BeforeMethod
	public void setup() throws InterruptedException, IOException 
	{
		launch();
		loginpage = new LoginPage();
		homepage = loginpage.LoginData(p.getProperty("un"), p.getProperty("pass"));
		homepage = new HomePage();
		incidentcreate=homepage.SearchIncident();
		Thread.sleep(3000);
		//incidentcreate = new IncidentCreate();
		//searchincident=new SearchIncident();
		//Assert.assertEquals(loginpage.verifyLogin(), "ServiveNow", "Login failed");
	}

	@DataProvider
	public Iterator<Object[]> getTestData()
	{
		//ArrayList<Object[]> testData=TestUtil.getDataFromExcel(wbsheet);
		ArrayList<Object[]> testData=TestUtil.getDataFromExcel(wbsheet);
		return testData.iterator();

	}

	/*@Test(priority=1)
	public void verify() throws InterruptedException 
	{ 
		String title = incidentcreate.VerifyTitle(); 
		//System.out.println(title); Assert.assertEquals(title, "ServiceNow Developers", "Title not matched"); 
	}*/

	@Test(dataProvider= "getTestData" )
	public void NewIncident(String caller,String shortdiscription) throws InterruptedException
	{
		if(caller.isBlank() || shortdiscription.isBlank() )
		 {
			  System.out.println("Invalid data is choosen");
				//incidentcreate.ClickonNewButton();
				 incidentcreate.InvalidIncidentcreate(caller, shortdiscription);
				
		 }
		 else 
		 {
		//ResolveInfo = homepage.SearchIncident();
		System.out.println("**********Executing new  Incident methode**********" );
		resolveinfo=incidentcreate.NewIncident(caller,shortdiscription);
		String name = incidentcreate.verifyIncidentPage();
		System.out.println("This is Text of Incident create page :" + name);
		//Assert.assertEquals(name, "Incidents [Portal view] | ServiceNow", "Incident not created");
		/*String actualUrl="https://dev116187.service-now.com/nav_to.do?uri=%2Fincident_list.do%3Factive%3Dtrue%26sysparm_query%3Dactive%253Dtrue%255EEQ";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl,actualUrl);
		System.out.println("AssertEquals Test Passed\n");
		System.out.println("Executing NewIncident test case");*/
		//String expectedText=driver.findElement(By.xpath("//a[@class='list_action list_top_title']")).getText();
		/*System.out.println(expectedText);
		String actualText="Incidents [Portal view]";
		if (expectedText.equals(actualText)) {
		              System.out.println("Pass");
		}else{
		              System.out.println("fail");
		}*/



		/*String name = incidentcreate.verifyIncidentPage(); 
		System.out.println(name);
		String actualname = "Incidents [Portal view]";
		if(name.equals(actualname))
		{
			System.out.println("Test Case passed");
		}
		else
		{
			System.out.println("Testcase failed");
		}*/
		 }

	}

	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
