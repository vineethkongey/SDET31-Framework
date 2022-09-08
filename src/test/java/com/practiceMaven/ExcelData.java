package com.practiceMaven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData {
	public  String getExcelData(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/Test Data.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		DataFormatter format = new DataFormatter();
		Sheet sh = book.getSheet(sheetName);
		
		return format.formatCellValue(sh.getRow(row).getCell(cell));
		
	}

}

