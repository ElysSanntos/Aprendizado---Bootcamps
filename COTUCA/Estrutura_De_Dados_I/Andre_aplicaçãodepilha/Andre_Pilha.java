class Pilha{

     private int[] Vetor;
     private int topo;

     public Pilha(){
       this(10);
     }
     public Pilha(int Qtos){
        Vetor = new int[Qtos];
        topo = -1;  // iniciado em uma posiçõo invalida
     }


     public void Empilhar (int Elemento){
        topo++;
        Vetor[topo] = Elemento;

        /*
                     ou 
        Vetor[++topo] = Elemento;
        */

     }
     public int Desempilhar (){
         return Vetor[topo--];

         /*
                ou
            int retorno = Vetor[topo];
            topo--;
            return retorno;
         */
     }
     public int ConsultaTopo(){
         return Vetor[topo];
     }

     public boolean PilhaVazia(){
          return (topo==-1);
     }

     public boolean PilhaCheia(){
         return (Vetor.length == (topo+1));
     }

     public String toString(){
        String retorno="";
  
        if (topo==-1) retur "[Pilha Vazia]";

        for (int i=0;i<=topo;i++)
           retorno += Vetor[];
        return retorno;
     }

}