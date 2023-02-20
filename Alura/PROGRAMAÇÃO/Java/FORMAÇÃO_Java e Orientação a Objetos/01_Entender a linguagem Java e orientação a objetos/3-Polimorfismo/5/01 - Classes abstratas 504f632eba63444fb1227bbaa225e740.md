# 01 - Classes abstratas

> Começando deste ponto? Você pode fazer o DOWNLOAD completo do projeto anterior e continuar seus estudos a partir daqui.
> 

Anteriormente falamos sobre mais exemplos de herança, utilizando a `Conta`, `ContaCorrente` e `ContaPoupanca`.

Nesta aula, utilizaremos o exemplo da classe `Funcionario` novamente. Abriremos o projeto `bytebank-herdado`, que tem as classes que criamos anteriormente, como `Funcionario` e `Gerente`, seguindo a hierarquia que tínhamos, onde `Funcionario` é a super classe.

Os filhos desta classe são `Gerente`, `EditorVideo` e `Designer`.

Pensando em uma empresa real, é provável que tenhamos um ou mais gerentes, e ainda muitos outros perfis diferentes de funcionários. Não existe nenhuma pessoa na empresa que é apenas um funcionário, apesar de todos se encaixarem nesta categoria, de forma geral, cada um terá uma função específica, não sendo designado unicamente como "funcionário".

Sendo assim, poderíamos pensar em apagar a classe `Funcionario`, mas perderíamos todos os atributos e métodos definidos nela, perderíamos o tipo genérico e teríamos que criar métodos específicos nas classes filhas.

O conceito comum de `Funcionario` é importante para o nosso código, então não podemos apagá-lo.

Abriremos a classe `TesteReferencias`, e vemos que há a criação de um objeto do tipo `Funcionario()`:

```
public class TesteReferencias {

    public static void main(String[] args) {

//Código omitido

        Funcionario f = new Funcionario();
        f.setSalario(2000.0);

//Código omitidoCOPIAR CÓDIGO
```

Queremos evitar a existência de um funcionário desta forma, sem nenhum cargo específico. Para que isso aconteça, o `new Funcionario()` não deveria funcionar, pois estaríamos criando algo que só é um funcionário. No nosso exemplo, "funcionário" é um conceito, algo abstrato, o concreto seria o gerente, ou o editor de vídeos, por exemplo - note que são todos funcionários, mas não apenas isso.

Justamente, por ser um conceito abstrato, utilizaremos o `abstract` para indicar isso:

```
public abstract class Funcionario {

        private String nome;
        private String cpf;
        private double salario;

//Código omitidoCOPIAR CÓDIGO
```

A palavra `abstract` está **sempre** relacionada com herança.

Salvaremos, e podemos observar que, na classe `TesteReferencias`, o Eclipse aponta um erro de compilação no objeto do tipo `Funcionario()`, não é mais possível criar um funcionário. O `new` indica a criação de algo concreto, como a classe `Funcionario` agora é abstrata, o Eclipse indica um erro de compilação.

Se quisermos criar um objeto do tipo `Designer`, por exemplo, é possível, pois trata-se de uma classe concreta.

Assim, apagaremos estas linhas de código da classe `TesteReferencias`:

```
public class TesteReferencias {

        public static void main(String[] args) {

            Gerente g1 = new Gerente();
            g1.setNome("Marcos");
            g1.setSalario(5000.0);

            EditorVideo ev = new EditorVideo();
            ev.setSalario(2500.0);

            Designer d = new Designer();
            d.setSalario(2000.0);

            ControleBonificacao controle = new ControleBonificacao();
            controle.registra(g1);
            controle.registra(ev);
            controle.registra(d);

            System.out.println(controle.getSoma());

        }
}COPIAR CÓDIGO
```

Na classe `TesteFuncionario` temos:

```
public class TesteFuncionario {

        public static void main(String[] args) {

            Funcionario nico = new Funcionario();

//Código omitidoCOPIAR CÓDIGO
```

Não é possível mais termos `Funcionario nico = new Funcionario()`. No lado esquerdo não há problema, pois o conceito abstrato existe, mas no lado direito teremos que alterar, ele passará a ser do tipo `Gerente()`:

```
public class TesteFuncionario {

        public static void main(String[] args) {

            Funcionario nico = new Gerente();

//Código omitidoCOPIAR CÓDIGO
```

Ou seja, assim temos um filho concreto (`Gerente`), da classe `Funcionario`.

O mesmo conceito pode ser aplicado à estrutura de contas, temos uma conta poupança e outra corrente, mas não existe um tipo que seja simplesmente "conta".

Adiante, falaremos sobre métodos abstratos.