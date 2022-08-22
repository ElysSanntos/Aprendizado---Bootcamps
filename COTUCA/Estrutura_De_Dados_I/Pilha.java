

public class Pilha{

    private int[]   v;
    private int     topo;

    public Pilha(){  // construtor
       v = new int[10];    
       topo = -1;
    }

    public void empilhar(int e) throws Exception{
        if (cheia()) throw new Exception("Erro de Overflow");;

        topo++;
        v[topo] = e;
    }


    public int  desempilhar() throws Exception{
       if (vazia()) throw new Exception("Erro de Underflow");

       int retorno = v[topo];
       topo--;
       return retorno;
      
    }

    public int  consulta() throws Exception{
         if (vazia()) throw new Exception("Pilha Vazia");

         return v[topo];
    }

    public boolean cheia(){
       return (topo == (v.length -1));
    }

    public boolean vazia(){
       return (topo == -1);
    }


    //1) Desenvolver o método clonar() na classe Pilha
    public Pilha clone() {
        Pilha aux = new Pilha( this.Vetor.length );

        if (!PilhaVazia()){
            for (int i = 0; i<= this.topo;i++)
                aux.Vetor[i] = this.Vetor[i];

            aux.topo = this.topo;

    //2) Desenvolver o método inverter() na classe Pilha (inverte a própria pilha
      public void inverter (){}

    //3) Desenvolver o método inverter() FORA da classe Pilha (gerar uma nova pilha com os elementos da pilha do parâmetro, invertida)

    //Variações de inverter, caso queiram:
    //4) Desenvolver o método inverter() FORA da classe Pilha (inverter a pilha do parâmetro)

            public String toString(){
       String ret="Topo --> [ ";

       for (int i=topo; i>-1 ; i--){
          ret = ret + v[i] + "  ";
       }
       
       return ret + "]";
    }
}