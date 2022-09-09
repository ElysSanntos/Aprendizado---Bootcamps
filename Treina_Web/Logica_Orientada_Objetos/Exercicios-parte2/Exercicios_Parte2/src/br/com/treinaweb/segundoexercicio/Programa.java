package br.com.treinaweb.segundoexercicio;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Programa {

    public static void main(String[] args) {

        //Cria um novo computador
        Computador computador = new Computador();

        //Define os dados do computador
        computador.setNome("ASUS");
        computador.setPreco(2500.00);

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data = formato.parse("15/05/2016");

        computador.setDataFabricacao(data);

        //Chama algumas funções do computador
        computador.ligar();
        computador.acessarInternet();
        computador.desligar();


        //Define um computador Gamer
        ComputadorGamer computadorGamer = new ComputadorGamer();

        //Define os dados do computador Gamer
        computadorGamer.setNome("Alienware");
        computadorGamer.setPreco(7500.00);

        data = formato.parse("15/09/2017");

        computadorGamer.setDataFabricacao(data);
        computadorGamer.setMemoriaPlacaVideo(16);

        //Chama algumas funções do computador Gamer
        computadorGamer.ligar();
        computadorGamer.acessarInternet();
        computadorGamer.jogarNeedForSpeed();
        computadorGamer.desligar();


        //Define um computador Parrudo
        ComputadorParrudo computadorParrudo = new ComputadorParrudo();

        //Define os dados do computador Parrudo
        computadorParrudo.setNome("Dell");
        computadorParrudo.setPreco(6200.00);

        data = formato.parse("20/07/2017");

        computadorParrudo.setDataFabricacao(data);
        computadorParrudo.setCorGabinete("Neon");

        //Chama algumas funções do computador Parrudo
        computadorParrudo.ligar();
        computadorParrudo.acessarInternet();
        computadorParrudo.jogarCounterStrike();
        computadorParrudo.desligar();


        //Define um computador Simples
        ComputadorSimples computadorSimples = new ComputadorSimples();

        //Define os dados do computador Parrudo
        computadorSimples.setNome("HP");
        computadorSimples.setPreco(1500.00);

        data = formato.parse("20/02/2017");

        computadorSimples.setDataFabricacao(data);

        //Chama algumas funções do computador Parrudo
        computadorSimples.ligar();
        computadorSimples.jogarPaciencia();
        computadorSimples.desligar();
    }
}