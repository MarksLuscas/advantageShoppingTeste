package TestPages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	private WebDriver browser;
	private WebDriverWait wait;
	
	public HomePage() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		browser = new ChromeDriver();
		wait = new WebDriverWait(browser, Duration.ofSeconds(10));
		PageFactory.initElements(browser, this);
	}
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]")
	private WebElement logger;
	
	@FindBy(how = How.ID, using = "menuUser")
	private WebElement menu;
	
	@FindBy(how = How.ID, using = "autoComplete")
	private WebElement autoComplete;
	
	@FindBy(how = How.CSS, using = "img[data-ng-src='/catalog/fetchImage?image_id=1700']")
	private WebElement produtoNoMenu;
	
	@FindBy(how = How.ID, using = "menuUserLink")
	private WebElement menuUserLink;
	
	@FindBy(how = How.ID, using = "menuSearch")
	private WebElement menuSearch;
	
	
	public void paginaInicial() {
		browser.get("https://advantageonlineshopping.com/#/");
		browser.manage().window().maximize();
	}
	
	public LoginPage vaiParaAPaginaDeLogin() throws IOException {
	
		wait.until(ExpectedConditions.visibilityOf(logger));
		wait.until(ExpectedConditions.invisibilityOf(logger));
		wait.until(ExpectedConditions.elementToBeClickable(menu)).click();
		
		return new LoginPage(browser);
	}

	public ProdutoPage pesquisaItem(String produto) {
				
		autoComplete.sendKeys(produto);
		
		wait.until(ExpectedConditions.invisibilityOf(logger));
	
	 	wait.until(ExpectedConditions.elementToBeClickable(produtoNoMenu)).click();
				
	 	return new ProdutoPage(browser);
   }

	public ProdutoPage pesquisaItemErrado(String produto) {
			
		autoComplete.sendKeys(produto);
		autoComplete.sendKeys(Keys.ENTER);	
		
		return new ProdutoPage(browser);
	}
	
	public void sairDoBrowser() {
		browser.close();
	}

	public boolean estaLogado() {
		
		boolean nome = wait.until(ExpectedConditions.
								visibilityOf(menuUserLink)).isDisplayed();
			
		return nome;	
	}

	public void clicaParaFazerUmaBusca() {

		wait.until(
				ExpectedConditions.visibilityOf(logger));
		wait.until(
				ExpectedConditions.invisibilityOf(logger));
				
		menuSearch.click();
		
	}
}
