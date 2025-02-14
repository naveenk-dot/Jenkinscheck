package Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static Object[][] getExcelData(String filePath) throws IOException {
		XSSFWorkbook workbook = null;
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			int rowCount = sheet.getPhysicalNumberOfRows();
			XSSFRow row = sheet.getRow(0);
			int columnCount = row.getLastCellNum();
			Object[][] data = new Object[rowCount - 1][columnCount];
			for (int i = 0; i < rowCount; i++) {
				row = sheet.getRow(i + 1);
				if (row != null) {
					for (int j = 0; j < columnCount; j++) {
						XSSFCell cell = row.getCell(j);
						if (cell != null) {
							data[i][j] = cell.toString();
						} else {
							data[i][j] = "";
						}
					}
				}
			}
			return data;
		} finally {
			if (workbook != null) {
				workbook.close();
			}
			if (fis != null) {
				fis.close();
			}
		}
	}
}
