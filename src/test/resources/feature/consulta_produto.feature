# language: pt

Funcionalidade: Consultar Produto pela tela principal, utilizando a campo de pesquisa.
  
  Cenario: Consultando um produto ate a tela do mesmo
  Dado usuario esta no site  							 
  E ele clica para fazer uma consulta de um produto
  Quando seleciona o produto procurado
  Entao vai para a pagina do mesmo

  Cenario: Consultando um produto que nao existe no site 
  Dado usuario esta no site 
  E ele clica para fazer uma consulta de um produto 		
  Quando busca por um produto que nao existe
  Entao vai para uma pagina com uma mensagem de erro	 
  
  
  
  
  