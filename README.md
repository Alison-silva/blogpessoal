<h1 align="center">
  Blog Pessoal
</h1>

<br>

## Descrição do projeto

O projeto consiste em um blog pessoal onde os usuários podem visualizar postagens, 
ler artigos e também fazer login para publicar seus próprios artigos. 
O framework utilizado foi Spring Boot para criar a aplicação web e o mecanismo de 
template Thymeleaf para renderizar as páginas HTML. Para o login foi utilizado o
spring security em memória. A edição de artigos é feita em um campo utilizando o
summernote, um editor simples para bootstrap.

## Tecnologias utilizadas

- Git : Controle de versionamento do sistema.
- Spring Boot : framework mais usado e mais completo hoje em dia para desenvolvimento Web Java.
- Spring MVC : é um framework que ajuda no desenvolvimento de aplicações web, com ele podemos construir aplicações web robustas e flexíveis.
- Spring Tool Suite : IDE para desenvolvimento Java feito para usar o Spring Boot.
- PostgreSQL :  sistema gerenciador de banco de dados objeto relacional (SGBD), fácil de usar com a sua interface gráfica.
- Thymeleaf: Mecanismo de template para renderização de páginas HTML.
- Spring Data JPA: Para interagir com o banco de dados.
- Spring Security: Para autenticação e autorização.

## Instruções para Executar o sistema
<p>Pré-requisitos</p>

- Git
- Spring Tool Suite
- PgAdmin

## Passos

- Abrir um terminal (Ctrl + Shift + T (No ubuntu)) ou linha de comando(Botão Windows + R, digitar cmd e apertar Enter (no Windows))
- Navegar até onde quiser baixar o repositório
- No terminal, colar essa linha e apertar Enter

```
git clone https://github.com/Alison-silva/blogpessoal.git
```

- Abrir O PgAdmin e criar um banco de dados com o nome blogpessoaldb
- Abrir o Spring Tool Suite e clicar em File e depois em Import
- Na nova janela que aparece, escrever no campo do pesquisa maven
- Uma pasta com o nome Maven aparece. Dentro dessa pasta, clicar em Existing Maven Projects e clicar em Next
- Na próxima página, clicar em Browse... e navegar até a pasta blogpessoal e clicar abrir.
- Clicar em Finish
- Esperar o download das dependências do Maven
- Clique com o botão direito no projeto e escolhe a opção 'Run as' e depois escolher 'Spring Boot App'
- O projeto está agora rodando.

O sistema poderá ser acessado em [localhost:8080](http://localhost:8080).

Se ele apresentar um erro, abra o pacote src/main/resources e depois abra o arquivo application.properties.
Coloque o usuário e a senha que você atribuiu ao postgres

```
spring.datasource.username= <coloque seu username>
spring.datasource.password= <coloque sua senha>
```

## Funcionalidades (CRUD)

**Visualização de Postagens e Artigos:**

- Os usuários podem navegar pelo blog e visualizar todas as postagens existentes.
- Cada postagem exibirá o título, conteúdo, data de publicação e o autor.
- Os artigos completos estarão disponíveis para leitura.

**Login de Usuário:**

- Os usuários podem fazer login usando as credenciais do sistema:
```
LOGIN: admin
SENHA: admin
```
- Apenas usuários autenticados terão permissão para publicar artigos.

**Publicação de Artigos:**

- Usuários autenticados podem criar e publicar seus próprios artigos.
- O formulário de criação de artigos incluirá campos para título, autor e texto.
