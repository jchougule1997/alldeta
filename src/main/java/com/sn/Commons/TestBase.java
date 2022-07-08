package com.sn.Commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sn.util.TestUtil;
//import com.sn.utilities.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	static XSSFReader reader;

	public static WebDriver driver;
	public static Properties p;
	public static EventFiringWebDriver e_driver;

	public TestBase() {
		try {

			p = new Properties();

			FileInputStream f = new FileInputStream(
					"C:\\Users\\jalindar.chougule\\git\\SN-POCNEW\\src\\main\\java\\com\\sn\\Properties\\Config.properties");

			p.load(f);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	// To launch web-driver
	public void launch() {

		if (p.getProperty("browser").equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();

			options.addArguments("--disable-notifications");

			driver = new ChromeDriver(options);
		} else {
			WebDriverManager.firefoxdriver().setup();

			FirefoxOptions options1 = new FirefoxOptions();

			options1.addArguments("--disable-notifications");

			driver = new FirefoxDriver(options1);
		}
		driver.manage().deleteAllCookies();

		driver.get(p.getProperty("url"));

		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	}

}