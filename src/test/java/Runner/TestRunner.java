package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:feature",
					glue= {"steps"},
					plugin= { "junit:target/cucumber-report/cucumber.xml",
							  "html:target/cucumber-reports"}, //usage
					monochrome = true)	

public class TestRunner {
	
//	@BeforeClass
//	public static void antes() throws UnsupportedEncodingException {
//		ExtentReports extentReports = new ExtentReports();
//		extentReports.flush();
//		extentReports.setGherkinDialect("pt");
//	}
//	
//	
//	@AfterClass
//	public static void writeExtentReport() {
//		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
//	}
	
}
