package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:feature",	
				 tags="@cadastro",
				 glue= {"steps"},
				 plugin= { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, //usage
				 monochrome = true)	

public class TestRunner {

}
