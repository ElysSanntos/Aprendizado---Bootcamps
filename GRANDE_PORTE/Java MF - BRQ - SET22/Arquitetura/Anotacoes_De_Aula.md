<h2 align = "center" >Aula 1  - Arquitetura - 27/09/2022<h2>

<h3 align = "center" ><a href="https://github.com/ffborelli/">Professor: Fabrizio Borelli</a></h3>
</br></br>

```

API professores grande porte
https://cors.grandeporte.com.br/cursos.grandeporte.com.br:8080/professores

SWAGGER
https://petstore.swagger.io/

{} -> é um objeto
[] -> é um array

# Json é chave : valor

"nome" : "Fabrizio",
"sobrenome": "Borelli",
"idade": 34

# Todo Json começa com {} ou  []

{
  "curso" : "Java",
  "professor" : "Nelson", 
  "carga-horaria" : 296,
  "telefones" : [
      "11982733817", "1144833839"
  ]
}

```

# Sobre REST, temos os seguintes verbos:

```

"GET": para "retornar" dados
"POST": para "enviar" dados novos
"PATCH": Para atualizar dados
"PUT": Para atualizar dados
"DELETE": Para deletar dados


```


<h2 align = "center" >Aula 2  - Arquitetura - 28/09/2022<h2>

<h3 align = "center" ><a href="https://github.com/ffborelli/">Professor: Fabrizio Borelli</a></h3>
</br></br>

```
Diferença entre os métodos PATCH e POST PUT

PATCH ==>Altera pequenos ajustes ou alguns itens do objeto
POST  ==> Cria um novo Objeto
PUT   ==> Alterar todos os atributos da entidade

**PUT é usado quando enviamos um objeto completo. Se você quiser atualizar só uma parte dele e não reenviar tudo, use PATCH** 

```
# CRUD -> CREATE, READ, UPDATE , DELETE

É Criar, Ler, Alterar e Deletar uma **ENTIDADE**, como por exemplo, professores.

1. GET ALL (READ)
2. GET ONE (READ)
3. POST    (CREATE)
4. PATCH   (UPDATE) ou PUT (UPDATE)
5. DELETE  (DELETE)

Sendo mais genérico: 

1. GET ALL --  /entidade
2. GET ONE (READ) --  /entidade/{id_da_entidade}
3. POST    (CREATE) --  /entidade
4. PATCH   (UPDATE) ou PUT (UPDATE) --  /entidade/{id_da_entidade}
5. DELETE  (DELETE) /entidade/{id_da_entidade}

Exemplo: 

1. GET ALL --  /usuarios
2. GET ONE (READ) --  /usuarios/{id_do_usuario}
3. POST    (CREATE) --  /usuarios
4. PATCH   (UPDATE) ou PUT (UPDATE) --   /usuarios/{id_do_usuario}
5. DELETE  (DELETE)  /usuarios/{id_do_usuario}
6. GET /usuarios/{id_do_usuario}/nome/{nome_do_usuario}


# Introdução a IDE Intelijl
## Criar projeto
https://start.spring.io/


<h2 align = "center" >Aula 3  - Arquitetura - 29/09/2022<h2>

<h3 align = "center" ><a href="https://github.com/ffborelli/">Professor: Fabrizio Borelli</a></h3>
</br></br>


# Maven

É um gerenciador de dependências 

Observar arquivo pom.xml


# Dependências : 

## spring-boot-starter-web

Para criar a camada de exposição do serviço (aka, permitir export nossos endpoint)

Um endpoint é um recurso que podemos disponibilizar para uso (ex: /professores da grande porte)

## spring-boot-devtools

Ajuda a aumentar a velocidade de desenvolvimento dos micro serviços, como por exemplo, o auto restart do mesmo quando m código é alterado

## spring-boot-starter-test

Responsável por fazer testes unitários na aplicação.

Um teste unitário é um teste que testa individualmente cada trecho de código. 
Este teste é automatiza e criado pelo desenvolvedor da aplicação. 

Veremos neste curso.

# Design Patterns (Padrões de Projeto)

São padrões estipulados por uma comunidade com o objetivo de auxiliar a desenvolver uma arquitetura de software padronizada e que evite "certos problemas"

Utilizamos padrões de projetos para evitar erros conhecidos e também facilitar o entendimento do projeto

## No cenário de estrutura de uma aplicação, temos o padrão de projeto conhecido como MVC

### MVC : Model , View, Controller

O MVC divide a nossa aplicação em 3 grandes camadas, com responsabilidades específica.

- Na camada Model encontramos as regras de negócio e acesso ao banco de dados
- Na camada View, é a parte de visualização para o usuário (não veremos neste curso)
- Na camada controller, encontramos a ligação entre as camadas Model e View

### Anotações em JAVA

Anotações no JAVA possui o objetivo de sinalizar para o compilador a real funcionalidade da classe ou parâmetro ou da variável

OBS: toda anotação em JAVA começa com a **@**

### Anotações do Spring Boot

- @RestController : anotação que permite a classe em questão manipular requisições do tipo REST

Obs: todo endpoint da camada de controller deve ser mapeado com um método