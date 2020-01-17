package org.cts.test;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {
	public static void printItemDetailsFromExcel(String product,String price) throws IOException
	{
		FileOutputStream fs=new FileOutputStream("C:\\Users\\Sai\\eclipse\\MavenProject\\Excelfiles\\Exceloutput.xlsx");
		Workbook w=new XSSFWorkbook();
		Sheet s=w.createSheet("Sheet1");
		Row r = s.createRow(0);
		Cell productPriceCell = r.createCell(0);
		productPriceCell.setCellValue("product Name");
		Cell productCell = r.createCell(1);
		productCell.setCellValue("product Price");
		Row printRow = s.createRow(1);
		Cell printCell = printRow.createCell(0);
		printCell.setCellValue(product);
		Cell createCell = printRow.createCell(1);
		createCell.setCellValue(price);
		w.write(fs);
		
	}

}
