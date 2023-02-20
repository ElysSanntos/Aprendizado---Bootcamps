# Aula 07 - Como compilar?

Veja a estrutura seguinte:

```
src
  br
    gov
      rio
        sicis
          Usuario.javaCOPIAR CÓDIGO
```

E o código fonte da classe `Usuario`:

```
//AQUI

public class Usuario {

  //atributos e métodos omitidos
}COPIAR CÓDIGO
```

Assumindo que a pasta `src` é a raiz do nosso código fonte. O que devemos colocar no lugar de `//AQUI` para compilar a classe `Usuario` com sucesso?

`package br.gov.rio.sicis;`

Correto, o *package* possui todos os nomes dos diretórios separado pelo caracter `.` (ponto).

- o *package*  deve conter *todos* os nomes dos diretórios separado pelo caracter `.`  (ponto) e sem o nome da classe: