import  java.util.Random;

public class Main {

    public static void main(String[] args) 
            throws Exception {
        Pilha minhaPilha = new Pilha();
        Random rnd = new Random(100);


        //Gerando números aleatórios para encher a pilha
        while (!minhaPilha.cheia()) {
            minhaPilha.empilhar(rnd.nextInt(100));

        }

        Pilha clone = minhaPilha.clone();
        System.out.println("Original: " + minhaPilha);
        System.out.println("Clone     " + clone);

        somentePares(minhaPilha);

        System.out.println(minhaPilha);
        minhaPilha.inverter();
        System.out.println(minhaPilha);
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
        System.out.println(dePares);

    }




}