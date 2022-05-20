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

public class TestBase
{
	static XSSFReader reader;

	public static WebDriver driver;
	public static Properties p;
	public static EventFiringWebDriver e_driver;
	//public static WebEventListener eventListener;
	
	//Object repository where store the value of locators properties file

	public TestBase(){
		try {
			p=new Properties();
			FileInputStream f=new FileInputStream("C:\\Users\\Tathagat\\eclipse-workspace\\SN-POC\\src\\main\\java\\com\\sn\\Properties\\Config.properties" );
			p.load(f);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//To launch driver
	/*public void launch() throws IOException 
	{
				
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//e_driver = new EventFiringWebDriver(driver);
		//eventListener = new WebEventListener();
		//e_driver.register(eventListener);      giving error for this line
		//driver = e_driver;

	}*/
	//To launch driver
		public void launch() {
			if(p.getProperty("browser").equalsIgnoreCase("chrome"))
			{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver=new ChromeDriver(options);
			}
			else
			{
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions options1 = new FirefoxOptions();
				options1.addArguments("--disable-notifications");
				driver = new FirefoxDriver(options1);
			}
			driver.manage().deleteAllCookies();
			driver.get(p.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			//e_driver = new EventFiringWebDriver(driver);
			//eventListener = new WebEventListener();
			//e_driver.register(eventListener);      giving error for this line
			//driver = e_driver;

		}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public void setup(String browser) throws Exception{
	        //Check if parameter passed from TestNG is 'firefox'
	        if(browser.equalsIgnoreCase("firefox")){
	        //create firefox instance
	            driver = new FirefoxDriver();
	        }
	        //Check if parameter passed as 'chrome'
	        else if(browser.equalsIgnoreCase("chrome")){
	            //set path to chromedriver.exe
	            System.setProperty("webdriver.chrome.driver","E:\\software\\chromedriver\\chromedriver.exe");
	            //create chrome instance
	            driver = new ChromeDriver();
	        }
	        //Check if parameter passed as 'IE'
	                else if(browser.equalsIgnoreCase("ie")){
	                    //set path to IE.exe
	                    System.setProperty("webdriver.edge.driver", "E:\\software\\edgedriver\\msedgedriver.exe");
	                    //create IE instance
	                    driver = new InternetExplorerDriver();
	                }
	        else{
	            //If no browser passed throw exception
	            throw new Exception("Browser is not correct");
	        }
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }
	public static void takeScreenshotAtEndOfTest() {
		// TODO Auto-generated method stub
		
	}
	
	/*public void launch(String broweser) throws IOException
	 {
		// String browserName = prop.getProperty("broweser");
		if (broweser.equalsIgnoreCase(p.getProperty("chrome"))) {
			//WebDriverManager.chromedriver().setup();
			// Set Browser to ThreadLocalMap
			//driver.set(new ChromeDriver());
			System.setProperty("webdriver.chrome.driver", "E:\\software\\chromedriver\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get(p.getProperty("url"));
            driver.manage().window().maximize();
    		//driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		} else 
		{
			System.setProperty("webdriver.gecko.driver", "E:\\software\\Firefoxdriver\\geckodriver.exe");
			WebDriver driver =new FirefoxDriver();
            driver.get(p.getProperty("url"));
            driver.manage().window().maximize();
    		//driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
		}
			
		}
	
	
			
			
	/*public  boolean verify(By webEle) {
		boolean check=driver.findElement(webEle).isDisplayed();
		System.out.println(check);
		return check;

	}

	public  void clickOnElement(By webEle)
	{
		driver.findElement((webEle)).click();
	}

	public  void sendKey(By webEle,String text) {
		driver.findElement(webEle).sendKeys(text);
	}

	public  void clickoncheckbox(By webEle) {

		boolean check=driver.findElement(webEle).isSelected();
		if(!check)
		{
			driver.findElement(webEle).click();

		}
	}
	public String titleTest() {
		return driver.getTitle();
	}

	public  void pressEnter() {
		Actions action=new Actions(driver);
		action.sendKeys(Keys.ENTER);
	}

	public  void scrollupto(By webEle) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",webEle);

	}

	public  void clickonElementbyjs(WebElement webEle) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", webEle);
	}

	public  String getText(By webEle) {
		String gettext=driver.findElement(webEle).getText();
		return gettext;
	}

	public  boolean elementvisibletest(By webEle) {
		boolean gettext=driver.findElement(webEle).isEnabled();
		return gettext;
	}

	public  void explicitWait(By ele) {
		WebDriverWait wait=new WebDriverWait(driver,2);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}*/
//		public static void takeScreenshotAtEndOfTest() throws IOException {
//			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			String currentDir = System.getProperty("user.dir");
//			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
//		}

}