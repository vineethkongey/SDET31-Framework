package com.crm.autodesk.commonutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class is used to perform all Excel File related utilities 
 * @author Soumyajit
 *
 */
public class ExcelDataUtility {
	/**
	 * This method is used to fetch the data from Excel Sheet.
	 * @param filePath
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	public String getExcelData(String filePath,String sheetName,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fis = new FileInputStream(filePath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetName);
		DataFormatter format = new DataFormatter();
		String cellValue = format.formatCellValue(sh.getRow(rowNum).getCell(cellNum));
		return cellValue;
	}
	
	
	/**
	 * This method is used to fetch the Last Row Number.
	 * @param filePath
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 * @throws IOException
	 */
	public int getLastRowNum(String filePath,String sheetName) throws Throwable, IOException
	{
		FileInputStream fis = new FileInputStream(filePath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetName);
		int lastRowNum = sh.getLastRowNum();
		return lastRowNum;
	}
	
	
	/**
	 * This method is used to update the cell Value.
	 * @param filePath
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param updatedValue
	 * @throws Throwable
	 */
	public String updateExcelDataForParticularCell(String filePath,String sheetName,int rowNum,int cellNum,String updatedValue) throws Throwable
	{
		FileInputStream fis = new FileInputStream(filePath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetName);
	    sh.getRow(rowNum).getCell(cellNum).setCellValue(updatedValue);
	    DataFormatter format = new DataFormatter();
	    String newCellValue = format.formatCellValue(sh.getRow(rowNum).getCell(cellNum));
		FileOutputStream fos = new FileOutputStream(filePath);
		book.write(fos);
		fos.close();
		return newCellValue;
	}
}
