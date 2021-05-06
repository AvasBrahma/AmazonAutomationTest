package com.testscript.automationtest;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.testscript.amazonbaseclass.Amazonbaseclass;
import com.testscript.utility.ExcelData;

public class AmazonNavigationToBuyNow extends Amazonbaseclass {
	
	@Test(dataProvider="GetData")
	public void amazonSearchTest(String cate, String product ) throws IOException, InterruptedException

	{
	
		System.out.println("Category="+cate);
		System.out.println("Product= "+product);
		
		ExtentTest test=extent.createTest("Amazon End to End Test", "Customer Search for Product and Click Buy Now");
		//test.log(Status.INFO, "This Step Shows Usage of log");
		test.info("Customer is Not Already Login");

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
		Amazonpagetest.getCustomerProduct().click();
		test.pass("Customer Select New Apple iPhone 12 Mini (128GB) - White");
		Thread.sleep(1000);
	    Set<String> windowhandles=driver.getWindowHandles(); //Return total no. of windows
	    Iterator<String> iterator= windowhandles.iterator(); 
        String parentwindow=iterator.next();
        String childwindow=iterator.next();
        driver.switchTo().window(childwindow);
        test.pass("Customer Switch to next Window");
	    Amazonpagetest.getCustomerClickBuyNow().click();
	    test.pass("Customer Click Buy Now"); 
	    Thread.sleep(1000);
	    if(driver.getTitle().contains("Amazon Sign In"))
	    {
	    	test.pass("Navigation Successfull, Customer is in Login Page");
	    	System.out.println("Test Completed Successfully");
	    }
	    else
	    {
	    	test.fail("Navigation Fail, Customer is not in Login Page");
	    	System.out.println("Test not Completed Successfully");
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
