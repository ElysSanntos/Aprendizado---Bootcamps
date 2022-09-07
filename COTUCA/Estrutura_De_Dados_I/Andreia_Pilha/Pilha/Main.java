import java.util.Random;

public class Main {

    public static void main(String[] args) 
            throws Exception{
        Pilha minhaPilha = new Pilha();
        Pilha outraPilha = null;
        
        Random rnd = new Random();

        // gerando números aleatórios para encher a pilha
        while(!minhaPilha.cheia()){
            minhaPilha.empilhar(rnd.nextInt(100));
        }
        minhaPilha.desempilhar();

        Pilha nova = minhaPilha.clonar();


        System.out.println("Original : " + minhaPilha);
        System.out.println("Clonada  : " + nova);


        System.out.println("Original  : " + minhaPilha);
        
        outraPilha =  inverter(minhaPilha);
        System.out.println("Invertida : " + outraPilha);
        
    }

    public static void somentePares(Pilha P) throws Exception{
        Pilha dePares = new Pilha();
        int elemento=0;

        Pilha aux = new Pilha();
        while(!P.vazia()){
            elemento=P.desempilhar();
            aux.empilhar(elemento);
        }
        
        // Repetir até a pilha esvaziar
        while(!aux.vazia()){
            elemento = aux.desempilhar();

            if ((elemento%2)==0)
                dePares.empilhar(elemento);

            P.empilhar(elemento);
        }

        System.out.println("So pares : " + dePares);
    }

    public static boolean ehValida(String exp){

       // if (exp.charAt(i)=='(')

        return false;
    }

    public static Pilha inverter(Pilha P)throws Exception{
        Pilha aux = new Pilha();
        Pilha invertida = new Pilha();

        while (!P.vazia()){
            invertida.empilhar(P.consulta());
            aux.empilhar(P.desempilhar());
        }
        while (!aux.vazia()){
            P.empilhar(aux.desempilhar());
        }
        return invertida;
    }
}