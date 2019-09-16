package hotel_booking_system;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//This class reads in the ExcelFile from the drive

public class FileUtils {
	
	public List getRoomsFromExcel() {
		
		String filePath = "C:\\Users\\kevmc\\git\\Hackerrank_Challenges\\Recursion & DynamicProgramming\\inventory.xlsx";
		
		ArrayList roomArrayList = new ArrayList();
		
		
		try {
			
			FileInputStream fis = new FileInputStream(filePath);
			Workbook workbook = new XSSFWorkbook(fis);
			
			Sheet sheet = workbook.getSheetAt(0);
			
			Iterator rowIterator = sheet.iterator();
			
			rowIterator.next();
			
			while (rowIterator.hasNext()) {
				
				Row row = (Row) rowIterator.next();
			
				double reference 	= row.getCell(0).getNumericCellValue();
				String roomType 	= row.getCell(1).getStringCellValue();
				double minGuests 	= row.getCell(4).getNumericCellValue();
				double maxGuests 	= row.getCell(5).getNumericCellValue();
				double price		= row.getCell(6).getNumericCellValue();
				String priceModel 	= row.getCell(7).getStringCellValue();

				// Add newly created room to the list of rooms
				roomArrayList.add(new Room(reference, roomType, minGuests, maxGuests, price, priceModel));
				
			}
			
		} catch (FileNotFoundException e) {
			
			System.out.println(e);
		} catch (Exception e) {
			
			System.out.println(e);
		}
		
		
		return roomArrayList;
		
		
		
	}

}
