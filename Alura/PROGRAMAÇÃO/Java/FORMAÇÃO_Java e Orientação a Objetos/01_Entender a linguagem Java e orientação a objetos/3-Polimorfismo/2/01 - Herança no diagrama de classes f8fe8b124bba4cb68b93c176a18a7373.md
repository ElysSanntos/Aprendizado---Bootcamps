# 01 - Herança no diagrama de classes

Começando deste ponto? Você pode fazer o [DOWNLOAD](https://caelum-online-public.s3.amazonaws.com/788-java-heranca-interfaces-polimorfismo/02/java3-aula2.zip) completo do projeto anterior e continuar seus estudos a partir daqui.

---

Olá!

Nesta aula, continuaremos a falar sobre herança, iniciando pelo método `getBonificacao()` que, como havíamos comentado anteriormente, apresentava erro quando inserido na classe `Gerente`.

Antes de partimos para este próximo passo, faremos uma breve revisão.

Primeiro, criamos uma classe extra, para representar o gerente. Nela, temos todo o código específico para representá-lo, ou seja, uma `senha`, que é um atributo a mais em relação ao `Funcionario`, e dois métodos, sem contar com o `Bonificacao`, que ganhará especificação, em relação ao que já existe para o `Funcionario`.

Para não repetirmos código, utilizamos o conceito de **herança**, representado pela palavra `extends`:

```
// Gerente é um Funcionário, Gerente herda da classe Funcionário

public class Gerente extends Funcionario {

// Código omitido

}COPIAR CÓDIGO
```

Com isso, queremos dizer que o `Gerente` possui os mesmos atributos e métodos que o `Funcionario`.

Para esclarecermos este conceito, podemos utilizar alguns diagramas para nos ajudar a visualizar as classes.

Primeiro, temos a classe `Funcionario`:

Funcionario

---

+ nome: String

---

+ cpf: String

---

+ salario: double

---

- -------------------------------------------------

---

+ getBonificacao(): double + getters e setters

---

Vemos o nome da classe, em seguida os atributos, `nome`, `cpf` e `salario`, e por último temos os métodos, `getBonificacao()` e os *getters* e *setters*.

Em seguida, temos a classe `Gerente`:

Gerente

---

+ senha: int

---

- ---------------------

---

+ autentica(): boolean

---

Criamos um relacionamento entre estas duas classes, utilizando a herança. Como podemos representar isso neste diagrama? É simples, podemos utilizar uma seta:

![https://s3.amazonaws.com/caelum-online-public/788-java-heranca-interfaces-polimorfismo/02/02.01_001_diagrama-de-classes.png](https://s3.amazonaws.com/caelum-online-public/788-java-heranca-interfaces-polimorfismo/02/02.01_001_diagrama-de-classes.png)

Isto indica que o `Gerente` **herda de** `Funcionario`.

Além disso, é costume chamarmos esta classe `Funcionario` de **classe mãe** ou **classe pai**. Podemos chamar também de ***base class***, ou ***super class***; este último é o nome com o qual deveremos nos acostumar.

Ao chamarmos a classe desta forma, indicamos que ela é a primeira na hierarquia. Ou, simplesmente, que ela está acima de outra com a qual estivermos trabalhando.

No caso, a classe `Gerente` pode ser chamada de **classe filha**.

Um sinônimo para a palavra `extends` é usar o "herda", ou ainda "é um", por exemplo, todas as frases abaixo são equivalentes:

- `Gerente extends Funcionario`
- `Gerente` herda de `Funcionario`
- `Gerente` é um `Funcionario`

Temos que nos acostumar com estas nomenclaturas pois é comum elas aparecerem na literatura.

Após fazermos esta associação, fizemos um primeiro teste e criamos o primeiro gerente `g1`, da seguinte forma (aqui apresentada fora do contexto do código):

```
Gerente g1 = new Gerente();COPIAR CÓDIGO
```

O que acontece, interiormente, é a criação de um objeto, com atributos baseados na hierarquia estabelecida. Abaixo, temos uma representação do que ele contém inicialmente:

Object:Gerente

---

nome = null

---

cpf = null

---

salario = 0.0

---

senha = 0

---

Ou seja, todos os atributos de `Funcionario`, mais o seu específico, que é a `senha`. É esta a ideia da herança.

Vimos também que, utilizando a referência `g1`, é possível chamarmos todos os métodos da hierarquia, ou seja, não só aqueles definidos na própria classe `Gerente`, como também aqueles presentes na classe `Funcionario`. Por exemplo:

```
//Código omitido

g1.setNome("Marco");

//Código omitidoCOPIAR CÓDIGO
```

Aqui, o método `setNome()` funciona somente porque existe o atributo `nome` na classe `Funcionario`. O que aconteça, internamente, é que este dado é preenchido, como podemos observar visualizando o diagrama novamente:

Object:Gerente

---

nome = Marco

---

cpf = null

---

salario = 0.0

---

senha = 0

---

Ou seja, o nome pertence ao `Gerente`, mas tanto o método, quanto o atributo, foram definidos na classe mãe.

Com todos estes conceitos revisados, daremos continuidade nas próximas aulas, nas quais resolveremos o problema da bonificação específica.