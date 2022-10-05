package Parte4_Exercicio5_TratamentoDeExcecoes_Pag213;

/*Implemente tratamento de exce��o na classe Ve�culo abaixo, lan�ando exce��es 
 * quando a velocidade estiver abaixo de zero ou acima do limite m�ximos. 
 * Escreva um programa para testar esta classe*/

public class Veiculo {
    private int velocidade = 0;
    private int velocidadeMax = 100;

    public int getVelocidade(){
       return this.velocidade;
    }

    public int getVelocidadeMax(){
       return this.velocidadeMax;
    }

    public void acelera(int incremento) throws VelocidadeAlta{
        if(velocidade + incremento > velocidadeMax){
            throw new VelocidadeAlta("Ta louco mano... pe de chumbo. " + (velocidade + incremento) + " km/h");
        }
        else
        {
           velocidade += incremento;
        }
    }

    public void desacelara(int decremento) throws VelocidadeNegativa{
        if(velocidade - decremento < 0){
            throw new VelocidadeNegativa("Fala Einstein... quebrou as leis da fisica... " + (velocidade - decremento) + " km/h");
        }
        else
        {
           velocidade -= decremento;
        }
    }
}
