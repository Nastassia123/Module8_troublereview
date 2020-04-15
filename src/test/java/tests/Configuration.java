package tests;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;

public class Configuration {

    @BeforeSuite
    public void setUpParams(ITestContext context)
    {
        context.getCurrentXmlTest().getAllParameters();

    }
}
