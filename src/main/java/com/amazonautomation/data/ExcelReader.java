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
        Row row= sheet.getRow(1);
        Cell cell = row.getCell(0);
        System.out.println(cell.getStringCellValue());

        System.out.println(row.getCell(0).getStringCellValue());
        System.out.println(row.getCell(1).getStringCellValue());
    }
}
