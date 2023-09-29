package rough;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ExcelReader;

import java.lang.reflect.Method;
import java.util.Hashtable;

public class DataProviderImplementation {

    public static ExcelReader excelReader=new ExcelReader
            (System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\testData.xlsx");

    @Test(dataProvider="getData")
    public void takeDataFromSheet(Hashtable<String, String> data)
    {
        System.out.println(data.get("firstName"));
        System.out.println(data.get("lastName"));
        System.out.println(data.get("postCode"));
    }

    @DataProvider
    public Object[][] getData(Method m)
    {
        String sheetName = m.getName();
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

                table.put(excelReader.getCellData(sheetName, colNum, 1), excelReader.getCellData(sheetName, colNum,rowNum ));
                data[rowNum - 2][0] = table;//{endPoint=/customer,expectedCode=200}
            }

        }
        return data;

        // System.out.println(data); return data;
    }

}
