package aplicaçãodepilha;


public class AplicaçãoDePilha {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Pilha p = new Pilha();

        
        try{

            /*p.Empilhar(-65);
            p.Empilhar(15);
            p.Empilhar(100);
            p.Empilhar(100);
            p.Empilhar(56);
            p.Empilhar(15);
            p.Empilhar(-453);
            p.Empilhar(-453);
            */
                
           
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        
        try{
           /* System.out.println("Menor Chamando METoDO STATIC: " + menorElemento(p));
            System.out.println("Menor Chamando METoDO da Pilha: " + p.menorElemento());
            
            */
//            System.err.println("Ordenada = " + ordenar(p));
            System.out.println("Ordenada = " + p.ordenar());
            
            
        }catch (Exception e ){
             System.out.println("Erro: " + e.getMessage());
        }
        
        System.out.println("\nPilha = " + p + "\n");
        
        
        // Encontrar o menor elemento da Pilha
        
        
        
    }
    // fora da pílha
    public static int menorElemento (Pilha p) throws Exception{
        if (p==null) throw new Exception("Parametro Inválido");
        if (p.PilhaVazia()) throw new Exception("Pilha Vazia, não existe menor elemnento");
        
        Pilha aux = p.clone();
        int Menor= aux.Desempilhar();

        int Elemento;
        while (!aux.PilhaVazia()){
            Elemento = aux.Desempilhar();
            if (Elemento<Menor)
                Menor = Elemento;
        }
        return Menor;
    }
    public static Pilha ordenar (Pilha P) throws Exception{
        if (P==null) throw new Exception("Parametro Inválido");
        
        Pilha Inicial = P.clone();
        Pilha Ordenada = new Pilha(P.capacidade());
        Pilha Aux = new Pilha(P.capacidade());
        
        int MaiorElementoDaVez;
        while (!Inicial.PilhaVazia()){
            // achar o maior elemento
            MaiorElementoDaVez = Inicial.ConsultaTopo();
            while (!Inicial.PilhaVazia()){
                if (MaiorElementoDaVez < Inicial.ConsultaTopo())
                     MaiorElementoDaVez = Inicial.ConsultaTopo();        
                Aux.Empilhar(Inicial.Desempilhar());
            }
            while (!Aux.PilhaVazia()){
                if (MaiorElementoDaVez == Aux.ConsultaTopo())
                    Ordenada.Empilhar(Aux.Desempilhar());
                else
                    Inicial.Empilhar(Aux.Desempilhar());
            }
        }
        
        return Ordenada;
    }

}
