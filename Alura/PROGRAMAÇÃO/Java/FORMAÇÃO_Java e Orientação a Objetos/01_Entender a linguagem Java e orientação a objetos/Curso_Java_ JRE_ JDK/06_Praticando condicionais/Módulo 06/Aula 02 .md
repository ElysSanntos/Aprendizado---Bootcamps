# Aula 02 - Trabalhando com if

João está criando uma aplicação para calcular o IR a partir do salário. Ele olhou na tabela de IRPF e implementou as regras para 15% e 22.5%:

```
public class TesteIR {

    public static void main(String[] args) {

        double salario = 3300.0;

        if(salario < 2600.0)
            System.out.println("A sua aliquota é de 15%");
            System.out.println("Você pode deduzir até R$ 350");

        if(salario < 3750.0)
            System.out.println("A sua aliquota é de 22,5%");
            System.out.println("Você pode deduzir até R$ 636");
    }
}COPIAR CÓDIGO
```

Porém o programa tem um comportamento estranho. Ao compilar e rodar, é impresso:

```
Você pode deduzir até R$ 350
A sua aliquota é de 22,5%
Você pode deduzir até R$ 636COPIAR CÓDIGO
```

Repare que o programa indica que podemos deduzir R$350 E R$636! Como corrigir o problema?

O problema é que faltam as chaves na condicional. Sem as chaves, o `if` apenas executará a primeira instrução depois dele.

Correto, devemos usar as chaves (sempre boa prática):

```
        if(salario < 2600.0) {
            System.out.println("A sua aliquota é de 15%");
            System.out.println("Você pode deduzir R$ 350");
        }

        if(salario < 3750.0) {
            System.out.println("A sua aliquota é de 22,5%");
            System.out.println("Você pode deduzir R$ 636");
        }
```