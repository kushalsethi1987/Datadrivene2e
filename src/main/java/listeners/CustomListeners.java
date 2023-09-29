package listeners;

import base.TestBase;
import org.testng.*;
import utilities.TestUtilities;

import java.io.IOException;

public class CustomListeners extends TestBase implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {


    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

        System.setProperty("org.uncommons.reportng.escape-output","false");
        try {
            TestUtilities.getScreenshot();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /*Reporter.log("Capturing Screenshot for method "+iTestResult.getName());
        Reporter.log("<a target =\"_blank\" href=\"C:\\Users\\kusha\\OneDrive\\Pictures\\Screenshots\\my.png\">Screenshot</a>");*/
        Reporter.log("Capturing Screenshot");
        Reporter.log("<a target =\"_blank\" href="+TestUtilities.screenShotName+">Screenshot Link</a>");
        Reporter.log("<br>");

        Reporter.log("<a target =\"_blank\" href="+TestUtilities.screenShotName+">" +
                "<img src="+TestUtilities.screenShotName+" height=200 width=200</img>></a>");

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

        System.setProperty("org.uncommons.reportng.escape-output","false");
        try {
            TestUtilities.getScreenshot();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Reporter.log("Capturing Screenshot for method "+iTestResult.getTestName());
        Reporter.log("<a target =\"_blank\" href=\"C:\\Users\\kusha\\OneDrive\\Pictures\\Screenshots\\my.png\">Screenshot</a>");
        Reporter.log("Capturing Screenshot");
        Reporter.log("<br>");
        /*Reporter.log("<a target =\"_blank\" href="+TestUtils.screenshotName+">Screenshot Link</a>");*/
        Reporter.log("<a target =\"_blank\" href=\"C:\\Users\\kusha\\OneDrive\\Pictures\\Screenshots\\my.png\"><img src=\"C:\\Users\\kusha\\OneDrive\\Pictures\\Screenshots\\my.png\" height=200 width=200</img>></a>");


    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
