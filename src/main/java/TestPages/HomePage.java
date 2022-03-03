package TestPages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import managers.FileReaderManager;
import selenium.Wait;

public class HomePage {
	
	private WebDriver browser;
	private WebDriverWait wait;
	 
	public HomePage(WebDriver browser) {
		this.browser = browser;
		wait = new WebDriverWait(browser, Duration.ofSeconds(10));
		PageFactory.initElements(browser, this);
	}
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]")
	private WebElement logger;
	
	@FindBy(how = How.ID, using = "menuUser")
	private WebElement menu;
	
	@FindBy(how = How.ID, using = "autoComplete")
	private WebElement autoComplete;
	
	@FindBy(how = How.CSS, using = ".product.ng-scope")
	private WebElement produtoNoMenu;
	
	@FindBy(how = How.ID, using = "menuUserLink")
	private WebElement menuUserLink;
	
	@FindBy(how = How.ID, using = "menuSearch")
	private WebElement menuSearch;
	
	
	public void paginaInicial() {
		browser.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		browser.manage().window().maximize();
		Wait.untilPageLoadComplete(browser);
	}
	
	public LoginPage vaiParaAPaginaDeLogin() throws IOException {
		
//		wait.until(ExpectedConditions.visibilityOf(logger));
		
		Wait.untilPageLoadComplete(browser);

//		wait.until(ExpectedConditions.invisibilityOf(logger));
		wait.until(ExpectedConditions.elementToBeClickable(menu)).click();
		
		return new LoginPage(browser);
	}

	public ProductPage pesquisaItem(String produto){

//		autoComplete.sendKeys(produto);
//					
//		autoComplete.clear();
		autoComplete.sendKeys(produto);
		autoComplete.clear();
		
		autoComplete.sendKeys(produto);
		
		produtoNoMenu.click();
		
	   	return new ProductPage(browser);	
}

	public ProductPage pesquisaItemErrado(String produto) {
			
		autoComplete.sendKeys(produto);
		autoComplete.sendKeys(Keys.ENTER);	
		
		return new ProductPage(browser);
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
		

		Wait.untilPageLoadComplete(browser);
				
		menuSearch.click();	
	}
	
	public boolean estaLogadoComOCadastroNovo() {

	boolean nome = wait.until(ExpectedConditions.
			visibilityOfElementLocated(
					By.cssSelector(
							".hi-user.containMiniTitle.ng-binding"))).
																isDisplayed();
		
		return nome;			
	}
}
