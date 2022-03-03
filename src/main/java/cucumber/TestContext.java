package cucumber;

import managers.PageObjectManager;
import managers.WebDriverManagerr;

public class TestContext {

	private WebDriverManagerr webDriverManager;
	private PageObjectManager pageObjectManager;
	
	public TestContext(){
		webDriverManager = new WebDriverManagerr();
		pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
	}
	
	public WebDriverManagerr getWebDriverManager() {
		return webDriverManager;
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
	
}