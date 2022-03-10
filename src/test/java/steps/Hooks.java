package steps;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;


public class Hooks {

	TestContext testContext;

	public Hooks(TestContext context) {
		testContext = context;
	}

	@After()
	public void AfterSteps() {
		testContext.getWebDriverManager().closeDriver();
	}
	
	@AfterStep()
	public void addScreenshot(Scenario scenario){

	      final byte[] screenshot = ((TakesScreenshot) testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
	      scenario.attach(screenshot, "image/png", "image"); 
		
	}

}
