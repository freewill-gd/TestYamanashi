package freewill.excel;

import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

public class RosterExcel {
	public void OutoutExcel(OutputStream os) {
	
		Workbook book = null;
		
		book = new SXSSFWorkbook();
		Sheet sheet;
		sheet = book.createSheet();
		Row row;
		Cell cell;    
		row = sheet.createRow(0);
		cell = row.createCell(0);
		cell.setCellValue("てすと");
		try {
			book.write(os);
		} catch(Exception e) {
			System.err.println(e.getStackTrace().toString());
		} finally {
			try {
				if (book != null ) book.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getStackTrace().toString());
			}
		}

	}
	
}
