package TestPages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	private WebDriver browser;
	private WebDriverWait wait;

	
	public HomePage() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		browser = new ChromeDriver();
		wait = new WebDriverWait(browser, Duration.ofSeconds(10));
	}
	
	public void paginaInicial() {
		browser.get("https://advantageonlineshopping.com/#/");
		browser.manage().window().maximize();
	}
	
	public LoginPage vaiParaAPaginaDeLogin() throws IOException {
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[2]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("menuUser"))).click();
		
		
		return new LoginPage(browser);
	}

	public ProdutoPage pesquisaItem(String produto) {
				
		browser.findElement(By.id("autoComplete")).sendKeys(produto);
		
		 wait.until(
					ExpectedConditions.invisibilityOfElementLocated(By.xpath(
							"/html/body/div[2]")));
	
		 wait.until(
					ExpectedConditions.elementToBeClickable(
							By.cssSelector(""
									+ "img[data-ng-src='/"
									+ "catalog/fetchImage?image_id=1700']"))).click();
		
		
	  return new ProdutoPage(browser);
   }

	public ProdutoPage pesquisaItemErrado(String produto) {
			
		WebElement item = browser.findElement(By.id("autoComplete"));
			
		item.sendKeys(produto);
		item.sendKeys(Keys.ENTER);	
		
		return new ProdutoPage(browser);
	}
	
	public void sairDoBrowser() {
		browser.close();
	}

	public boolean estaLogado() {
		
		boolean nome = wait.until(ExpectedConditions.
				visibilityOfElementLocated(By.id("menuUserLink"))).isDisplayed();
			
		return nome;	
	}

	public void clicaParaFazerUmaBusca() {

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"/html/body/div[2]")));
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath(
						"/html/body/div[2]")));
				
		browser.findElement(By.id("menuSearch")).click();
		
	}
}
