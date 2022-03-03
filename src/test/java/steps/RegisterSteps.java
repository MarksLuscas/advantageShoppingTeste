package steps;

import java.io.IOException;

import org.junit.Assert;

import TestPages.RegisterPage;
import cucumber.TestContext;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;

public class RegisterSteps {
	
	
	TestContext testContext;
	RegisterPage registerPage;
	
	public RegisterSteps(TestContext context) throws IOException {
		testContext = context;
		registerPage = testContext.getPageObjectManager().getRegisterPage();
	}
		
	@E("coloca seus dados na pagina de cadastro")
		public void coloca_seus_dados_na_pagina_de_cadastro() {
		registerPage.preencheONome(1);
		registerPage.preencheOEmail(1);
		registerPage.preencheASenha(1);
		registerPage.preencheAConfirmacaoDeSenha(1);
		registerPage.preencheOPrimeiroNome(1);
		registerPage.preencheOSegundoNome(1);
		registerPage.preencheOTelefone(1);
		registerPage.escolheOPais();
		registerPage.preencheACidade(1);
		registerPage.preencheOEndereco(1);
		registerPage.preencheOEstado(1);
		registerPage.preencheOCodigoPostal(1);
		
		registerPage.clicaBotaoDeConfirmaCondicao();
		registerPage.clicaBotaoSeRegistrar();
	}
	
	// segundo cenario
		
	@E("o usuario coloca um valor invalido no campo de email")
	public void o_usuario_coloca_um_valor_invalido_no_campo_de_email() {
		registerPage.preencheONome(2);
		registerPage.preencheOEmail(2);
		registerPage.preencheASenha(2);
		registerPage.preencheAConfirmacaoDeSenha(2);
		registerPage.preencheOPrimeiroNome(2);
		registerPage.preencheOSegundoNome(2);
		registerPage.preencheOTelefone(2);
		registerPage.escolheOPais();
		registerPage.preencheACidade(2);
		registerPage.preencheOEndereco(2);
		registerPage.preencheOEstado(2);
		registerPage.preencheOCodigoPostal(2);
		
		registerPage.clicaBotaoDeConfirmaCondicao();
		registerPage.clicaBotaoSeRegistrar();
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