package com.comcast.crm.genericfileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	//// Method to fetch data from an Excel cell
  public String getDataFromExcel(String sheetName,int rowNum,int celNum) throws EncryptedDocumentException, IOException {
	  
	  FileInputStream fis = new FileInputStream("./testdata/testScriptdata.xlsx");
	Workbook wb  = WorkbookFactory.create(fis );
	String data = wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
	
	  wb.close();
	return data;
  }
  // Method to get the number of rows in a specific Excel sheet
  public int getRowcount(String sheetName) throws EncryptedDocumentException, IOException
  {
	  FileInputStream fis = new FileInputStream("./testdata/testScriptdata.xlsx");
	  Workbook wb  = WorkbookFactory.create(fis );
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowCount;
		                
  }                    
  
  // Method to write data into a specific Excel cell
  public void setDataIntoExcel(String sheetName,int rowNum,int celNum ,String data) throws IOException
  {

	  FileInputStream fis = new FileInputStream("./testdata/testScriptdata.xlsx");
	  Workbook wb  = WorkbookFactory.create(fis );
	  wb.getSheet(sheetName).getRow(rowNum).createCell(celNum);
	  FileOutputStream fos = new FileOutputStream("./testdata/testScriptdata.xlsx");
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		wb.write(fos);
		wb.close();
  }
}
