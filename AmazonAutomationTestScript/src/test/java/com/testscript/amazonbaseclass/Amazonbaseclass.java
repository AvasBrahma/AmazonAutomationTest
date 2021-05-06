package com.testscript.amazonbaseclass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.testscript.amazonpages.AmazonPages;



public class Amazonbaseclass {
	
	public WebDriver driver;
    public AmazonPages Amazonpagetest;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public JavascriptExecutor jse;
	@Parameters({"Browser", "Url"})
	@BeforeClass 
	public void setUp(String Browser, String Url)
	{
		htmlReporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		if(Browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\CaseStudy\\AmazonAutomationTestScript\\Drivers\\Chromedriver\\chromedriver.exe");
			
			 driver=new ChromeDriver(); 
			 driver.manage().window().maximize();
			 
		}
		else if(Browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "D:\\CaseStudy\\AmazonAutomationTestScript\\Drivers\\EdgeDriver\\msedgedriver.exe");
			   driver= new EdgeDriver();
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{

			System.setProperty("webdriver.gecko.driver", "D:\\CaseStudy\\AmazonAutomationTestScript\\Drivers\\GeckoDriver\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		else if(Browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "D:\\CaseStudy\\AmazonAutomationTestScript\\Drivers\\IEdriver\\IEDriverServer.exe");
			driver= new InternetExplorerDriver();
		}
		Amazonpagetest=new AmazonPages(driver);
		driver.get(Url);
	}
	
	
	
	
	@AfterTest
	public void teardownTest()
	{   
		driver.close();
		driver.quit();
		
	}

}
