package Hooks;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import testlogger.TestResultLogger;
import utilities.Driver;
import utilities.ReusableMethods;

public class HookClass {
    private static final Logger logger = Logger.getLogger(TestResultLogger.class);
    ReusableMethods reUse=new ReusableMethods(Driver.driver);
    @AfterMethod
    public void methodTeardown(){
        Driver.quitDriver();
        logger.info("The page has been closed");
    }
    @AfterClass
    public void classTeardown(){
        reUse.writeTestResults(TestResultLogger.results);
        logger.info("All the test status have been saved in an Excel file");
    }

}
