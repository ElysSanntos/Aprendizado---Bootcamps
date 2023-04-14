# Aula 13 - Faça como eu fiz: consumindo a API do OMDb

Agora é com você! Faça o mesmo procedimento que eu fiz na aula, criando a classe `PrincipalComBusca`, contendo o código que se integra com a API do OMDb.

A classe deverá ser criada com o seguinte código:

```
public class PrincipalcomBusca {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.IN);
        System.out.println(“Digite o nome do filme para busca: “);
        var busca = leitura.nextLine();

        String chave = “COLOQUE AQUI A SUA CHAVE DO OMDb”;
        String endereco = “https://www.omdbapi.com/?t=” +busca + “&apikey=” +chave;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}
```