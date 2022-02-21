package pageSteps;

import java.io.IOException;

import org.junit.Assert;

import TestPages.HomePage;
import cucumber.TestContext;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class HomePageSteps {
	
	TestContext testContext;
	HomePage homePage;
	
	public HomePageSteps(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
	}
	
	// cadastro step
	
	@Dado("usuario vai para o site escolhido")
	public void usuario_vai_para_o_site_escolhido() {
		homePage.paginaInicial();	
	}
	
	@Quando("o usuario clica para fazer login no site")
	public void o_usuario_clica_para_fazer_login_no_site() throws IOException{
		homePage.vaiParaAPaginaDeLogin();	
	}
		
	@Entao("volta para a pagina ja logado")
	public void volta_para_a_pagina_ja_logado()  {
		Assert.assertTrue(homePage.estaLogadoComOCadastroNovo());
	}
	
	//Consulta o produto - cenario 1
	
	@Dado("usuario esta no site")
	public void usuario_esta_no_site() {
		//indo para a homePage pelo driver
		homePage.paginaInicial();
	}

	@E("ele clica para fazer uma consulta de um produto")
	public void ele_clica_para_fazer_uma_consulta_de_produto() {
		homePage.clicaParaFazerUmaBusca();
	}
	
	@Quando("seleciona o produto procurado")
	public void seleciona_o_produto_procurado() {
		homePage.pesquisaItem("17T TOUCH LAPTOP");			
	}
	
	// Consulta produto - cenario 2
	
	@Quando("busca por um produto que nao existe")
	public void busca_por_um_produto_que_nao_existe() {
		homePage.pesquisaItemErrado("IMPRESSORA LASER");
	}
	
	// login steps
	
	@Dado("usuario vai para o site")
	public void usuario_vai_para_o_site() {
		//indo para a homePage no driver
		homePage.paginaInicial();
	}

	@Quando("o usuario clica para fazer login")
	public void o_usuario_clica_para_fazer_login() throws IOException {
		homePage.vaiParaAPaginaDeLogin();
	}
		
	@Entao("aparece logado na sua conta")
	public void aparece_logado_na_sua_conta() {		
		Assert.assertTrue(homePage.estaLogado());
	}
}
