package com.sn.Testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sn.Commons.TestBase;
import com.sn.Pages.HomePage;
import com.sn.Pages.InProgress;
import com.sn.Pages.IncidentCreate;
import com.sn.Pages.IncidentResolve;
import com.sn.Pages.LoginPage;
import com.sn.Pages.OnHoldInfo;
import com.sn.Pages.ResolveInfo;

public class InProgressTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	IncidentCreate incidentcreate;
	ResolveInfo resolveinfo;
	InProgress inprogress;
	OnHoldInfo onhold;
	IncidentResolve incidentresolve;

	@BeforeMethod
	public void setup(String Caller, String Shortdescription, CharSequence FilterNavigator)
			throws InterruptedException, IOException {
		launch();
		loginpage = new LoginPage();
		homepage = loginpage.LoginData(p.getProperty("un"), p.getProperty("pass"));
		// incidentcreate=homepage.SearchIncident();
		// homepage = new HomePage();

		incidentcreate = homepage.SearchIncident();
		// incidentcreate = new IncidentCreate();
		resolveinfo = incidentcreate.NewIncident(Caller, Shortdescription);

		// incidentcreate=new IncidentCreate();
		// resolveinfo=new ResolveInfo();
		Thread.sleep(3000);

		// searchincident=new SearchIncident();
		// Assert.assertEquals(loginpage.verifyLogin(), "ServiveNow", "Login failed");
	}

	@Test(priority = 1)
	public void verify() throws InterruptedException {
		String title = resolveinfo.VerifyTitle();
		System.out.println("This is Test1");
		// System.out.println(title); Assert.assertEquals(title, "ServiceNow
		// Developers", "Title not matched");
	}

	@Test(priority = 2)
	public void ResolveIncident(String caller, String shortdiscription, String ResolveNotesData)
			throws InterruptedException {
		System.out.println("This is Test2");
		System.out.println("Executing NewIncident test case");
		// ResolveInfo = homepage.SearchIncident();
		incidentresolve = resolveinfo.ResolveIncident(caller, shortdiscription, ResolveNotesData);
		// onhold=inprogress.InProgressState();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
