package steps;


import org.junit.Assert;

import TestPages.ProductPage;
import cucumber.TestContext;
import io.cucumber.java.pt.Entao;

public class SearchProductSteps {

	
	TestContext testContext;
	ProductPage produtoPage;
	
	public SearchProductSteps(TestContext context)	{
		testContext = context;
		produtoPage = testContext.getPageObjectManager().getProductPage();
	}
	
	
	@Entao("vai para a pagina do mesmo")
	public void vai_para_a_pagina_do_mesmo() {		
		Assert.assertTrue(produtoPage.verificaProduto());
	}
	
	//SEGUNDO CENARIO
	
	@Entao("vai para uma pagina com uma mensagem de erro")
	public void vai_para_uma_paginacom_uma_mensagem_de_erro() {	
		Assert.assertTrue(produtoPage.mensagemDeProdutoInexistente());
	}
}
