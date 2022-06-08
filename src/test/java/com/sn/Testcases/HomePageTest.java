package com.sn.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sn.Commons.TestBase;
import com.sn.Pages.CreateVIPIncident;
import com.sn.Pages.HomePage;
import com.sn.Pages.LoginPage;



public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	CreateVIPIncident Createvipincident;
	
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		launch();
		loginpage = new LoginPage();
		homepage = loginpage.LoginData(p.getProperty("un"), p.getProperty("pass"));
		//incidentcreate = new IncidentCreate();
		//homepage = new HomePage();
		//Assert.assertEquals(loginpage.verifyLogin(), "ServiveNow", "Login failed");
	}
	
	
	 @Test 
	 public void verify() throws InterruptedException 
	 { 
	  String title = homepage.VerifyTitle(); 
	  Thread.sleep(5000);
//	  if(title.equalsIgnoreCase("ServiceNow Developers"))
//	  {
//		  System.out.println("Testcase passed");
//	  }
//	  else
//	  {
//		  System.out.println("Testcase failed");
//	  }
//	 
	  //System.out.println(title); Assert.assertEquals(title, "ServiceNow Developers", "Title not matched"); 
	  }
	 
	@Test
	public void SearchIncident() throws InterruptedException
	{
		System.out.println("Executing SearchIncident test case");
		Createvipincident = homepage.SearchIncident();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
