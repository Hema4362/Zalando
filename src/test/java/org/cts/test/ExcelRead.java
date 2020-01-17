package org.cts.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	
		
		public static String getLoginDetails(int rowNum, int cellNum) throws IOException
		{
			String cellValue = null;
			File loc=new File("C:\\Users\\Sai\\eclipse\\MavenProject\\Excelfiles\\Excelinput.xlsx");
			FileInputStream fis = new FileInputStream(loc);
			
			Workbook w = new XSSFWorkbook(fis);
			
			Sheet s = w.getSheet("Sheet1");
			
			Row r = s.getRow(rowNum);
			
			Cell c = r.getCell(cellNum);
			
			int cellType = c.getCellType();
			
			if(cellType == 1)
			{
				cellValue = c.getStringCellValue();
			}
			
			else if(cellType == 0)
			{
				if(DateUtil.isCellDateFormatted(c))
				{
					Date dateValue = c.getDateCellValue();
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
					cellValue = sdf.format(dateValue);
				}
				
				else
				{
					double d = c.getNumericCellValue();
					long l = (long) d;
					cellValue = String.valueOf(l);
				}
			}
				
			
			
			return cellValue;
			
		}

	}


