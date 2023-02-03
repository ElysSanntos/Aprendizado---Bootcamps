# Aula 11 - Opcional: Alíquota com ifs

O João gostaria de criar um programa sobre Imposto de Renda (IR) e verificou as regras de alíquota. Ele descobriu no site da receita:

- De 1900.0 até 2800.0, o IR é de 7.5% e pode deduzir na declaração o valor de R$ 142
- De 2800.01 até 3751.0, o IR é de 15% e pode deduzir R$ 350
- De 3751.01 até 4664.00, o IR é de 22.5% e pode deduzir R$ 636

Para começar, o João escreveu o seguinte esboço de classe:

```
public class TesteIR {

    public static void main(String[] args) {

        double salario = 3300.0;

        //ifs aqui
    }
}COPIAR CÓDIGO
```

Agora ajude o João na implementação todas as regras usando condicionais!

*Obs: Os valores de alíquota exatos foram simplificados. Os valores exatos se encontram [neste link](http://idg.receita.fazenda.gov.br/acesso-rapido/tributos/irpf-imposto-de-renda-pessoa-fisica).*

****Opinião do instrutor****

Segue uma possível implementação:

```
public class TesteIR2 {

    public static void main(String[] args) {

        // De 1900.0 até 2800.0 o IR é de 7.5% e pode deduzir R$ 142
        // De 2800.01 até 3751.0 o IR é de 15% e pode deduzir R$ 350
        // De 3751.01 até 4664.00 o IR é de 22.5% e pode deduzir R$ 636

        double salario = 3300.0;

        if(salario >= 1900.0 && salario <= 2800.0) {
            System.out.println("A sua aliquota é de 7,5%");
            System.out.println("Você pode deduzir até R$ 142");
        } else if(salario >= 2800.01 && salario <= 3751.0) {
            System.out.println("A sua aliquota é de 15%");
            System.out.println("Você pode deduzir até R$ 350");
        } else if(salario >= 3751.01 && salario <= 4664.0) {
            System.out.println("A sua aliquota é de 22.5%");
            System.out.println("Você pode deduzir até R$ 636");
        }
    }
}
```