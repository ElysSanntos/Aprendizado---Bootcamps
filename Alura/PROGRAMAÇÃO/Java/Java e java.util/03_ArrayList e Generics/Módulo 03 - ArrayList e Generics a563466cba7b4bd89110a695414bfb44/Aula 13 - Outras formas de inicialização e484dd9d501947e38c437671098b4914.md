# Aula 13 - Outras formas de inicialização

## **Lista com capacidade predefinida**

Falamos que o `ArrayList` é um array dinâmico, ou seja, por baixo dos panos é usado um array, mas sem se preocupar com os detalhes e limitações.

Agora pense que você precisa criar uma lista representando todos os 26 estados do Brasil. Você gostaria de usar um `ArrayList` para "fugir" do array, mas sabe que o `ArrayList` cria um array automaticamente, do tamanho que a classe acha conveniente.

Será que não há uma forma de criar essa lista já definindo o tamanho do array? Claro que tem e é muito simples. O construtor da classe `ArrayList` é sobrecarregado e possui um parâmetro que recebe a *capacidade*:

```
ArrayList lista = new ArrayList(26); //capacidade inicial
```

A lista continua dinâmica, mas o tamanho do array inicial é de 26!

## **Lista a partir de outra**

Outra forma de inicializar uma lista é baseado na outra que é muito comum no dia a dia. Para tal a `ArrayList` possui mais um construtor que recebe a lista base:

```
ArrayList lista = new ArrayList(26); //capacidade inicial
lista.add("RJ");
lista.add("SP");
//outros estados
ArrayList nova = new ArrayList(lista); //criando baseado na primeira lista
```

Quanto mais sabemos sobre as classes Java padrão mais fácil fica o nosso código.