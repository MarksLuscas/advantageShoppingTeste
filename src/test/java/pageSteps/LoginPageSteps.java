package pageSteps;

import java.io.IOException;

import org.junit.Assert;

import TestPages.LoginPage;
import cucumber.TestContext;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;

public class LoginPageSteps {

	
	TestContext testContext;
	LoginPage loginPage;
	
	public LoginPageSteps(TestContext context) throws IOException {
		testContext = context;
		loginPage = testContext.getPageObjectManager().getLoginPage();
	}
	
	// cadastro steps

	@E("como nao tem uma conta ele clica para criar uma nova")
	public void como_nao_tem_uma_conta_ele_clica_para_criar_uma_nova() throws IOException {
		loginPage.clicaParaIrParaAPaginaDeCadastro();
	}
	
	// login steps - cenario 1
	
	@E("coloca seus dados")
	public void coloca_seus_dados() {
		loginPage.preencheComOsDados(1);
	}
	
	
	// login steps - cenario 2
	
	@E("coloca os dados invalidos")
	public void coloca_os_dados_invalidos() {
		loginPage.preencheComOsDados(2);
	}
		
	@Entao("recebe uma mensagem de erro")
	public void recebe_uma_mensagem_de_erro() {		
		Assert.assertTrue(loginPage.loginErrado());
	}
		
}
