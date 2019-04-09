--- Ferramentas 
Cicero Vieira da Silva - Email cicvieira@yahoo.com.br
WhatsApp +5511 94011-3640

- Spring Boot Version 1.5.4.RELEASE
- Spring Tool Suite 4
- AngularJS 1.6.3
- Mysql (Nome Banco de Dados Creditoapp)- JavaSE (1.6 - 1.8)

Formulário Simples
Com:
Nome Cliente
Limite de crédito
Risco
Porcentagem (%) juros
Valor(R$) Juros
Valor(R$) Com Juros

Usuário Informa o nome do cliente e Limite
E tipo do risco, o sistema mostra a taxa de juros, valor do juros e valor total com juros.
Opção Salvar, Editar ou Excluir

No final do desenvolvimento deu um pequeno conflito ao compilar, mais como estava em cima já 
não deu tempo verificar.

Porém funcionou perfeitamente
http://localhost:8080/



PREMISSA
Desenvolver camada visual com AngularJS e um serviço para tratar das
regras de negócio
Fique à vontade para definir a arquitetura e o modelo de persistência.
- Linguagem: Java
- Front-end: AngularJS
- Injeção de dependência: Spring
- Informações devem ser persistidas em um banco de dados.
FLUXO DE TELA
Criar um formulário com os seguintes campos:
- Nome Cliente
Tipo: texto
- Limite de credito
Tipo: numérico (R$)
- Risco
Tipo: lista
Valores possíveis: A, B e C
REGRAS DE NEGÓCIO
- Todas informações devem ser persistidas mais um campo indicando a
taxa de juros.
- Todos campos são obrigatórios
- Se o risco for do tipo A manter os dados informados
- Se o risco for do tipo B, a taxa de juros deve ser de 10%
- Se o risco for do tipo C, a taxa de juros deve ser de 20%
















