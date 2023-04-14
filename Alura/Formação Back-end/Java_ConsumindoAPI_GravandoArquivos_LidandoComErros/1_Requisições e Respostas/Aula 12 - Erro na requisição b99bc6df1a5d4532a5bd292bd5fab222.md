# Aula 12 - Erro na requisição

Sua amiga Alice, estudante de Java, está tentando escrever um código que se conecta com uma API de um dicionário. Ela escreveu o seguinte código:

```
Scanner leitura = new Scanner(System.IN);
System.out.println("Digite a palavra para buscar no dicionário: ");
String busca = leitura.nextLine();

String endereco = "https://www.apidicionario.com.br?palavra= +busca";

HttpClient client = HttpClient.newHttpClient();
HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
HttpResponse<String> response = request.send(request, HttpResponse.BodyHandlers.ofString());

System.out.println(response.body());COPIAR CÓDIGO
```

Entretanto, ela afirma que o código não está funcionando corretamente. Escolha TODAS as alternativas que indicam os problemas no código dela:

*Selecione 2 alternativas*

- O método `send`, utilizado para disparar a requisição, foi chamado no objeto errado.
    
    O método `send` deve ser chamado do objeto `client` e não do objeto `request`.
    
- Alternativa correta
    
    O endereço da API não está sendo criado corretamente.
    
    A concatenação do endereço da API com o parâmetro `busca` não foi feita corretamente.
    
    - O código contém um erro na concatenação do parâmetro de busca com o endereço da API, e também na chamada ao método `send()`
    - O `HttpClient` foi criado corretamente, por meio do método estático `HttpClient.newHttpClient()`
    .
    .