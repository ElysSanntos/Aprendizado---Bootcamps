# Aula 03 - O que acontece?

Veja o código abaixo:

```
Comparator<String> comp = new Comparator<String>() {

  @Override
  public int compare(String s1, String s2) {
    return s1.compareTo(s2);
  }
};COPIAR CÓDIGO
```

E as declarações

- A) É gerada uma classe anônima.
- B) É criado um objeto do tipo `Comparator`.
- C) É instanciada a interface `Comparator`.
- D) É gerada uma classe com o nome o `ComparatorString`.

Quais afirmações são corretas?

*Selecione uma alternativa*

A e B

Correto, é gerada uma classe anônima (A) e é criado um objeto do tipo `Comparator (B)`.