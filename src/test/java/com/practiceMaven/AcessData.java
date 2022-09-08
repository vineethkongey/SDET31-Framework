package com.practiceMaven;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class AcessData {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		ExcelData data = new ExcelData(); 
		String s = data.getExcelData("Organisation",1,0);
		System.out.println(s);
	}

}
