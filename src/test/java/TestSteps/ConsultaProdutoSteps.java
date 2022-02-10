package TestSteps;

import org.junit.Assert;

import TestPages.HomePage;
import TestPages.ProdutoPage;
import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
	
public class ConsultaProdutoSteps {
	
	private HomePage homePage;
	private ProdutoPage produtoPage;
	
	public ConsultaProdutoSteps(){
		homePage = new HomePage();	
	}
	
	@Dado("usuario esta no site")
	public void usuario_esta_no_site() {
			homePage.paginaInicial();
	}

	@E("ele clica para fazer uma consulta de um produto")
	public void ele_clica_para_fazer_uma_consulta_de_produto() {
			homePage.clicaParaFazerUmaBusca();
	}
	
	@Quando("seleciona o produto procurado")
	public void seleciona_o_produto_procurado(){
		produtoPage = homePage.pesquisaItem("17T TOUCH LAPTOP");
				
	}
	
	@Entao("vai para a pagina do mesmo")
	public void vai_para_a_pagina_do_mesmo() {		
		Assert.assertTrue(produtoPage.verificaProduto());

	}
	
		//SEGUNDO CENARIO

	@Quando("busca por um produto que nao existe")
	public void busca_por_um_produto_que_nao_existe() {
		produtoPage = homePage.pesquisaItemErrado("IMPRESSORA LASER");
	}
	
	
	@Entao("vai para uma pagina com uma mensagem de erro")
	public void vai_para_uma_paginacom_uma_mensagem_de_erro() {	
		Assert.assertTrue(produtoPage.mensagemDeProdutoInexistente());
		
	}
	
	@After
	public void tearDown() {
		homePage.sairDoBrowser();
	}

}
