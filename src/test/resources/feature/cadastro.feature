# language: pt
@cadastro
Funcionalidade: Cadastro de Usuario
  
  Contexto:
  Dado usuario vai para o site escolhido  
  Quando o usuario clica para fazer login no site
  E como nao tem uma conta ele clica para criar uma nova
 
 @cadastro1   
  Cenario: Cadastro Completo
  E coloca seus dados na pagina de cadastro
  Entao volta para a pagina ja logado
  
 @cadastro2 
	Cenario: Cadastro Adicionando Um e-mail Invalido
  E o usuario coloca um valor invalido no campo de email
  Entao recebe uma mensagem de email invalido
  
 @cadastro3 
  Cenario: Cadastro Preenchendo Apenas o Campo de e-mail
  E o usuario preenche so o campo de email
  Entao aparece algumas mensagens de erros nos outros campos obrigatorios