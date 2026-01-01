package reporting;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static void initReport() {
        ExtentSparkReporter reporter =
                new ExtentSparkReporter("test-output/ExtentReport.html");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }

    public static ExtentTest createTest(String testName) {
        return extent.createTest(testName);
    }

    public static void flushReport() {
        extent.flush();
    }
}
