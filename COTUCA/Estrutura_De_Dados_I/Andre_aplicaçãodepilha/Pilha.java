
package aplicaçãodepilha;


public class Pilha {
    
     private int[] Vetor;
     private int topo;

     public Pilha(){
       this(10);
     }
     
     public Pilha(int Qtos){
        if (Qtos<10) Qtos=10;
        
        Vetor = new int[Qtos];
        topo = -1;  // iniciado em uma posição invalida
     }


     public void Empilhar (int Elemento) throws Exception{
        if (PilhaCheia()) throw new Exception ("[Overflow] Pilha Cheia, impossivel Empilhar");         

        topo++;
        Vetor[topo] = Elemento;

        /*
                     ou 
        Vetor[++topo] = Elemento;
        */

     }
     public int Desempilhar () throws Exception{
         if (PilhaVazia()) 
              throw new Exception("[Underflow] Pilha Vazia, impossivel Desempilhar");
         
         return Vetor[topo--];

         /*
                ou
            int retorno = Vetor[topo];
            topo--;
            return retorno;
         */
     }
     public int ConsultaTopo() throws Exception{
         if (PilhaVazia()) 
              throw new Exception("[Underflow] Pilha Vazia, impossivel Consultar");

         return Vetor[topo];
     }

     public boolean PilhaVazia(){
          return (topo==-1);
     }

     public boolean PilhaCheia(){
         return (Vetor.length == (topo+1));
     }

     public Pilha clone() {
         Pilha aux = new Pilha( this.Vetor.length );
         
         if (!PilhaVazia()){
              for (int i = 0; i<= this.topo;i++)
                 aux.Vetor[i] = this.Vetor[i];
              
              aux.topo = this.topo;
              
              /*  // ou
                  try{
                      aux.Empilhar(Vetor[i]);
                  }catch (Exception e){}
              */
         }
         return aux;
     }
     
     public int capacidade (){
         return Vetor.length;
     }
     
     @Override
     public String toString(){

         if (topo==-1) return "[ Pilha Vazia ]";

        String retorno="Topo --> [ ";
  

        for (int i=topo;i>-1;i--)
           retorno += Vetor[i] + " ";
        
        return retorno+"]";
     }
     
     
     /** 
      * Métodos que FURAM O CONCEITO
      */
     public int menorElemento() throws Exception{
         if (PilhaVazia()) 
              throw new Exception("Pilha Vazia, não existe menor elemnento");
         
         int Menor=0;
         for (int i=1; i<=this.topo; i++){
             if (Vetor[i] < Vetor[Menor])
                 Menor = i;                 
         }
         return Vetor[Menor];
         
     }

     public Pilha ordenar() throws Exception{
         if (PilhaVazia()) throw 
                 new Exception ("Pinha Vazia");
         
         Pilha ordenada = new Pilha(this.Vetor.length);
         
         int i=0;
         int[] MaiorDaVez=maior(0, true);
         
            for (int qtos=0; qtos<MaiorDaVez[1]; qtos++){
              ordenada.Empilhar(MaiorDaVez[0]);
              i++;
            }
         
         while (i<topo+1){
            MaiorDaVez = maior(MaiorDaVez[0], false);
            for (int qtos=0; qtos<MaiorDaVez[1]; qtos++)            
            {
               ordenada.Empilhar(MaiorDaVez[0]);
               i++;
            }
            
         }
         
         return ordenada;
     }
     
     private int[] maior(int valorMaximo, boolean Primeiro) throws Exception{
         
         int retorno[] = new int[2];  
         
         /* Encontrar o primeiro valor valido para esta chamada
            respeitando o valorMaximo
         */
         int MaiorDaVez = Vetor[0];
         int i=0;
         while ((i<topo+1) && (Vetor[i]>=valorMaximo)){
             i++;
             MaiorDaVez = Vetor[i];
         }

         int Qtos =0;
         for (i=0; i<topo+1; i++){
             if ( (Primeiro||(Vetor[i] < valorMaximo)))  // corte do MAIOR
                if (MaiorDaVez < Vetor[i])
                {
                    MaiorDaVez = Vetor[i];
                    Qtos = 1;
                }
                else
                   if (MaiorDaVez == Vetor[i])
                       Qtos++;
         }
                 
         retorno[0] = MaiorDaVez;
         retorno[1] = Qtos;
                 
         return retorno;
     }
}
