import java.util.*;

public class Parenteses {

    public static void main(String[] args) 
            throws Exception{

        Scanner teclado = new Scanner(System.in);
        Pilha minhaPilha = new Pilha();
 
        System.out.print("Digite a Expressao : ");
        String expressao = teclado.nextLine();
        System.out.println("Original : " + expressao);

        for (int i=0; i<expressao.length(); i++){
            if (expressao.charAt(i)=='(')
                minhaPilha.empilhar('(');
            else
                if (expressao.charAt(i)==')'){
                    if (minhaPilha.vazia()){
                        System.out.println("Expressao invalida");
                        break;
                    }
                        
                    minhaPilha.desempilhar();
                }
               
        }
        if (!minhaPilha.vazia())
            System.out.println("Expressao invalida");
        else
            System.out.println("Expressao valida");

    }

}