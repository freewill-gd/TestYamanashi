package freewill.excel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import freewill.database.DataAccess;
import freewill.database.dataaccess.RosterDataAccess;
import freewill.database.dto.RosterDto;

public class RosterExcel {
	public void OutoutExcel(OutputStream os, String start, String userId) {
	
		URL resource = DataAccess.class.getClassLoader().getResource("Roster.xlsx");
		Workbook book = null;
		
		InputStream in = null;
		try {
			in = resource.openConnection().getInputStream();
			try {
				book = WorkbookFactory.create(in);
			} catch (EncryptedDocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			
			try {
				if(in != null)in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
				
			
		Sheet sheet;
		sheet = book.getSheetAt(0);
		Row row;
		Cell cell;    
		
		RosterDataAccess data = new RosterDataAccess();
		RosterDto[] dtos = data.getData(start, userId);
		int rowNum = 4;
		
		for (RosterDto dto : dtos) {
			row = sheet.getRow(rowNum);
			cell = row.getCell(10);
			cell.setCellValue(dto.getRemarks());
			rowNum++;
		}
		
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
