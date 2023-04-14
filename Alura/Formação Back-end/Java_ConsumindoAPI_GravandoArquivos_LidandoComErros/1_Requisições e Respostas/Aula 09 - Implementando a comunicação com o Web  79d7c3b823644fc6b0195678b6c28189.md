# Aula 09 - Implementando a comunicação com o Web Service

> Arquivo [PrincipalComBusca no GitHub](https://github.com/jacqueline-oliveira/2944-java-screenmatch-consumindo-webservice/blob/aula01/src/br/com/alura/screenmatch/principal/PrincipalComBusca.java)
> 

**Jacqueline:** Vamos ao código e iniciar a nossa busca!

**Paulo:** Já temos a API e já aprendemos como testar manualmente no navegador quanto no Postman. Agora, como fazemos isso em Java? Vamos criar uma classe?

**Jacqueline:** Isso mesmo, vamos criar uma classe nova.

No IntelliJ, estamos com o projeto feito anteriormente e navegamos para "screenmatch > src > br.com.alura.screenmatch > principal". Clicamos com o botão direito na pasta `principal` e escolhemos "New > JavaClass", chamada de `PrincipalComBusca` (dado que vamos buscar o filme).

Ao teclamos "Enter" já temos uma estrutura base do arquivo, onde dentro da classe `PrincipalComBusca{}` podemos criar o `public static void main (String[] args){}`.

> PrincipalComBusca.java
> 

```
package br.com.alura.screenmatch.principal;

public class PrincipalComBusca {
        public static void main (String[] args){

        }
}
```

Sabemos que já temos uma biblioteca para isso, mas orecisamos verificar se há uma biblioteca Java. Para isso, vamos recorrer ao [Java Doc](https://docs.oracle.com/en/java/javase/17/docs/api/index.html) .

Mencionamos que estamos fazendo um *HTTP request* (Traduzindo, "requisição HTTP"), buscamos justamente por isso no campo "*Search*" do lado direito superior. Já nos exibe um menu flutuante com algumas seções, como "*Classes and Interface*s" e "Members". Na primeira seção, temos a opção "java.net.http.HttpRequest", selecionamos ela.

> Class HttpRequest
> 

É uma classe, em que conseguimos fazer uma requisição. Observe que ele nos dá até um exemplo:

> Exemplo retirado do site
> 

```
   HttpClient client = HttpClient.newHttpClient();
   HttpRequest request = HttpRequest.newBuilder()
         .uri(URI.create("http://foo.com/"))
         .build();
   client.sendAsync(request, BodyHandlers.ofString())
         .thenApply(HttpResponse::body)
         .thenAccept(System.out::println)
         .join();COPIAR CÓDIGO
```

Precisamos criar um `HttpClient`, e fazer uma requisição passando um determinado endereço.

**Paulo:** Nesse trecho, usamos a classe `HttpClient` par fazer uma requisição HTTP assíncrona para a URL "[http://foo.com/"](http://foo.com/%22), imprimindo o corpo da resposta do console.

É comum pegarmos um trecho de código que não sabemos o que está acontecendo (não é o caso). Ou seja, é normal copiarmos e colar trechos de código, mas é importante entender o que os métodos e elementos estão fazendo, como, por exemplo, o `join`, o `build`, o `thenApply`, etc.

Entretanto, para consumir um serviço é normal o copiar e colar ser o suficiente. Nesse caso, vamos copiar esse trecho e alterar a URL, não é?

**Jacqueline:** Isso mesmo. Vamos copiar o exemplo até o `build()` e colar no nosso arquivo.

> PrincipalComBusca.java
> 

```
package br.com.alura.screenmatch.principal;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class PrincipalComBusca {
        public static void main (String[] args){
                HttpClient client = HttpClient.newHttpClient();
               HttpRequest request = HttpRequest.newBuilder()
             .uri(URI.create("http://foo.com/"))
             .build();
        }
}COPIAR CÓDIGO
```

Precisamos importar teclando "Alt + Enter" em `HttpRequest`, `HttpClient` e para o `URI`.

Quando estamos fazendo uma conexão (pedindo alguma coisa) é muito no sentido de termos um cliente e um servidor (alguém realiza a solicitação e alguém devolve). Logo, precisamos do `client` para efetuar esse pedido.

O responsável por nos informar para onde é essa requisição é o `request`. Entretanto, o que é esse `build()`? Se tentarmos colocar o seguinte trechp de código:

> PrincipalComBusca
> 

```
// código omitido

            HttpRequest req = new HttpRequest;
        }
}COPIAR CÓDIGO
```

Observe que aoarece um sublinhado na cor vermelha em `new HttpRequest`. Significa que ele não deixa fazer esse `new`, porque esse `HttpRequest` é abstrato e não podemos instanciar (basta colocar o mouse por cima para exibir a mensagem).

O padrão usado é o de projeto builder, sendo para criar objetos complexos. Criamos um builder e passamos somente o que precisamos naquele determinado momento para construir a referência para o objeto.

Com o padrão builder, pegamos um objeto considerado complexo e montamos através de métodos.

**Paulo:** Caso você ainda não tenha se deparadou com um ***Design Pattern*** (Padrão de Projeto), esse `builder` do `request` aparece bastante em outras classes.

Mencionamos que orientação a objetos, interfaces e encapsulamento iam aparecer. Nesse curso, vamos ver bastantes elementos que irão nos lembrar de bibliotecas que já vimos em vídeo anteriores.

É isso que queremos que você sinta, que todos os princípios de encapsulamento, de orientação a objetos e como arquitetamos as coleções e a list. Esses elementos aparecem com bastante frequência.

**Jacqueline:** Exatamente.

Vamos remover a linha que fizemos anteriormente, não vamos usá-la para nada. Trocamos para o nosso endereço ao invés do que colamos junto com o exemplo.

> PrincipalComBusca.java
> 

```
package br.com.alura.screenmatch.principal;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class PrincipalComBusca {
        public static void main (String[] args){
                HttpClient client = HttpClient.newHttpClient();
               HttpRequest request = HttpRequest.newBuilder()
             .uri(URI.create("https://www.omdbapi.com/?t=divertidamente&apikey=6585022c"))
             .build();
        }
}COPIAR CÓDIGO
```

Mas precisamos da busca e faltou informar qual a resposta.

Fizemos a requisição, mas precisamos da resposta. Para isso, usamos o `HttpResponse`. Como não desejamos entrar na questão do assíncrono, vamos ao Java Doc buscar pela documentação desse HttpResponse.

> Interface HttpResponse
> 

Temos um exemplo nesse site:

```
   HttpResponse<String> response = client
     .send(request, BodyHandlers.ofString());COPIAR CÓDIGO
```

Conseguimos obter uma resposta através do `send` do cliente. Ou seja, podemos obter um JSON representado enviando com o `client`.

**Paulo:** Vamos testar?

**Jacqueline:** Vamos testar. Podemos copiar esse trecho de código e voltar ao arquivo `PrincipalComBusca` para colar abaixo do `.build()`. Depois importamos o que estiver indicando no IntelliJ.

> PrincipalComBusca.java
> 

```
package br.com.alura.screenmatch.principal;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PrincipalComBusca {
        public static void main (String[] args){
                HttpClient client = HttpClient.newHttpClient();
               HttpRequest request = HttpRequest.newBuilder()
             .uri(URI.create("https://www.omdbapi.com/?t=divertidamente&apikey=6585022c"))
             .build();
                HttpResponse<String> response = client
                         .send(request, HttpResponse.BodyHandlers.ofString());
        }
}COPIAR CÓDIGO
```

Observe que temos um sublinhado na cor vermelha no `send`, isso acontece porque ele lança uma exceção. E ao lançar uma exceção, ela precisa receber um tratamento ou delegar para quem chamou.

Com o mouse sobre o `send` clicamos na frase escrita na cor azul claro (clicável) "*Add exceptions to method signature*" (em português, "Adicionar exceções à assinatura do método") ou podemos usar o atalho "Alt + Shift + Enter".

Ao clicarmos, ele coloca de forma automática o `throws IOException, InterruptedException` após o nosso `void main`.

> PrincipalComBusca.java
> 

```
package br.com.alura.screenmatch.principal;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PrincipalComBusca {
        public static void main (String[] args) throws IOException, InterruptedException {
                HttpClient client = HttpClient.newHttpClient();
               HttpRequest request = HttpRequest.newBuilder()
             .uri(URI.create("https://www.omdbapi.com/?t=divertidamente&apikey=6585022c"))
             .build();
                HttpResponse<String> response = client
                         .send(request, HttpResponse.BodyHandlers.ofString());
        }
}COPIAR CÓDIGO
```

**Paulo:** Algumas *exceptions* no Java possuem uma característica um pouco diferente que é sermos obrigados a informar o que faremos com essa exceção. Isto é: caso ocorra determinado tipo de problema, o que essa exceção irá fazer. No nosso caso, não vamos fazer nada e quem chamou que será delegada a tarefa.

**Jacqueline:** Desejamos imprimir essa resposta. Abaixo do `send` colocamos `System.out.println(response.)`, entretanto, precisamo exibir o corpo da resposta, então digitamos `.body()`. Depois alteramos o nome do filme na URL de divertidamente para matrix.

> PrincipalComBusca.java
> 

```
package br.com.alura.screenmatch.principal;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PrincipalComBusca {
        public static void main (String[] args) throws IOException, InterruptedException {
                HttpClient client = HttpClient.newHttpClient();
               HttpRequest request = HttpRequest.newBuilder()
             .uri(URI.create("https://www.omdbapi.com/?t=matrix&apikey=6585022c"))
             .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        }
}COPIAR CÓDIGO
```

Agora vamos testar, clicando no botão de play "▶" na linha 10 do nosso `void main` (ou podemos usar o atalho "Ctrl + Shift + F10").

Como retorno no console, obtemos:

```
{"Title":"Matrix","Year":"1993","Rated":"N/A","Released":"01 Mar 1993","Runtime":"60 min","Genre":"Action, Drama, Fantasy","Director":"N/A","Writer":"Grenville Case","Actors":"Nick Mancuso, Phillip Jarrett, Carrie-Anne Moss","Plot":"Steven Matrix is one of the underworld's foremost hitmen until his luck runs out, and someone puts a contract out on him. Shot in the forehead by a .22 pistol, Matrix \"dies\" and finds himself in \"The City In Between\", where he is ...","Language":"English","Country":"Canada","Awards":"1 win","Poster":"https://m.media-amazon.com/images/M/MV5BYzUzOTA5ZTMtMTdlZS00MmQ5LWFmNjEtMjE5MTczN2RjNjE3XkEyXkFqcGdeQXVyNTc2ODIyMzY@._V1_SX300.jpg","Ratings":[{"Source":"Internet Movie Database","Value":"7.8/10"}],"Metascore":"N/A","imdbRating":"7.8","imdbVotes":"199","imdbID":"tt0106062","Type":"series","totalSeasons":"N/A","Response":"True"}COPIAR CÓDIGO
```

Assim, conseguimos realizar a busca e exibir a resposta em Java.

**Paulo:** Pegamos o JSON acessando o que a página na web traria, sendo o que o Postman faz e como o navegador funciona também.

**Jacqueline:** Sem implementar praticamente nada, conseguimos obter esse retorno.

**Paulo:** Nesse caso, desejamos ver qual o trecho de código que captura o corpo da resposta no site. Estamos inserindo tudo no `main`, mais adiante vamos quebrar isso e separar cada código de acordo com a sua função.

Usei a palavra "API" para o `HttpClient` e isso pode ser confuso. Essa palavra aparece quando falamos que vamos consumir uma API chamando um serviço web. Mas quando se trata do `HttpClient`, quando analisamos os `imports` da parte superior do código, temos o `java.net.http` sendo um dos pacotes do Java. Às vezes, também falamos "A API de conexão HTTP do Java".

Quando se tratar de código, vou tentar me referir a biblioteca e API quando estamos chamando alguma coisa na web.

**Jacqueline:** Vamos melhorar essa busca para começar a pesquisar por mais filmes. Te espero na próxima aula!