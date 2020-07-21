package com.automation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	//we are making this global so that we can access outside the method aswell
	XSSFWorkbook wb;
	
	//this constructor will load the excel as soon as we create the object for this class
	
	//as soon as we create an obj for this class this constructor(ExcelDataProvider) will be called automatically and will load this file
	public ExcelDataProvider()
	{
		File src = new File("./TestData/Data.xlsx");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			 wb = new XSSFWorkbook(fis);
		    }
		catch (Exception e) {
			
			System.out.println("Unable to read Excel File====> "+ e.getMessage());
			
		}
	}
	
	//this is an example of method overloading line number 34 and 39
	public String  getStringData(int sheetIndex, int rownum, int columnnum)
	{
		return wb.getSheetAt(sheetIndex).getRow(rownum).getCell(columnnum).getStringCellValue();
	}
	
	public String  getStringData(String sheetName, int rownum, int columnnum)
	{
		return wb.getSheet(sheetName).getRow(rownum).getCell(columnnum).getStringCellValue();
	}
	
	//NumericCellValue will return double
	public double getNumericData(String sheetName, int rownum, int columnnum)
	{
		return wb.getSheet(sheetName).getRow(rownum).getCell(columnnum).getNumericCellValue();
	}

}
