package utilities;

import base.TestBase;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

public class TestUtilities extends TestBase {

    public static String screenShotPath;
    public static String screenShotName;

    public static void getScreenshot() throws IOException {
        Date date=new Date();
        File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        screenShotName=date.toString().replace(":","_").replace(" ","_")+".jpg";
        FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+screenShotName));
        FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\test-output\\html\\"+screenShotName));
    }

    @DataProvider(name="getData")
    public Object[][] getData(Method methodName) {
        String sheetName = methodName.getName();
        System.out.println(sheetName);
        int rows = excelReader.getRowCount(sheetName);//5
        int cols = excelReader.getColumnCount(sheetName);//2

        Object[][] data = new Object[rows - 1][1];
        //int[] array= new int[1][1];
        //array[0][0]=10

        Hashtable<String, String> table = null;

        for (int rowNum = 2; rowNum <= rows; rowNum++) {//rows=3

            table = new Hashtable<String, String>();

            for (int colNum = 0; colNum < cols; colNum++) {//cols=2

                table.put(excelReader.getCellData(sheetName, colNum, 1), excelReader.getCellData(sheetName, colNum, rowNum));
                data[rowNum - 2][0] = table;//{endPoint=/customer,expectedCode=200}
            }

        }
        return data;
    }

}
