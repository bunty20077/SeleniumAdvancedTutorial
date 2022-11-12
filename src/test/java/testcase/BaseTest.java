package testcase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import driver.Driver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import reportmanager.ExtentManager;
import java.io.IOException;
/*
* alwaysRun = true is needed else -Dgroup=SmokeTesting willnot work.

 */
public class BaseTest {

    ExtentSparkReporter spark;
    ExtentReports extent;
    ExtentTest test;


    // eto thik noy
    @BeforeClass(alwaysRun = true)
    protected void preSetup() throws IOException {
        extent = ExtentManager.getInstance();
        test = ExtentManager.createTest(this.getClass().getName());
        Driver.setupDriver();
    }


    @AfterMethod(alwaysRun = true)
    public void getResult(ITestResult result)
    {
        if(result.getStatus()==ITestResult.FAILURE)
        {
            test.log(Status.FAIL, result.getThrowable());
        }else if(result.getStatus()==ITestResult.SUCCESS)
    {
        test.log(Status.PASS, result.getTestName());
    }
        // extent.endTest(test);
    }

    @AfterClass(alwaysRun = true)
    protected void tearDown() {
        Driver.quitDriver();
        extent.flush();
    }
}
