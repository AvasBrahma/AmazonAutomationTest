package com.testscript.automationtest;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.testscript.amazonbaseclass.Amazonbaseclass;
import com.testscript.utility.ExcelData;

public class AmazonSearchTest extends Amazonbaseclass {

	@Test(dataProvider="GetData" ,priority =1)
	public void amazonSearchTest1(String cate, String product ) throws IOException, InterruptedException

	{
	
		System.out.println("Category="+cate);
		System.out.println("Product= "+product);
		
		ExtentTest test=extent.createTest("Amazon End to End Test 1 ", "Customer Search for Product ");
		//test.log(Status.INFO, "This Step Shows Usage of log");
		test.info("To Validate Customer is in Product page ");

		Amazonpagetest.getAlldropdown().click();
		test.pass("Customer Click the Dropdown");
		Thread.sleep(1000);
		Select Category=new Select(Amazonpagetest.getAlldropdown());
		Category.selectByVisibleText(cate);
		test.pass("Customer Select Electronics");
		
		Amazonpagetest.getSearchTextField().clear();
		
		Amazonpagetest.getSearchTextField().sendKeys(product);
		test.pass("Customer Type Mobile Phones");
		Amazonpagetest.getSearchBtn().click();
		test.pass("Customer Click Search Button");
	    if(driver.getTitle().contains("Amazon.in : Mobile Phones") )
	    {
	    	test.pass("Page Tile Contains as Expected");
	    }
	    else
	    {
	    	test.fail("Page Tile Does not contain as Expected");
	    }
		
		}
	@Test(dataProvider="GetData", priority=2)
	public void amazonSearchTest2(String cate, String product ) throws IOException, InterruptedException

	{
	
		System.out.println("Category="+cate);
		System.out.println("Product= "+product);
		
		ExtentTest test=extent.createTest("Amazon End to End Test 2", "Customer Search for Product");
		//test.log(Status.INFO, "This Step Shows Usage of log");
		test.info("This Step shows usage of info(details)");
		Amazonpagetest.getAlldropdown().click();
		test.pass("Customer Click the Dropdown");
		Thread.sleep(1000);
		Select Category=new Select(Amazonpagetest.getAlldropdown());
		Category.selectByVisibleText(cate);
		test.pass("Customer Select Electronics");
		
		Amazonpagetest.getSearchTextField().clear();
		
		Amazonpagetest.getSearchTextField().sendKeys(product);
		test.pass("Customer Type Mobile Phones");
		Amazonpagetest.getSearchBtn().click();
		test.pass("Customer Click Search Button");
	    if(driver.getTitle().contains("Amazon.in : Camera") )
	    {
	    	test.pass("Page Tile Contains as Expected");
	    }
	    else
	    {
	    	test.fail("Page Tile Does not contain as expected");
	    }
		
	
		}

	

	@DataProvider(name="GetData")
	public Object[][] getData()
	{
		
		
		String excelPath="D:\\CaseStudy\\AmazonAutomationTestScript\\ExcelData\\AmazonCaseStudy.xlsx";
		Object data[][]=getDataExcel(excelPath, "Sheet1");
		return data;
		
	}
	
	
	
	public Object[][] getDataExcel(String excelpath, String sheetname)
	{
		ExcelData excelData=new ExcelData(excelpath, sheetname);

		int rowCount=excelData.getRowCount();
	    int colcount=excelData.getColumnCount();
	    
	    Object data[][]=new Object[rowCount-1][colcount];
	    
	    for(int i=1;i<rowCount;i++)
	    {
	    	for(int j=0;j<colcount;j++)
	    	
	    	{
	    		
	    		String cellDataExcel=excelData.getCellDataString(i, j);
	    		System.out.print(cellDataExcel+ "|");
	    		data[i-1][j]=cellDataExcel;
	    	} 
	    	System.out.println();
	    	
	    }
	    return data;
	}
	
	
	
	@AfterSuite
	public void teardown()
	{
		extent.flush();
	}	
}
