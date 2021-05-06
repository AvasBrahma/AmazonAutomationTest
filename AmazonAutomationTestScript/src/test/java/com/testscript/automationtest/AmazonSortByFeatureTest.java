package com.testscript.automationtest;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.testscript.amazonbaseclass.Amazonbaseclass;
import com.testscript.utility.ExcelData;

public class AmazonSortByFeatureTest extends Amazonbaseclass{
	
	@Test(dataProvider="GetData")
	public void amazonValidateElement1(String cate, String product ) throws InterruptedException

	{
	
		System.out.println("Category="+cate);
		System.out.println("Product= "+product);
		
		ExtentTest test=extent.createTest("Amazon End to End Test 3 ", "Validate Sort By Option is Present or not");
		//test.log(Status.INFO, "This Step Shows Usage of log");
		test.info("Sort By Option is present on product page or not");

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
		List<WebElement> dynamicElement = Amazonpagetest.getSortByProductPage();
		if(dynamicElement.size() != 0)
		{
			test.pass("Sort By Feature is Present"); 
			System.out.println("Element present");
		}
		else {
			test.fail("Sort By Feature is not Present");
		 System.out.println("Element not present");

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
