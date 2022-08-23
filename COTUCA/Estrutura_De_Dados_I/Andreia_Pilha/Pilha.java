

public class Pilha{

    private int[] vetor;

    private int topo;

    public Pilha(){  // construtor
        vetor = new int[10];
        topo = -1;
    }
    public Pilha(int Q){  // construtor
        vetor = new int[Q];
        topo = -1;
    }

    public void empilhar(int e) throws Exception{
        if (cheia()) throw new Exception("Erro de Overflow");;

        topo++;
        vetor[topo] = e;
    }


    public int  desempilhar() throws Exception{
       if (vazia()) throw new Exception("Erro de Underflow");

       int retorno = vetor[topo];
       topo--;
       return retorno;
      
    }

    public int  consulta() throws Exception{
         if (vazia()) throw new Exception("Pilha Vazia");

         return vetor[topo];
    }

    public boolean cheia(){
       return (topo == (vetor.length -1));
    }

    public boolean vazia(){
       return (topo == -1);
    }


    //1) Desenvolver o método clonar() na classe Pilha
    public Pilha clone() {
        Pilha aux = new Pilha(this.vetor.length);

        if (!vazia()) {
            for (int i = 0; i <= this.topo; i++)
                aux.vetor[i] = this.vetor[i];

            aux.topo = this.topo;
        }
        return aux;
    }
    //2) Desenvolver o método inverter() na classe Pilha (inverte a própria pilha
            public void  inverter(){
                 int [] containerAux = new int[vetor.length];

                for(int i = 0; i < vetor.length; i++){
                    containerAux[i] = vetor [(vetor.length -i) -1];

                }

            }

    //3) Desenvolver o método inverter() FORA da classe Pilha (gerar uma nova pilha com os elementos da pilha do parâmetro, invertida)

    //Variações de inverter, caso queiram:
    //4) Desenvolver o método inverter() FORA da classe Pilha (inverter a pilha do parâmetro)

    //Avalidor de expressão válida em termos
    //   ==> true
    //() ==> true
    //)( ==> false
    // ) ==> false
    //( ==> false
      public String toString(){
       String ret="Topo --> [ ";

       for (int i=topo; i>-1 ; i--){
          ret = ret + vetor[i] + "  ";
       }
       
       return ret + "]";
    }
}