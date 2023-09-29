package rough;

import org.testng.Reporter;

public class ReportThroughReportNG {

    //Listerners to be added in testng file
    /*<listeners>
      <listener class-name="org.uncommons.reportng.HTMLReporter"/>
      <listener class-name="org.uncommons.reportng.JUnitXMLReporter"/>
  </listeners>*/
    public void logPrint()
    {
        System.setProperty("org.uncommons.reportng.escape-output","false");
        Reporter.log("<a href=\"C:\\Users\\kusha\\OneDrive\\Pictures\\Screenshots\\my.png\">Screenshot</a>");
        Reporter.log("This is my method");
        Reporter.log("<a target =\"_blank\" href=\"C:\\Users\\kusha\\OneDrive\\Pictures\\Screenshots\\my.png\"><img src=\"C:\\Users\\kusha\\OneDrive\\Pictures\\Screenshots\\my.png\" height=200 width=200</img>></a>");
    }

}
