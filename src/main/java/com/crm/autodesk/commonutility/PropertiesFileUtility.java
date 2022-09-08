package com.crm.autodesk.commonutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class can handle all Properties file related utilities
 * @author Soumyajit
 *
 */
public class PropertiesFileUtility {

	/**
	 * This method is used for fetching value for each key from properties file.
	 * @param filePath
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getValuesForPropertiesFile(String filePath,String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(filePath);
		Properties pobj = new Properties();
		pobj.load(fis);
		String value  = pobj.getProperty(key);
		return value;
	}
}
