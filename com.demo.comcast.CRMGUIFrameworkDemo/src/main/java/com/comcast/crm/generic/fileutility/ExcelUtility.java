package com.comcast.crm.generic.fileutility;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
	// Fetching data from excel
	public String getDataFromExcel(String sheet, int row, int col) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./testData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String Data = wb.getSheet(sheet).getRow(row).getCell(col).getStringCellValue();
		wb.close();
		return Data;
	}
	
	public String getDataFromExcel(String path, String sheet, int row, int col) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		String Data = wb.getSheet(sheet).getRow(row).getCell(col).getStringCellValue();
		wb.close();
		return Data;
	}
	
	// Fetch Last Cell num
	public int getLastCellNum(String sheet, int row) throws EncryptedDocumentException, IOException
	{

		FileInputStream fis = new FileInputStream("./testData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		short lastCellNum = wb.getSheet(sheet).getRow(row).getLastCellNum();
	
		wb.close();
		return lastCellNum;
	}
	
	// Fetching last row num
	public int getLastRowNum(String Path,String sheet) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(Path);
		
		Workbook wb = WorkbookFactory.create(fis);
		int lastRowNum = wb.getSheet(sheet).getLastRowNum();
		wb.close();
		return lastRowNum;
	}
	
	public int getLastRowNum(String sheet) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./testData/TestScriptData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		int lastRowNum = wb.getSheet(sheet).getLastRowNum();
		wb.close();
		return lastRowNum;
	}
	
	// Write Data back to Excel
	public void setDataIntoExcel(String Sheet, int row, int col, String Data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./testData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(Sheet).getRow(row).createCell(col).setCellValue(Data);
		
		FileOutputStream fos = new FileOutputStream("./testData/TestScriptData.xlsx");
		wb.write(fos);
		wb.close();
		
	}
	
	public void setDataIntoExcel(String path, String Sheet, int row, int col, String Data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./testData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(Sheet).getRow(row).createCell(col).setCellValue(Data);
		

		FileOutputStream fos = new FileOutputStream(path);
		wb.write(fos);
		wb.close();
		
	}
	

}
