# language: pt

Funcionalidade: Login de Usuario
  
  Cenario: Login Completo
  Dado usuario vai para o site
  Quando o usuario clica para fazer login
 	E coloca seus dados
  Entao aparece logado na sua conta

  Cenario: Login Incompleto
  Dado usuario vai para o site
  Quando o usuario clica para fazer login
 	E coloca os dados
  Entao recebe uma mensagem de erro
	
