package utils;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelTestDataUtility {

    private String filePath;

    public ExcelTestDataUtility(String filePath) {
        this.filePath = filePath;
    }

    public Object[][] readExcelData(String sheetName)
            throws IOException {

        FileInputStream fileInputStream =
                new FileInputStream(filePath);

        Workbook workbook =
                WorkbookFactory.create(fileInputStream);

        Sheet sheet =
                workbook.getSheet(sheetName);

        // Row 0 = header
        int firstDataRow = 1;

        // Last physical row containing data
        int lastDataRow = sheet.getLastRowNum();

        // Number of columns from header
        int columnCount =
                sheet.getRow(0).getLastCellNum();

        // Number of actual data rows
        int dataRowCount =
                lastDataRow - firstDataRow + 1;

        Object[][] data =
                new Object[dataRowCount][columnCount];

        DataFormatter formatter =
                new DataFormatter();

        // Start from row 1, therefore skipping header
        for (int i = firstDataRow; i <= lastDataRow; i++) {

            Row row = sheet.getRow(i);

            for (int j = 0; j < columnCount; j++) {

                Cell cell = row.getCell(
                        j,
                        Row.MissingCellPolicy
                                .CREATE_NULL_AS_BLANK
                );

                data[i - firstDataRow][j] =
                        formatter.formatCellValue(cell);
            }
        }

        workbook.close();
        fileInputStream.close();

        return data;
    }
}