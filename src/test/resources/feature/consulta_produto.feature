# language: pt
@consulta_produto
Funcionalidade: Consultar Produto pela tela principal, utilizando a campo de pesquisa.
  
  Contexto:
  Dado usuario esta no site  							 
  E ele clica para fazer uma consulta de um produto
  
  @consulta_produto1  
  Cenario: Consultando um produto ate a tela do mesmo
  Quando seleciona o produto procurado
  Entao vai para a pagina do mesmo

@consulta_produto2
  Cenario: Consultando um produto que nao existe no site 
  Quando busca por um produto que nao existe
  Entao vai para uma pagina com uma mensagem de erro	 
  
  
  
  
  