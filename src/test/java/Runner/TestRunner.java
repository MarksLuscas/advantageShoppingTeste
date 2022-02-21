package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:feature",
					glue= {"pageSteps"},
					plugin= {"pretty"}, //usage
					monochrome = true)	
public class TestRunner {
}
