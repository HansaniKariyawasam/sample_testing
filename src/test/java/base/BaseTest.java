package base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest extends BasePage{
    @BeforeTest
    public void beforeSuite(){
        initWebDriver();
    }

    @AfterTest
    public void afterSuite(){
        quitWebDriver();
    }
}
