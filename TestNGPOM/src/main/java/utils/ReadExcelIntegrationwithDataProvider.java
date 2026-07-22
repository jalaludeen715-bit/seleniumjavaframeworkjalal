package utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// Excel Integration with Data Provider

public class ReadExcelIntegrationwithDataProvider {
	
	@SuppressWarnings("resource")
	public static String[][] getExcelData(String fileName) throws IOException {
		
		//1.locate the file

	//	String fileLocation = "./test-data/Login-data.xlsx";

		//2.locate the workbook

		XSSFWorkbook wbook = new XSSFWorkbook("./data/"+fileName+".xlsx");  

		//3.move to sheet , sheet name or sheet index number

		XSSFSheet sheet= wbook.getSheetAt(0);

		//4.move to Row no 1, excluding header
		XSSFRow row = sheet.getRow(1);

		// 5.move to column no 0
		XSSFCell cell = row.getCell(0);

		// 6.copy data from cell
		String cellData = cell.getStringCellValue();
		System.out.println("1st ROW:" + cellData); // print 1strow and 0 column value
		

		//7. to read data from excel without hardcoading row, column numbers

		System.out.println("Read Excel DATA without hardcoding row and column numbers:");

		// to get number of rows in sheet
		int lastRowNum=	sheet.getLastRowNum();

		System.out.println("Total No of Rows:" + lastRowNum);

		// to get number of columns (cells)

		short lastCellNum=sheet.getRow(0).getLastCellNum();

		System.out.println("Total No of cells:" + lastCellNum);
		
		String [][] data = new String[lastRowNum][lastCellNum];
		
		for (int i = 1; i <= lastRowNum; i++) {
			XSSFRow row2 = sheet.getRow(i);
			for (int j = 0; j < lastCellNum; j++) {
				XSSFCell cell3 = row2.getCell(j);
				DataFormatter dft = new DataFormatter(); // Dataformatter is used to convert values to string
				String value = dft.formatCellValue(cell3);
				//String cellData3 = cell3.getStringCellValue();
			//	System.out.println("ALL DATA FROM EXCEL without hardcoding: " + cellData3); // print all data
				
				data[i-1][j]= value;
				
			} 
		}
		


		wbook.close();
		return data;
			
		}
		
		
		
	}
