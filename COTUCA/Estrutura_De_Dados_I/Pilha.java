

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
    public void inverter (){}
    public Pilha clonar(){
        return null;
    }
    public String toString(){
       String ret="Topo --> [ ";

       for (int i=topo; i>-1 ; i--){
          ret = ret + v[i] + "  ";
       }
       
       return ret + "]";
    }
}