# 04 - Tipos de funcionários

Olá! Nesta aula, continuaremos a trabalhar com a classe `Funcionario`, seguindo as aulas anteriores. Os mesmos princípios utilizados na classe `Conta` foram aplicados em `Funcionario` por meio do teste realizado.

Nosso chefe nos apresentou um novo requisito. Além de funcionários, teremos que representar, também, os gerentes.

Por princípio, um funcionário não é fundamentalmente diferente de um gerente, já que ambos têm características em comum, como nome, CPF e salário. A ideia é aproveitarmos a classe `Funcionario`, tendo em mente estas semelhanças.

Entretanto, temos um problema: a bonificação não será a mesma! O gerente certamente ganhará mais que 10% de bônus, que é quanto o funcionário comum ganha. Neste caso, a sua bonificação será de um salário inteiro a mais.

Faremos uma cópia da classe `Funcionario`, que chamaremos de `FuncionarioTeste`, apenas para podermos alterá-la livremente, sem perder suas características originais. Podemos fazer isto utilizando o atalho "Ctrl + C" e "Ctrl + V".

A partir de agora, trabalharemos com a classe `FuncionarioTeste`.

Para determinarmos se estamos lidando com um funcionário comum, ou um gerente, adicionaremos um atributo a mais, que chamaremos de `tipo`, e será inicializado em `0`, que significa funcionário comum, como podemos ver no comentário, e assim por diante, onde cada número representa uma função diferente:

```
public class FuncionarioTeste {

        private String nome;
        private String cpf;
        private double salario;
        private int tipo = 0; //0 = Funcionário comum; 1 = Gerente; 2 = Diretor

        public double getBonificacao() {
            return this.salario * 0.1;
        }

//Código continua abaixo...COPIAR CÓDIGO
```

Ao criarmos um funcionário, ele sempre terá o valor `0` atribuído.

Abaixo, criaremos um método `setTipo`:

```
public class FuncionarioTeste {

        private String nome;
        private String cpf;
        private double salario;
        private int tipo = 0; //0 = Funcionário comum; 1 = Gerente; 2 = Diretor

        public double getBonificacao() {
            return this.salario * 0.1;
        }

        public void setTipo(int tipo) {
            this.tipo = tipo;
        }

//Código continua abaixo...COPIAR CÓDIGO
```

Criaremos também um `getTipo`:

```
public class FuncionarioTeste {

        private String nome;
        private String cpf;
        private double salario;
        private int tipo = 0; //0 = Funcionário comum; 1 = Gerente; 2 = Diretor

        public double getBonificacao() {
            return this.salario * 0.1;
        }

        public void setTipo(int tipo) {
            this.tipo = tipo;
        }

        public int getTipo() {
            return tipo;
        }

//Código continua abaixo...COPIAR CÓDIGO
```

Alternativamente, poderíamos ter utilizado o menu superior, em "Source > Generate Getters and Setters...".

Com isso, já é possível determinarmos e sabermos o tipo do funcionário. Em seguida, daremos mais especificidade à bonificação. Para isso, utilizaremos um `if`, com condições para cada uma das funções, que são representadas por um número cada. Começando pelo funcionário comum:

```
public class FuncionarioTeste {

        private String nome;
        private String cpf;
        private double salario;
        private int tipo = 0; //0 = Funcionário comum; 1 = Gerente; 2 = Diretor

        public double getBonificacao() {

            if(this.tipo == 0) { // Funcionário comum
                return this.salario * 0.1;
            }
            return this.salario * 0.1;
        }

        public void setTipo(int tipo) {
            this.tipo = tipo;
        }

        public int getTipo() {
            return tipo;
        }

//Código continua abaixo...COPIAR CÓDIGO
```

Em seguida, para lidarmos com **outro** tipo, utilizaremos o `else`:

