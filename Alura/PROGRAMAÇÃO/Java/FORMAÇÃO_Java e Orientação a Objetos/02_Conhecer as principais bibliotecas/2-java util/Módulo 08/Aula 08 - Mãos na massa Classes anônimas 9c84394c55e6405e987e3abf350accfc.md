# Aula 08 - Mãos na massa: Classes anônimas

1) Vamos começar organizando a casa igual ao vídeo (se já fez pule para item 2).

- renomeie a classe `Teste` para `TesteOrdenacao`!
- copie a classe `TesteOrdenacao` e renomeia a cópia para `Teste`.
- no arquivo `Teste.java` provisoriamente renomeie as classes de comparator para `NumeroDaContaComparator2` e `TitularDaContaComparator2`

2) Escreva a primeira classe anônima. Retire o comparator do método `sort` e deixe o seguinte modo:

```
lista.sort(new Comparator<Conta>() {

    @Override
    public int compare(Conta c1, Conta c2) {
        return Integer.compare(c1.getNumero(), c2.getNumero());
    }
} //fim da classe anonima

);//fim do métodoCOPIAR CÓDIGO
```

3) (Opcional) Analogamente para a classe `TitularDaContaComparator`, teste o seguinte:

```
Comparator<Conta> comp = new Comparator<Conta>() {

    @Override
    public int compare(Conta c1, Conta c2) {
        String nomeC1 = c1.getTitular().getNome();
        String nomeC2 = c2.getTitular().getNome();
        return nomeC1.compareTo(nomeC2);
    }
};COPIAR CÓDIGO
```

4) Teste o código. Tudo deve estar compilando e rodando normalmente.