package com.testscript.utility;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	
	static String projectpath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	 public ExcelData(String excelPath, String sheetName)
	 {
		 
		 try {
			workbook=new XSSFWorkbook(excelPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 sheet=workbook.getSheet(sheetName);
		 
	 }
	
	public static void main(String[] args) throws IOException {
		getRowCount();
		getCellDataString(0,0);

	}

	public static int getRowCount() 
	{
		int rowcount=0;
		 try {
	     rowcount=sheet.getPhysicalNumberOfRows();
		System.out.println("No. of Row "+rowcount);
		 }
		 catch(Exception exp) {
			 System.out.println(exp.getMessage());
			 
		 }
		 return rowcount;
		
		
	}
	
	public static int getColumnCount() 
	{
		int colcount=0;
		 try {
		 colcount=sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("No. of Column "+colcount);
		 }
		 catch(Exception exp) {
			 System.out.println(exp.getMessage());
			 
		 }
		return colcount;
		
	}
	public static String getCellDataString(int rowNum, int colNum)  {
		String cellDataString=null;
		try {
		
	 cellDataString=sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		System.out.println(cellDataString);
		}
		catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
		}
		return cellDataString;
	}
   public static void getCellDataNumber(int rowNum, int colNum) {
		
		double cellDataNum=sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		System.out.println(cellDataNum);
	}
	
	

}
