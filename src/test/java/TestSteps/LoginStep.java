package TestSteps;

import java.io.IOException;

import org.junit.Assert;

import TestPages.HomePage;
import TestPages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class LoginStep {
	
	private HomePage homePage;
	private LoginPage loginPage;
	
	public LoginStep() {
		homePage = new HomePage();
	}

	@Dado("usuario vai para o site")
	public void usuario_vai_para_o_site() {
		homePage.paginaInicial();
	}

	@Quando("o usuario clica para fazer login")
	public void o_usuario_clica_para_fazer_login() throws IOException {
		loginPage = homePage.vaiParaAPaginaDeLogin();
	}
	
	@E("coloca seus dados")
	public void coloca_seus_dados() {
		loginPage.preencheComOsDados(1);
	}
	
	
	@Entao("aparece logado na sua conta")
	public void aparece_logado_na_sua_conta() {		
		Assert.assertTrue(homePage.estaLogado());
	}
	
	
	//SEGUNDO CENARIO
	
	@E("coloca os dados invalidos")
	public void coloca_os_dados_invalidos() {
		loginPage.preencheComOsDados(2);
	}
	
	
	@Entao("recebe uma mensagem de erro")
	public void recebe_uma_mensagem_de_erro() {		
		Assert.assertTrue(loginPage.loginErrado());
	}
	
	
	@After
	public void tearDown() {
		homePage.sairDoBrowser();
	}
	
}
