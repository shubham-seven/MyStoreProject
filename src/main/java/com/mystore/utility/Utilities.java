package com.mystore.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utilities {
	
	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int PAGE_LOADOUT_TIME = 5;
	public static int a =10;
	

	
	public static String generateEmailWithTimeStamp() {
		Date dateText = new Date();
		return "arunmotooricap9"+dateText.toString().replace(" ","_").replace(":", "_")+"@gmail.com";
	}
	
	public static Object[][] getTestDataFromExcel(String sheetName){
		XSSFWorkbook workbook = null;
		File excelFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\mystore\\dataprovider\\TutorialsNinjaTestingData.xlsx");
		
		try {
		FileInputStream excelFIS = new FileInputStream(excelFile);
		  workbook = new XSSFWorkbook(excelFIS);
		}catch (Throwable e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		
		 Object[][] data = new Object[rows][cols];
		 
		 for(int i=0;i<rows;i++) {
			 
			 XSSFRow row = sheet.getRow(i+1);
			 
			 for(int j=0;j<cols;j++) {
				 
				 XSSFCell cell = row.getCell(j);
				 CellType cellType = cell.getCellType();
				 
				 switch (cellType) {
				case STRING:
					data[i][j] =  cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j] = Integer.toString((int)cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[i][j] =  cell.getBooleanCellValue();
					break;
				
				}
			 }
			 
		 }
		
		
		return data;
	}

}
