package br.com.alura.screenmatch.principal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;


public class PrincipalComBuscas  {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in);
        System.out.println("Nome do filme para busca: ");
        String busca = leitura.nextLine();

        String endereço = "https://www.omdbapi.com/?t=" + busca + "&apikey=1f5079e0";
        HttpClient client = HttpClient.newHttpClient(); //Atalho para imports: Alt + Enter

    /*
    newBuilder() ==> seria como se eu estivesse instanciando - contudo, a documentação
    diz que essa classe é abstrata, ou seja, não posso instanciar. Assim foi criado um
    padrão de projeto
    "Builder", para criar objetos complexos, passando para o objeto a referência do que
    será construido.
    * HttpRequest req = new HttpRequest();
    */
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereço))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());


        System.out.println(response.body());
    }
    }



