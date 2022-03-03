package TestPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.Wait;

public class ProductPage {
	
	WebDriver browser;
	private WebDriverWait wait;
	
	public ProductPage(WebDriver browser) {
		this.browser = browser;
		wait = new WebDriverWait(browser, Duration.ofSeconds(10));
		PageFactory.initElements(browser, this);
	}
	
	@FindBy(how = How.ID, using = "Description")
	private WebElement description;	
		
	public boolean verificaProduto() {		
		
		Wait.untilPageLoadComplete(browser);

		boolean descricao = description.isDisplayed();    			
	
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
