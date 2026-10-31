package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelTestDataUtility;

public class ExcelDataProviderTest {

    @DataProvider(name = "loginData")
    public Object[][] loginData() throws Exception {

        String filePath =
                "src/test/resources/testdata/loginData.xlsx";

        ExcelTestDataUtility excelUtility =
                new ExcelTestDataUtility(filePath);

        return excelUtility.readExcelData("Sheet1");
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) {

        System.out.println(
                "Username: " + username
                        + " | Password: " + password
        );
    }
}