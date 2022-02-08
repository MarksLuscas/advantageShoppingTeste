package TestPages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProdutoPage {
	
	private WebDriver browser;
	private WebDriverWait wait;
	
	public ProdutoPage(WebDriver browser) {
		this.browser = browser;
		wait = new WebDriverWait(browser, Duration.ofSeconds(10));
	}
				
	public boolean verificaProduto() {		
			
		boolean descricao =  wait.until(ExpectedConditions.
				visibilityOfElementLocated(By.id("Description"))).isDisplayed();    			
	
	 return descricao;
}
	public boolean mensagemDeProdutoInexistente() {
	
		boolean msgErro = wait.until(ExpectedConditions.
				textToBe(By.xpath(
						"html/body/div[3]/section/article/div[4]/label[1]"),
						"No search results found. "
						+ "However, you can extend your search through "
						+ "the new SAP user experience (uses SAPUI5)"));
		
		return msgErro;
		
	}

}