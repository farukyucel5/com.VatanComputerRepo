package testlogger;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.ArrayList;
import java.util.List;

public class TestResultLogger implements ITestListener {
    private static final Logger logger = Logger.getLogger(TestResultLogger.class);
    public static List<String> results=new ArrayList<>();
    static {
        PropertyConfigurator.configure("log4j.properties");
    }
    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Starting test: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        results.add("Test passed: " + result.getMethod().getMethodName());
        logger.info("Test passed: " + result.getMethod().getMethodName());

    }

    @Override
    public void onTestFailure(ITestResult result) {
        results.add("Test failed: " + result.getMethod().getMethodName());
        logger.error("Test failed: " + result.getMethod().getMethodName());
    }

    // Implement other methods as per your requirements

    @Override
    public void onFinish(ITestContext context) {
        // Cleanup or final logging statements can be added here
    }


}
