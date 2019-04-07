package com.dexter.lib.utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Sheet;

public class DataHandlers {
	public static String getDataFromProperties(String fileName, String key)
	{
		String data= null;
		try
		{
			File f = new File ("./test-data/"+fileName+".xlsx");	
			FileInputStream fis = new FileInputStream(f);
			Properties prop= new Properties();
			prop.load(fis);
			data = prop.get("name").toString();
					}
	catch(Exception e)
		{
		e.printStackTrace();
		}
	return data;
	}
	
	public static void setDataProperties(String fileName,String key, String value, String comment)
	{
		try
		{
			File f = new File ("./test-data/"+fileName+".xlsx");	
			FileInputStream fis = new FileInputStream(f);
			Properties prop= new Properties();
			prop.load(fis);
			prop.put(key,value);
			FileOutputStream fos= new FileOutputStream(f);
			prop.store(fos, comment);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static String getDataFromExcel(String fileName, String sheetName, int row, int cell)
	{
		String data=null;
		try {
		File f = new File ("./test-data/"+fileName+".xlsx");	
		FileInputStream fis = new FileInputStream(f);	
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet(sheetName);
		Row r=sh.getRow(row);
		Cell c=r.getCell(cell);
		data=c.toString();
			}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
}
	public static String setDataToExcel(String fileName, String sheetName, int row, int cell, String value)
	{
		String data=null;
		try {
		File f = new File ("./test-data/"+fileName+".xlsx");	
		FileInputStream fis = new FileInputStream(f);	
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet(sheetName);
		Row r=sh.getRow(row);
		Cell c=r.getCell(cell);
		c.setCellValue(value);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
			}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
}
	

}
