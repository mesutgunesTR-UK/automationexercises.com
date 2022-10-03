package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pojos.utilities.Driver;

public class Hooks {

    public static RequestSpecification spec;

    @Before(value = "@ui") //before hoook for ui
    public void setUpUi(){

    }
    @Before(value = "@api") //before hook for api
    public void setUpApi(){

    }
    @Before(value = "@db") //before hoook for db
    public void setUpDB(){

    }

    @After(value = "@db")//after method for db
    public void tearDownDB(Scenario scenario) {

        if (scenario.isFailed()) {
        }
    }
    @After(value = "@api")//after method for api
    public void tearDownApi(Scenario scenario) {

        if (scenario.isFailed()) {
        }
    }
    @After(value = "@ui")//after method for ui
    public void tearDownUi(Scenario scenario) {

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshots");
        }
        Driver.closeDriver();
    }
}