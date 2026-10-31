package tests;

import org.testng.annotations.Test;
import utils.ExcelTestDataUtility;

public class ExcelTestDataUtilityTest {

    @Test
    public void readExcelData() throws Exception {

        String filePath =
                "src/test/resources/testdata/loginData.xlsx";

        ExcelTestDataUtility excelUtility =
                new ExcelTestDataUtility(filePath);

        Object[][] data =
                excelUtility.readExcelData("Sheet1");

        for (Object[] row : data) {

            System.out.println(
                    "Username: " + row[0]
                            + " | Password: " + row[1]
            );
        }
    }
}