# language: pt

Funcionalidade: Cadastro de Usuario
  
  Cenario: Cadastro Completo
  Dado usuario vai para o site escolhido  
  Quando o usuario clica para fazer login no site
  E como nao tem uma conta ele clica para criar uma nova
  E coloca seus dados na pagina de cadastro
  Entao volta para a pagina ja logado
  
	Cenario: Cadastro Adicionando Um e-mail Invalido
  Dado usuario vai para o site escolhido  
  Quando o usuario clica para fazer login no site
  E como nao tem uma conta ele clica para criar uma nova
  E o usuario coloca um valor invalido no campo de email
  Entao recebe uma mensagem de email invalido
  
  Cenario: Cadastro Preenchendo Apenas o Campo de e-mail
  Dado usuario vai para o site escolhido
  Quando o usuario clica para fazer login no site
  E como nao tem uma conta ele clica para criar uma nova
  E o usuario preenche so o campo de email
  Entao aparece algumas mensagens de erros nos outros campos obrigatorios