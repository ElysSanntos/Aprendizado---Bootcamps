# Aula 11 - Refinando a busca por filmes

**Jacqueline:** Para não deixar fixo o filme "Matrix" na URL do OMDb, vamos usar uma classe já conhecida: o **Scanner** para poder digitar o filme que queremos buscar e conseguir ter uma interatividade no terminal.

**Paulo:** Usamos essa classe no primeiro curso dessa formação. Uma curiosidade é que o `Scanner` é uma classe do `java.util`, o mesmo pacote onde estão as *collections*. Tem muitas classes para o dia a dia que ficam em pacotes ou sub-pacotes relacionados ao `java.util` - como a classe de data que ainda não aprendemos.

A nossa ideia é perguntar "qual filme você quer pesquisar?" para a pessoa digitar a resposta.

## **Criando um `Scanner`**

**Jacqueline:** No arquivo `PrincipalComBusca.java`, vamos adicionar `Scanner` logo no início do `main()`, pois devemos perguntar antes de fazer a requisição.

**Paulo:** Depois vamos reorganizar esse código. Por enquanto, colocamos tudo no `main()` e esse método está ficando muito grande. Mas, depois, vamos organizar ao pensar se podemos criar uma classe, interface, getters e setters - o que é sempre uma dúvida.

**Jacqueline:** Depois vamos separar as responsabilidades: o que buscamos? O que lemos?

Enquanto isso, vamos chamar `Scanner` de `leitura` igual ao `new Scanner()`, passando `System.in`.

Em uma nova linha, vamos digitar "sout" para fazer um `System.out.println()` para imprimir a pergunta: "Digite um filme para busca:" com um espaço ao final e entre aspas duplas.

Vamos precisar ler a resposta. Para isso, colocamos uma `var` denominada `busca` recebendo `leitura.nextLine()`.

Lembre-se que a declaração `var` já faz uma inferência do tipo da variável. A IDE nos aponta que `busca` é uma *string*. No nosso caso, `busca` sempre será uma *string*, mas conseguimos inferir o tipo sem precisar dizer que é uma *string*.

> PrincipalComBusca.java:
> 

```
public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite um filme para busca: ");
        var busca = leitura.nextLine();

// código omitido…

    }
}COPIAR CÓDIGO
```

**Paulo:** Tem muitos lugares no código que poderíamos ter utilizado `var`.

No dia a dia, você vai encontrar as declarações misturadas. Em situações mais simples, vamos utilizar o `var`. Enquanto em situações para leitura, a declaração da variável vai ser mais explícita.

## **Concatenando endereço URL**

**Jacqueline:** Agora, o que precisamos fazer? Vamos modificar a `URI.create()` que é o endereço único, isto é, o identificador do que vamos buscar.

Primeiro, vamos criar uma variável para concatenar o que a pessoa digitou com essa URL do OMDb. Anteriormente, tínhamos colocado o filme "matrix" de forma fixa na URL.

Por exemplo, vamos criar uma *String* `endereco`. Essa *string* vai ter o primeiro trecho da URL, até o "t=".

Em seguida, vamos acrescentar o sinal de `+` para concatenar com o que a pessoa buscou, ou seja, a `busca`.

Adicionamos outro um sinal de `+` seguida da API key. Lembre-se de colocar a sua API key após o sinal de igual.

Com isso, ao invés de fazer um `URI.create()` passando a *string* da URL fixa, vamos passar o `endereco` que foi concatenado.

```
public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {

// código omitido…

        String endereco = "https://www.omdbapi.com/?t=" + busca + "&apikey=coloque_sua_apikey";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

// código omitido…

    }
}COPIAR CÓDIGO
```

**Paulo:** Agora, o endereço da URL é dinâmica para acessar a OMDb.

**Jacqueline:** Após executar a aplicação com "Shift + F10", aparece a pergunta impressa no terminal. Podemos escolher o filme que o Paulo citou que gostava, *Dogville*.

> Digite um filme para busca:
> 
> 
> *dogville*
> 

Após apertar "Enter", a aplicação vai conseguir encontrar os dados do filme *Dogville* em JSON:

> {"Title":"Dogville","Year":"2003","Rated":"R","Released":"23 Apr 2004","Runtime":"178 min", (restante omitido…)}
> 

A busca por filme já ficou mais dinâmica. Geralmente, vamos solicitar um item, onde cada um digita o filme que deseja. Depois, poderíamos colocar essa busca em um *loop*, uma repetição para digitar vários filmes.

Existem várias possibilidades do que podemos fazer. A princípio, nosso código já atende para começar a fazer buscas diferentes e testar para encontrar problemas.

Contudo, não queríamos que o retorno ficasse como JSON. Gostaríamos que os dados do filme fossem representados como a nossa classe de `Titulo`, `Serie` ou `Filme`.

Nesse caso, podemos trabalhar com `Titulo`. Por exemplo, existem vários `Titulos`, mas a pessoa pode querer sugerir um título no Screenmatch.

Para isso, agora precisamos tentar pegar essa informação do **JSON de atributo-valor e transformar em classe**. Queremos transformar em uma classe que tenha esses campos (como título e ano) para poder fazer uma calculadora, uma recomendação e outras utilidades que implementamos no projeto.

**Paulo:** Para isso, vamos precisar de uma biblioteca Java que faça essa transformação.

**Jacqueline:** Poderíamos fazer isso de outra forma? Sim. Poderíamos manipular manualmente, varrer esse texto e pegar um padrão. Por exemplo, começa e termina com aspas. Ou fazer um `map` para ter um mapa de qual é o campo e qual é o valor. Mas, não é preciso.

Nesse momento, já podemos recorrer a uma biblioteca que faz essa "mágica" no nosso lugar.

**Paulo:** Sem ter que falar: pega o que está entre aspas do "Title" e faz o `.setNome()` no filme. Em seguida, ter que fazer um `for` e dar `new Filme` para cada um dos filmes.

**Jacqueline:** Já existem bibliotecas que fazem esse processo. Vamos conhecer?