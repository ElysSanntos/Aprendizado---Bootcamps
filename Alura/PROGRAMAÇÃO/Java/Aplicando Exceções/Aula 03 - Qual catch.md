# Aula 03 - Qual catch?

Já vimos nesse curso duas formas de capturar várias exceções através do bloco `catch`. (1) A forma tradicional, que funciona desde inicio do Java, simplesmente repete o bloco `catch` para cada exceção:

```
try {
 metodoPerigosoQuePodeLancarVariasExcecoes();
} catch(MinhaExcecao ex) {
 ex.printStackTrace();
} catch(OutraExcecao ex) {
 ex.printStackTrace();
}COPIAR CÓDIGO
```

E (2) a forma mais atual, que foi introduzido no Java 7, permite definir as várias exceções no mesmo bloco (*multi catch*):

```
try {
 metodoPerigosoQuePodeLancarVariasExcecoes();
} catch(MinhaExcecao | OutraExcecao ex) { //multi-catch
 ex.printStackTrace();
}COPIAR CÓDIGO
```

Você vai encontrar ambas as formas no seu dia a dia de desenvolvedor Java. Agora, veja **assinatura** do "método perigoso" em questão:

```
//funciona, podemos colocar duas exceções na assinatura
public void metodoPerigosoQuePodeLancarVariasExcecoes() throws MinhaExcecao, OutraExcecao{
    //código omitido
}COPIAR CÓDIGO
```

Vimos mais uma variação do *catch*, não sintática, mas conceitual. Qual afirmação abaixo pode ser usada para capturar todas exceções desse "método perigoso"?

**Importante**: Assumindo que ambas as exceções são do tipo *checked!*

*Selecione uma alternativa*

`try {
    metodoPerigosoQuePodeLancarVariasExcecoes();
} catch(Exception ex) {
    ex.printStackTrace();
}`

Correto. Criamos um `catch` genérico que captura qualquer exceção, incluindo exceções *checked*.

Isso pode parecer uma boa prática, mas normalmente não é. Como regra geral, sempre tente ser mais especifico possível no bloco `catch` favorecendo vários blocos *catch* ou usando *multi-catch*.