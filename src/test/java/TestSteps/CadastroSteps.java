package TestSteps;


import java.io.IOException;

import org.junit.Assert;

import TestPages.HomePage;
import TestPages.LoginPage;
import TestPages.RegisterPage;
import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class CadastroSteps {
		
	private HomePage homePage;
	private RegisterPage registerPage;
	private LoginPage loginPage;
	
	
	public CadastroSteps() {
		homePage = new HomePage();
	}
	
	@Dado("usuario vai para o site escolhido")
	public void usuario_vai_para_o_site_escolhido() {
		homePage.paginaInicial();	
	}
	
	@Quando("o usuario clica para fazer login no site")
	public void o_usuario_clica_para_fazer_login_no_site() throws IOException{
		loginPage = homePage.vaiParaAPaginaDeLogin();	
	}

	@E("como nao tem uma conta ele clica para criar uma nova")
	public void como_nao_tem_uma_conta_ele_clica_para_criar_uma_nova() throws IOException {
		registerPage = loginPage.clicaParaIrParaAPaginaDeCadastro();
	}
		
	@E("coloca seus dados na pagina de cadastro")
	public void coloca_seus_dados_na_pagina_de_cadastro() {
		registerPage.preencheOsDados(1);
	}
	
	@Entao("volta para a pagina ja logado")
	public void volta_para_a_pagina_ja_logado()  {
		Assert.assertTrue(registerPage.estaLogadoComOCadastroNovo());	
	}

	
	// SEGUNDO CENARIO 
	
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
	
	@After
	public void tearDown() {
		homePage.sairDoBrowser();
	}
	
}
