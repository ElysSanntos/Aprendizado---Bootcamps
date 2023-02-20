# Aula 05 - Mão na massa: Modificadores de acesso

Esse é o momento de fazer o que foi visto no vídeo!

---

1) Em **Conta**, apague o modificador de acesso **public** e repare que seu código no package de teste deixa de compilar. Removendo o modificador de acesso, transformamos a classe em **package private**, ou seja, só é visível dentro do pacote em que ela está contida.

2) Crie uma nova classe, utilizamos o nome **ContaEspecial**, selecione a *superclass* (Conta), crie também um package **especial** para a classe criada.

3) Temos um erro de compilação, corrija-o implementando o construtor.

4) Na classe **Conta**, remova o **protected** do atributo saldo, transformando-o em **package private**.

5) Veja que mesmo a classe **ContaEspecial** sendo uma classe filha de **Conta**, ela não tem acesso ao atributo **package private**.

6) Coloque novamente o **protected** e verifique que sua classe filha volta a ter acesso ao atributo da classe mãe mesmo estando em outro pacote.

OBS: Só é visível para os filhos!