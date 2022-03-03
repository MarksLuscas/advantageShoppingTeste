# language: pt
@login
Funcionalidade: Login de Usuario
  
  Contexto:
  Dado usuario vai para o site
  Quando o usuario clica para fazer login
  
  @login1  
  Cenario: Login Completo
 	E coloca seus dados
  Entao aparece logado na sua conta
  
	@login2
  Cenario: Login Incompleto
 	E coloca os dados invalidos
  Entao recebe uma mensagem de erro
	