```
public class FuncionarioTeste {

        private String nome;
        private String cpf;
        private double salario;
        private int tipo = 0; //0 = Funcionário comum; 1 = Gerente; 2 = Diretor

        public double getBonificacao() {

        if(this.tipo == 0) { // Funcionário comum;
            return this.salario * 0.1;
        } else if(this.tipo == 1) { // Gerente;
            return this.salario;
        }

        public void setTipo(int tipo) {
            this.tipo = tipo;
        }

        public int getTipo() {
            return tipo;
        }

//Código continua abaixo...COPIAR CÓDIGO
```

Por fim, se não for funcionário, nem gerente, ele será um diretor, e terá uma terceira forma de bonificação:

```
public class FuncionarioTeste {

        private String nome;
        private String cpf;
        private double salario;
        private int tipo = 0; //0 = Funcionário comum; 1 = Gerente; 2 = Diretor

        public double getBonificacao() {

            if(this.tipo == 0) { // Funcionário comum;
                return this.salario * 0.1;
            } else if(this.tipo == 1) { // Gerente;
                return this.salario;
            } else {
                return this.salario + 1000.0;
            }

        }

        public void setTipo(int tipo) {
            this.tipo = tipo;
        }

        public int getTipo() {
            return tipo;
        }

//Código continua abaixo...COPIAR CÓDIGO
```

O que fizemos foi criar, para cada tipo de funcionário, uma regra de bonificação diferente.

Para testarmos, criaremos uma nova classe de teste. Clicando com o botão direito do mouse sobre nosso pacote, e selecionando "New > Class", a nomearemos `Teste` e já lhe atribuiremos um método `main`:

```
public class Teste {

    public static void main(String[] args) {

    }

}COPIAR CÓDIGO
```

Em seguida, criaremos um funcionário hipotético, `f1`:

```
public class Teste {

    public static void main(String[] args) {
        FuncionarioTeste f1 = new FuncionarioTeste();

    }

}COPIAR CÓDIGO
```

Ao criarmos ele, temos que ter em mente que ele nascerá, por padrão, como um funcionário comum, já que nos atributos lhe foi atribuído um valor inicial de `0`, que corresponde ao funcionário comum.

Isso significa que, se fizermos um `System.out.println` para `getTipo`, deveríamos receber um retorno `0`.

Definiremos um salário, `f1.setSalario` no valor de R$3.000,00, além de calcularmos a bonificação, com o `getBonificacao`:

```
public class Teste {

    public static void main(String[] args) {
        FuncionarioTeste f1 = new FuncionarioTeste();
        f1.setSalario(3000.0);
        System.out.println(f1.getTipo());
        System.out.println(f1.getBonificacao());
    }
}COPIAR CÓDIGO
```

Salvaremos e executaremos. Clicaremos com o botão direito do mouse sobre a tela, e selecionaremos "Run As > Java Application". No console, veremos:

```
0
300.0COPIAR CÓDIGO
```

O `0` significa que estamos lidando com o funcionário comum, e que a sua bonificação é de R$300,00.

Testaremos com um novo funcionário, que chamaremos de `f2`, e que será um gerente, ou seja, será do tipo `1`, seu salário será de R$5.000,00, e imprimiremos as informações, assim como fizemos para o funcionário `f1`:

```
public class Teste {

    public static void main(String[] args) {
        FuncionarioTeste f1 = new FuncionarioTeste();
        f1.setSalario(3000.0);
        System.out.println(f1.getTipo());
        System.out.println(f1.getBonificacao());

        FuncionarioTeste f2 = new FuncionarioTeste();
        f2.setTipo(1);
        f2.setSalario(5000.0);
        System.out.println(f2.getTipo());
        System.out.println(f2.getBonificacao());
    }
}COPIAR CÓDIGO
```

Vamos executar, e veremos que, no console, foi impresso o seguinte:

```
0
300.0
1
5000.0COPIAR CÓDIGO
```

Ou seja, funcionou, temos as respectivas classificações, no caso, `0` e `1`, e as respectivas bonificações.

### **Mas quais problemas este sistema poderia nos acarretar?**

