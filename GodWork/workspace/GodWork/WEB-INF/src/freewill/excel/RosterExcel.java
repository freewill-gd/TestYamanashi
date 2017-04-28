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
	
	private final int CELL_WORK_DATE = 0;
	private final int CELL_WEEKDAY = 1;
	private final int CELL_WORK_KIND = 2;
	private final int CELL_START_TIME = 3;
	private final int CELL_END_TIME = 4;
	private final int CELL_BREAK_TIME = 5;
	private final int CELL_OVER_TIME = 6;
	private final int CELL_LATE_NIGHT_OVER_TIME = 7;
	private final int CELL_HOLIDAY_OVER_TIME = 8;
	private final int CELL_HOLIDAY_LATE_NIGHT_OVER_TIME = 9;
	private final int CELL_REMARKS = 10;
	
	public void OutoutExcel(OutputStream os, String start, String userId, String userName) {
	
		URL resource = DataAccess.class.getClassLoader().getResource("Roster.xlsx");
		Workbook book = null;
		
		InputStream in = null;
		try {
			in = resource.openConnection().getInputStream();
			try {
				book = WorkbookFactory.create(in);
			} catch (EncryptedDocumentException e) {
				e.printStackTrace();
			} catch (InvalidFormatException e) {
				e.printStackTrace();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			
			try {
				if(in != null)in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
				
		createData(start, userId, userName, book);
		
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

	private void createData(String start, String userId, String userName, Workbook book) {
		Sheet sheet;
		sheet = book.getSheetAt(0);
		Row row;
		Cell cell;    
		
		RosterDataAccess data = new RosterDataAccess();
		RosterDto[] dtos = data.getData(start, userId);
		
		//ヘッダー
		row = sheet.getRow(1);
		String title = "勤務表 " + start.substring(0, 4) + "年" + start.substring(4, 6) + "月";
		setCell(row, 5, title);
		
		row = sheet.getRow(2);
		setCell(row, 10, userName);
		
		int rowNum = 4;
		
		// 明細
		for (RosterDto dto : dtos) {
			// 1日ごと
			row = sheet.getRow(rowNum);
			setCell(row, CELL_WORK_DATE, dto.getWorkDate());
			setCell(row, CELL_WEEKDAY, dto.getWeekday());
			setCell(row, CELL_WORK_KIND, dto.getWorkKindText());
			setCell(row, CELL_START_TIME, dto.getStartTime());
			setCell(row, CELL_END_TIME, dto.getEndTime());
			setCell(row, CELL_BREAK_TIME, dto.getBreakTime());
			setCell(row, CELL_OVER_TIME, dto.getOverTime());
			setCell(row, CELL_LATE_NIGHT_OVER_TIME, dto.getLateNightOverTime());
			setCell(row, CELL_HOLIDAY_OVER_TIME, dto.getHolidayOverTime());
			setCell(row, CELL_HOLIDAY_LATE_NIGHT_OVER_TIME, dto.getHolidayLateNightOverTime());
			setCell(row, CELL_REMARKS, dto.getRemarks());
			rowNum++;
		}
		
		// 合計
		RosterDto sumDto = data.getDataSum(start, userId);
		row = sheet.getRow(36);
		setCell(row, CELL_BREAK_TIME, sumDto.getBreakTime());
		setCell(row, CELL_OVER_TIME, sumDto.getOverTime());
		setCell(row, CELL_LATE_NIGHT_OVER_TIME, sumDto.getLateNightOverTime());
		setCell(row, CELL_HOLIDAY_OVER_TIME, sumDto.getHolidayOverTime());
		setCell(row, CELL_HOLIDAY_LATE_NIGHT_OVER_TIME, sumDto.getHolidayLateNightOverTime());
		
		
	}

	private void setCell(Row row, int cellNum, String str) {
		Cell cell = row.getCell(cellNum);
		cell.setCellValue(str);
	}
	
}
