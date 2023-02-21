# Aula 06 - Foreach com lambda

Veja o código usando um `for` "tradicional":

```
List<String> nomes = new ArrayList<>();
nomes.add("Super Mario");
nomes.add("Yoshi");
nomes.add("Donkey Kong");

for(int i = 0; i < nomes.size(); i++) {
    System.out.println(nomes.get(i));
}COPIAR CÓDIGO
```

Você gostou das lambdas e gostaria de usá-las também na hora do laço. Qual alternativa usa corretamente a expressão lambda para iterar os elementos da lista?

*Obs: Todas as alternativas abaixo realmente funcionam mas apenas uma usa lambdas.*

*Selecione uma alternativa*

`nomes.forEach((nome) -> System.out.println(nome));`

Corretíssima! A linguagem evoluiu muito como esse exercício mostra. Nas primeiras versões realmente era burocrático iterar as listas. Com as lambdas, o laço (`for`) se tornou uma simples chamada de um método. Muito legal!