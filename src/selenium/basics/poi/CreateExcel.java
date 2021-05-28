package selenium.basics.poi;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


public class CreateExcel {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Workbook wb = new HSSFWorkbook();
		Sheet sheet1 = wb.createSheet("first sheet");
		Sheet sheet2 = wb.createSheet("second sheet");
		Row row = sheet2.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("Apache POI is good");
		cell = row.createCell(1);
		cell.setCellValue("Java is awesome");
		try  (OutputStream fileOut = new FileOutputStream("workbook.xls")) {
		    wb.write(fileOut);
		}
		wb.close();
	}

}