Primeiro, temos três tipos de cargos definidos: o funcionário, gerente, e o diretor. Vamos imaginar que tivéssemos mais vinte outros tipos, por exemplo, ou quantos mais fossem, teríamos sempre que ter o controle da referência de cada cargo, ou seja, seria necessário sabermos qual número corresponde exatamente a qual função, sendo que é possível ter inúmeras funções.

Como isso não é explícito em nosso código, é exigido que façamos este processo mentalmente, e isto não é uma boa prática de programação.

Idealmente, se estamos falando de uma **espécie** "gerente", deve existir uma **classe** `Gerente`.

Em segundo lugar, se retornarmos à classe `Funcionario`, percebemos que, para controlar o tipo de função temos muitos `if`s, e isto também não é uma boa prática de programação.

Eles são um recurso útil, e em certos momentos, necessários, mas neste caso eles tendem a nunca parar de crescer. Isso porque, sempre que tivermos um novo `tipo`, ou seja, uma nova função, ou cargo, teremos que criar um novo `if`.

Conforme nosso quadro de funcionários cresça, é provável que outros métodos precisem de `if`s.

Por exemplo, e se quisermos criar um `getTipo` que nos retorne um `String`?

```
//Código de cima omitido

public String getTipo() {
    return tipo;
}

//Código abaixo omitidoCOPIAR CÓDIGO
```

Como implementaríamos este método?

Teríamos que repetir todos os `if`s criados em `getBonificacao` no corpo do `getTipo`, para podermos devolver o `String` adequado para cada tipo.

Como isto não seria prático, retornaremos o código ao modo como estava:

```
//Código de cima omitido

public int getTipo() {
    return tipo;
}

//Código abaixo omitidoCOPIAR CÓDIGO
```

Com isso, conseguimos observar que, cada método que seja mais específico, ou mais sofisticado, e que envolva o `tipo` de `Funcionario`, demandará mais `if`s, que não têm limites. Isto não é bom para nosso programa.

Nosso objetivo é ter um código estável, ou seja, que uma vez escrito, não precise ser reescrito. Cada mudança no código é sempre um perigo, temos que buscar evitar ao máximo quaisquer alterações futuras, especialmente aquelas que envolvam pedaços maiores do código.

O exemplo do `if` foi citado, mas não é o único. Imaginemos, por exemplo, que o gerente possui uma senha que um funcionário não tem acesso - como isso pode ser apresentado?

Para isso, teríamos de criar um novo atributo:

```
public class FuncionarioTeste {

        private String nome;
        private String cpf;
        private double salario;
        private int tipo = 0; // 0 = Funcionário comum; 1 = Gerente; 2 = Diretor
        private int senha;COPIAR CÓDIGO
```

Que temos que inicializar, por meio de um método. Entretanto, este atributo é específico para o gerente e para o diretor, e não deve atingir o funcionário comum - como podemos limitar isso se estamos generalizando em uma única classe?

O mesmo pode acontecer com os métodos. Por exemplo, digamos que há um método do tipo `boolean` que serve para autenticação:

```
//Código de cima omitido

public boolean autentica(int senha) {
    if(this.senha == senha) {
        return true;
    } else {
            return false;
    }
}
//Código abaixo omitidoCOPIAR CÓDIGO
```

Este método deve atingir somente o gerente, jamais o funcionário comum - já que este nem senha possui. Como podemos então esconder o método, se ele foi inserido na mesma classe? Não é possível.

Há características e funcionalidades que são específicas a um determinado `tipo`, e não são iguais para todos os `Funcionarios`. Esta abordagem, de termos todas as informações concentradas em uma única classe, não consegue ser sustentada por muito tempo - a partir do momento que nosso sistema ganha complexidade, ela para de funcionar.

Nas próximas aulas, criaremos classes específicas.

Nesta aula, foi apresentado o problema que surge e nos motiva a utilizar a herança, é ela quem nos ajudará a separar as funcionalidades.