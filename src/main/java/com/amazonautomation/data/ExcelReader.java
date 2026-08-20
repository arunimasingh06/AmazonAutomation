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

            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
            System.out.println("----------------------");
        }
    }
}
