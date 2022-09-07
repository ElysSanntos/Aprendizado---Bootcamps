import java.util.*;

public class Expressoes {

    public static void main(String[] args) 
            throws Exception{

        Scanner teclado = new Scanner(System.in);
        Pilha minhaPilha = new Pilha();
 
        System.out.print("Digite a Expressao : ");
        String expressao = teclado.nextLine();
        System.out.println("Original : " + expressao);

        if (ResolveExp.estaBoa(expressao)){
            System.out.println(ResolveExp.geraPolonesa(expressao));
        } else
            System.out.println("Expressao Invalida!!");
    }

}