package com.amazonautomation.data;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
    public static void main (String[] args) throws IOException{
        FileInputStream file =
                new FileInputStream("src/main/resources/testdata/LoginData.xlsx");        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheet("LoginData");
        System.out.println(sheet.getSheetName());
        System.out.println("Number of rows:"+ sheet.getPhysicalNumberOfRows());
        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {

            Row row = sheet.getRow(i);

            String username = row.getCell(0).getStringCellValue();
            String password = row.getCell(1).getStringCellValue();
            boolean expectedSuccess = row.getCell(2).getBooleanCellValue();
            String expectedMessage = row.getCell(3).getStringCellValue();
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
            System.out.println("Expected Success: " + expectedSuccess);
            System.out.println("Expected Message: " + expectedMessage);
            System.out.println("----------------------");
        }
        Object[][] data = getExcelData();

        for (Object[] row : data) {
            System.out.println(
                    row[0] + " | " +
                            row[1] + " | " +
                            row[2] + " | " +
                            row[3]
            );
        }
    }
    public static Object[][] getExcelData() throws  IOException{
        FileInputStream file = new FileInputStream("src/main/resources/testdata/LoginData.xlsx");
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheet("LoginData");
        int rows = sheet.getPhysicalNumberOfRows();
        Object[][] data = new Object[rows - 1][4];
        for (int i = 1; i < rows; i++) {
            Row row = sheet.getRow(i);
            data[i - 1][0] =
                    row.getCell(0).getStringCellValue();
            data[i - 1][1] =
                    row.getCell(1).getStringCellValue();
            data[i - 1][2] =
                    row.getCell(2).getBooleanCellValue();
            data[i - 1][3] =
                    row.getCell(3).getStringCellValue();
        }
        return data;
    }
}
