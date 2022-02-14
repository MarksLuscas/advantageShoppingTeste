package managers;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import TestPages.HomePage;
import TestPages.LoginPage;
import TestPages.ProdutoPage;
import TestPages.RegisterPage;

public class PageObjectManager {

	private WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	private ProdutoPage produtoPage;
	private RegisterPage registerPage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public HomePage getHomePage(){
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}
	
	public LoginPage getLoginPage() throws IOException{
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
	}
	
	public RegisterPage getRegisterPage() throws IOException{
		return (registerPage == null) ? registerPage = new RegisterPage(driver) : registerPage;
	}
	
	public ProdutoPage getProdutoPage(){
		return (produtoPage == null) ?	produtoPage = new ProdutoPage(driver) : produtoPage;
	}

	
	
}
