# Aula 03 - Conhecendo uma API para buscar dados

**Paulo:** Jaque, temos em um site que contém uma API, o [OMDb API](https://omdbapi.com/) . Essa palavra "API" ganhou diversos significados, o Java.util, por exemplo, é uma API onde fazemos chamadas para a biblioteca padrão do Java que possui as coleções que usamos bastante.

Atualmente, isso tem crescido e a API significa também programas que podemos acessar na web de forma remota de outro site, realizar uma chamada para uma API (isto é, enviar e receber informações) geralmente via HTTP. São as chamadas de serviços e consumir os microsserviços, algo bem comum e que fazemos o dia todo.

O interessante é que com o conhecimento que já temos sobre o Java, conseguimos consumir uma API e resolver um problema. No caso, escolhemos o OMDb API, porém, há diversos outros sites, como o AdoroCinema, o Rotten Tomatoes, o IMDb e o Omelete, entre outros sites que oferecem dados sobre filmes e séries.

**O OMDb oferece uma API**. Informando que se passarmos uma mensagem em um determinado padrão, é devolvida uma resposta em determinado padrão também. E, com isso, conseguimos buscar os Webviews, o avatar e pegar essas informações.

Assim, não temos mais um sistema fictício onde está tudo escrito no `public static void main`. Estamos conectando na Internet, puxando e minerando esses dados, e exibindo somente o que desejamos. Isso é o que acontece em uma aplicação real, seja no back-end (como estamos fazendo aqui), ou no dispositivo móvel, ou para o front-end onde passamos essa informação para o React.

Nesse curso, vamos aplicar coisas do mundo real. Gostaria de entender como funciona essa API e como exploramos? Temos no menu superior do OMDb uma API Key, parâmetros, exemplos, entre outras abas.

**As diversas APIs possuem documentações diferentes**. E isso é um desafio que seria interessante você passar com a Jacqueline e comigo: conhecer a documentação de uma biblioteca na web ou uma API na web, saber chamá-la, e realizar testes, são coisas aplicadas no cotidiano.

Você vai ver que a Jacqueline e eu vamos passar por alguns problemas ao longo do curso. Por exemplo, levantando questões do tipo: será que precisamos de uma biblioteca Java para isso? Será que precisamos criar um login e uma senha? Precisamos criptografar os dados? Como podemos testar sem ser de forma manual?

São desafios bem comuns no cotidiano de pessoas desenvolvedoras não apenas de Java.

**Jacqueline:** Exatamente. No cotidiano trabalhamos integrando sistemas e muitas vezes precisamos consumir esses serviços. Nessa API, por exemplo, podemos fazer a requisição e receber uma resposta.

Descendo a página inicial do OMDb API, em "Usage" (em português, "uso"), temos como deve ser usado. Precisamos realizar uma requisição para um determinado endereço e ter uma chave. Já vamos entender melhor sobre isso.

> "Usage" retirado do site do OMDb API
> 
- Send all data requests to: [http://www.omdbapi.com/?apikey=[yourkey]&](http://www.omdbapi.com/?apikey=%5Byourkey%5D&)
- Poster API requests: [http://img.omdbapi.com/?apikey=[yourkey]&](http://img.omdbapi.com/?apikey=%5Byourkey%5D&)

Descendo um pouco mais, temos alguns parâmetros (seção "*Parameters*") que podemos passar na URL para identificar se vamos buscar um título pelo ID ou pelo nome (*By ID or Title*). Já temos uma documentação bem básica sobre essa API para entendermos como ela funciona.

**Paulo:** Uma documentação meio primitiva.

**Jacqueline:** Sim.

**Paulo:** É comum testarmos para verificar se é da forma que entendemos mesmo.

**Jacqueline:** Nessa documentação temos até uma seção "Examples" (em português, "exemplos"). Nessa parte, temos uma busca por título (*by title*) e outra por ID (*by ID*). Se buscarmos pelo título "Matrix" no campo `Title` e teclarmos "Enter", obtemos o seguinte JSON com o exemplo do retorno:

```
{"Title":"Matrix","Year":"1993","Rated":"N/A","Released":"01 Mar 1993","Runtime":"60 min","Genre":"Action, Drama, Fantasy","Director":"N/A","Writer":"Grenville Case","Actors":"Nick Mancuso, Phillip Jarrett, Carrie-Anne Moss","Plot":"Steven Matrix is one of the underworld's foremost hitmen until his luck runs out, and someone puts a contract out on him. Shot in the forehead by a .22 pistol, Matrix \"dies\" and finds himself in \"The City In Between\", where he is ...","Language":"English","Country":"Canada","Awards":"1 win","Poster":"https://m.media-amazon.com/images/M/MV5BYzUzOTA5ZTMtMTdlZS00MmQ5LWFmNjEtMjE5MTczN2RjNjE3XkEyXkFqcGdeQXVyNTc2ODIyMzY@._V1_SX300.jpg","Ratings":[{"Source":"Internet Movie Database","Value":"7.8/10"}],"Metascore":"N/A","imdbRating":"7.8","imdbVotes":"199","imdbID":"tt0106062","Type":"series","totalSeasons":"N/A","Response":"True"}COPIAR CÓDIGO
```

Em "*Request*" temos:

> http://www.omdbapi.com/?t=matrix
> 

Se digitarmos essa URL incluindo a chave no final, temos a resposta em JSON que ele nos informou.

**Paulo:** Essa estrutura da resposta entre chaves com vários elementos dentro pode assustar de primeira, mas isso é um formato JSON.

> JSON: JavaScript Object Notation
> 

O formato do JSON até lembra um pouco o XML ou txt puro, que é possível encadear informações. Por exemplo, a parte que tem o `"Title":"Matrix",` ai seguido da vírgula o `"Year":"1993",`, perceba que são apenas dados encadeados em um formato específico.

Essa é o formato mais usado, tanto que vamos pesquisar sobre bibliotecas Java que possam pegar esse tipo de texto (dado que isso seria uma string grande) e convertê-lo em um objeto.

Também já nos fornecei um exemplo omdbapi.com/?t=matrix, assim ele já nos retorna o filme chamado de Matrix.

**Jacqueline:** Na API Key precisamos passar uma API Key. Se tentarmos acessar o endereço que ele gerou para nós pelo navegador ([http://www.omdbapi.com/?t=matrix](http://www.omdbapi.com/?t=matrix)), obtemos:

> {"Response":"False","Error":"No API key provided."}
> 

Observe que ele foi informado que não passamos nenhuma API Key, logo, ele não exibe as informações para nós.

**Paulo:** Essa chave da API é para sabermos com quem estamos falando, não é?

> API Key: chave de acesso da API
> 

**Jacqueline:** Exato! Quem está nos pedindo essa informação e para quem estamos devolvendo? É como se fosse uma identificação.

**Paulo:** Funciona como se estivesse controlando, se não muitas pessoas poderiam tentar acessar e derrubar o site de tanto acesso. Existem APIs que são mais delicadas, como essa que estamos usando que provavelmente é uma API apenas de leitura, para consumirmos informações.

Existem também APIs de escrita. Assim é necessário saber quem está escrevendo e se comunicando com a API. Então há chaves ou outros mecanismos para conseguirmos identificar quem está chamando do outro lado da web. E estamos usando web pura, não é, Jaque?

**Jacqueline:** Isso.

**Paulo:** Esse é um site, e o site nos devolveu dados entre chaves. Tudo isso está acontecendo via protocolos mais básicos da web, como o HTTPS e com IP. É o protocolo da web, que está envolvido com serviços, como o web services e microservices.

**Jacqueline:** Exatamente, Paulo.

No site do OMDb API, clicamos em "API Key" no menu superior do lado direito e fazer o nosso cadastro. Temos as opções "*Patreon*" e "*FREE! (1,000 daily limit)*", a primeira é para ser um patrocinador ou fazer doações, e a segunda é para termos acesso gratuito com mil requisição por dia. Podemos usar essa última opção que é mais que o necessário para o nosso cenário.

> No formulário exibido, marque a opção FREE! (1,000 daily limit) no campo Account Type e preencha os campos Email e Name com o seu email e nome. No campo Use, coloque o seguinte texto: Personal application for test purpose e clique no botão "Submit"
> 

> Você receberá um email com a sua chave e também um link para fazer a ativação dela. Clique neste link para realizar a ativação e sua chave estará pronta para ser utilizada.
> 

Já tenho a minha chave, mas é necessário que você gere a sua. A minha chave, por exemplo, temos o título Top Gun e observe que no endereço após o `key =` temos o número `6585022c`, sendo onde está a chave. As nossas requisições a partir de agora serão feitas dessa maneira.

> Endereço indicado pela instrutora: https://www.omdbapi.com/?t=top+gun&apikey=6585022c
> 

**Paulo:** Sempre com a API Key, né?

**Jacqueline:** Isso mesmo.

**Paulo:** Chamamos essa parte da URL de ***query string***. Há diversas formas de enviarmos queries em sites, mas neste caso é dessa forma.

**Jacqueline:** Exato.

> https://www.omdbapi.com/?t=top+gun&apikey=6585022c
> 

Observe que em `top+gun` foi passado o nome do título que desejamos consultar e depois a api key. Em suma, é disso que precisamos.

Estamos desenvolvendo um aplicativo chamado de *ScreenMatch*, e desejamos, por exemplo, fazer uma parte do aplicativo onde seja possível a pessoa usuária informar o que deseja assistir no site. Assim, a pessoa usuária informa o filme que ela gostaria que tivesse na plataforma.

Imagine o tamanho do catálogo que não teríamos, se temos mecanismos para a pessoa usuária buscar, é o que vamos aplicar no nosso caso. Implementaremos essa busca. Pesquisamos no Java o filme que desejamos e ele virá na API realizar essa busca para nós.

**Paulo:** Então o nosso desafio será como acessamos, em Java, o [https://www.omdbapi.com/?t](https://www.omdbapi.com/?t). Até mesmo porque não aprendemos isso. Qual a biblioteca que pode se conectar no nosso endereço, como vamos capturar o conteúdo da página (JSON) e posteriormente provavelmente vamos precisar de uma biblioteca para fazer essa HTTP connection (conexão HTTP).

Após pegarmos esse conteúdo, como convertemos na nossa classe (que usamos ao longo dessa formação) para popularizar esse objeto a partir do JSON. Acredito que vamos ver duas bibliotecas para isso, se instalamos no IntelliJ ou se será somente importação e essas coisas vão começando a se encaixar.

Lembrando que vamos deixar o link para a API e para o GitHub, e todos os outros links que precisamos para trabalhar com essa API.

**Jacqueline:** Exatamente. Vamos lá?