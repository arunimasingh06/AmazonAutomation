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
    }
}
