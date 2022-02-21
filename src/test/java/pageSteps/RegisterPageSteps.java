package pageSteps;

import java.io.IOException;

import org.junit.Assert;

import TestPages.RegisterPage;
import cucumber.TestContext;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;

public class RegisterPageSteps {
	
	
	TestContext testContext;
	RegisterPage registerPage;
	
	public RegisterPageSteps(TestContext context) throws IOException {
		testContext = context;
		registerPage = testContext.getPageObjectManager().getRegisterPage();
	}
		
	@E("coloca seus dados na pagina de cadastro")
		public void coloca_seus_dados_na_pagina_de_cadastro() {
		registerPage.preencheOsDados(1);
	}
	
	// segundo cenario
		
	@E("o usuario coloca um valor invalido no campo de email")
	public void o_usuario_coloca_um_valor_invalido_no_campo_de_email() {
		registerPage.preencheOsDados(2);
	}
		
	@Entao("recebe uma mensagem de email invalido")
	public void recebe_uma_mensagem_de_email_invalido() {
		registerPage.mensagemDeEmailInvalido();
	}
		
	//TERCEIRO CENARIO
	
	@E("o usuario preenche so o campo de email")
	public void o_usuario_preenche_so_o_campo_de_email() {
		registerPage.preencheOCampoDeEmail(3);
	}
		
	@Entao("aparece algumas mensagens de erros nos outros campos obrigatorios")
	public void aparece_algumas_mensagens_de_erros_nos_outros_campos_obrigatorios() {
		Assert.assertTrue(registerPage.mensagensDeErro());
	}
}